package ex16_04;

@interface StringValueAnnotation {
	String value(); 
}

class UseSample {
	@StringValueAnnotation(value = "数値")
	int n;
}