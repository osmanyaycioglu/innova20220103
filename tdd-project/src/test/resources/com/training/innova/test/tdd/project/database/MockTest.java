package com.training.innova.test.tdd.project.database;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    MyMockTest             mockTest;

    @Spy
    MyMockTest             spyTest;

    @Captor
    ArgumentCaptor<String> helloExCaptor;

    @Test
    public void test1() {
        Mockito.when(this.mockTest.hello())
               .thenReturn("hello")
               .thenReturn("merhaba")
               .thenReturn("Ola");
        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("hello");
        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("merhaba");
        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("Ola");
        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("Ola");
    }

    @Test
    public void test2() {
        Mockito.doReturn("merhaba")
               .when(this.mockTest)
               .hello();
        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("merhaba");
    }

    @Test
    public void test3() {
        Mockito.when(this.mockTest.helloExt(ArgumentMatchers.any()))
               .thenReturn("hello osman");

        Assertions.assertThat(this.mockTest.helloExt("sduıfhhfdgbhj"))
                  .isEqualTo("hello osman");

    }

    @Test
    public void test4() {
        Mockito.when(this.mockTest.helloExt(null))
               .thenThrow(new IllegalArgumentException("Null olamaz"));

        Assertions.assertThatThrownBy(() -> this.mockTest.helloExt(null))
                  .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void test5() {
        Mockito.doReturn("hello veli")
               .when(this.spyTest)
               .helloExt("ali");
        Assertions.assertThat(this.spyTest.helloExt("osman"))
                  .isEqualTo("hello osman");
        Assertions.assertThat(this.spyTest.helloExt("ali"))
                  .isEqualTo("hello veli");
    }

    @Test
    public void test6() {
        Mockito.when(this.mockTest.helloExt(ArgumentMatchers.any()))
               .thenAnswer(i -> "hello " + i.getArgument(0) + " test");

        Mockito.when(this.mockTest.hello())
               .thenAnswer(MockTest::helloInterceptor);

        Assertions.assertThat(this.mockTest.helloExt("ali"))
                  .isEqualTo("hello ali test");

        Assertions.assertThat(this.mockTest.helloExt("veli"))
                  .isEqualTo("hello veli test");

        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("intercepted hello");
    }

    public static Object helloInterceptor(final InvocationOnMock i) throws Throwable {
        String callRealMethodLoc = (String) i.callRealMethod();
        return "intercepted " + callRealMethodLoc;
    }

    @Test
    public void test7() {
        Mockito.when(this.mockTest.helloExt(ArgumentMatchers.any()))
               .thenAnswer(i -> "hello " + i.getArgument(0) + " test");

        Mockito.when(this.mockTest.help())
               .thenAnswer(i -> i.callRealMethod());

        Mockito.when(this.mockTest.hello())
               .thenAnswer(MockTest::helloInterceptor);

        Assertions.assertThat(this.mockTest.helloExt("ali"))
                  .isEqualTo("hello ali test");

        Assertions.assertThat(this.mockTest.helloExt("ali"))
                  .isEqualTo("hello ali test");

        Assertions.assertThat(this.mockTest.helloExt("veli"))
                  .isEqualTo("hello veli test");

        Assertions.assertThat(this.mockTest.hello())
                  .isEqualTo("intercepted hello");

        Assertions.assertThat(this.mockTest.help())
                  .isEqualTo("help");

        Mockito.verify(this.mockTest,
                       Mockito.atLeast(1))
               .hello();

        Mockito.verify(this.mockTest,
                       Mockito.atLeast(2))
               .helloExt(ArgumentMatchers.anyString());

        Mockito.verify(this.mockTest,
                       Mockito.atLeast(1))
               .helloExt("ali");
        Mockito.verify(this.mockTest,
                       Mockito.atLeast(1))
               .helloExt("veli");

        Mockito.verify(this.mockTest,
                       Mockito.times(2))
               .helloExt("ali");

        Mockito.verify(this.mockTest,
                       Mockito.never())
               .greet();

        Mockito.verify(this.mockTest,
                       Mockito.timeout(200))
               .help();
    }

    @Test
    public void test8() {
        Mockito.when(this.mockTest.helloExt(ArgumentMatchers.any()))
               .thenReturn("test");

        this.mockTest.helloExt("ali");
        this.mockTest.helloExt("ali");
        this.mockTest.helloExt("veli");
        Mockito.verify(this.mockTest,
                       Mockito.times(3))
               .helloExt(this.helloExCaptor.capture());
        List<String> allValuesLoc = this.helloExCaptor.getAllValues();
        System.out.println(allValuesLoc);
        Assertions.assertThat(allValuesLoc)
                  .contains("ali")
                  .containsSequence("ali",
                                    "ali",
                                    "veli");
    }

    @Test
    public void test9() {
        ArgumentMatcher<String> myMatcherLoc = s -> {
            if ("a".equals(s) || "v".equals(s) || "os".equals(s)) {
                return true;
            }
            return false;
        };
        Mockito.when(this.mockTest.helloExt(ArgumentMatchers.argThat(myMatcherLoc)))
               .thenReturn("test return");
        System.out.println(this.mockTest.helloExt("a"));
        System.out.println(this.mockTest.helloExt("v"));
        System.out.println(this.mockTest.helloExt("os"));
        System.out.println(this.mockTest.helloExt("osman"));
    }

}
