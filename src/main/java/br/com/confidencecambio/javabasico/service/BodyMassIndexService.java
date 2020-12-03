package br.com.confidencecambio.javabasico.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BodyMassIndexService {

	/**
	 * Calculates the Body Mass Index (BMI) using the weight weight in kilograms and
	 * height in meters squared.
	 * 
	 * @param weight {@link Float}
	 * @param height {@link Float}
	 * @return {@link float} value of Body Mass Index
	 */
	public float calculate(@NonNull final Float weight, @NonNull final Float height) {
		return (float) (weight / Math.pow(height, 2));
	}
}
