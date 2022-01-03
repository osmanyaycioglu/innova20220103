package com.training.innova.test.common;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@Retention(RUNTIME)
@Target(METHOD)
@Tag("all")
@Test
@DisabledIf("checkIfDisabled")
@EnabledOnOs(OS.WINDOWS)
@EnabledIfSystemProperty(named = "my.sys.prop.enable.test", matches = "true", disabledReason = "doğru parametre yok")
public @interface AllTestOnWindows {

}
