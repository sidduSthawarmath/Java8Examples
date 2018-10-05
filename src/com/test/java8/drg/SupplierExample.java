package com.test.java8.drg;

import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		Supplier<String> generateOTP = () -> {
			String otp = "";
			for (int i = 0; i < 6; i++) {
				otp = otp + (int) (Math.random() * 10);
			}
			return otp;
		};

		System.out.println("Generated OTP: " + generateOTP.get());
		System.out.println("Generated OTP: " + generateOTP.get());
	}
}
