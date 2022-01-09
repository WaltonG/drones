package com.musala.drones.util;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	private static final String NAME_PATTERN = "^[A-Za-z0-9_-]*$";
	
	private static final Pattern namePattern = Pattern.compile(NAME_PATTERN);
	
	private static final Predicate<String> medicationNameValidator = name -> {
		Matcher matcher = namePattern.matcher(name);
		return matcher.matches();
	};
	
	private static final String CODE_PATTERN = "^[A-Z0-9_]*$";
	
	private static final Pattern codePattern = Pattern.compile(CODE_PATTERN);
	
	private static final Predicate<String> medicationCodeValidator = code -> {
		Matcher matcher = codePattern.matcher(code);
		return matcher.matches();
	};
	
	public static boolean isValidMedicationName(String name) {
		return medicationNameValidator.test(name);
	}
	
	public static boolean isValidMedicationCode(String code) {
		return medicationCodeValidator.test(code);
	}
}
