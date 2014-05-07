package ch16.ex16_04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface StringValueAnnotation {
	String value(); 
}

@StringValueAnnotation(value = "数値")
class UseSample {
	int n;
}