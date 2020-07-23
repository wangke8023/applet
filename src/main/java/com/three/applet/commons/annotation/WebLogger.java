package com.three.applet.commons.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLogger {
	String value() default "";
	String test() default "";
}
