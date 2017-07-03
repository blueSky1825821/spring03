package com.prince.validator.test;

import com.prince.validator.Rule.AnnotationRule;
import com.prince.validator.Validator;

public class TestValidator {
	public static void main(String[] args) {
		new Validator().validate(new AnnotationRule(new User()));
	}
}
