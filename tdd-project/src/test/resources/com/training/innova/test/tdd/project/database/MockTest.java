package com.training.innova.test.tdd.project.database;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    MyMockTest mockTest;

    @Spy
    MyMockTest spyTest;


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

}
