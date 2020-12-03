package br.com.confidencecambio.javabasico.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BodyMassIndexServiceTest {
	private BodyMassIndexService service;

	@Before
	public void init() {
		service = new BodyMassIndexService();
	}

	@Test
	public void shouldCalculateBMIIfHasWeightAndHeight() {
		// prepare
		final Float weight = 70.100f;
		final Float height = 1.72f;
		final float resultExpect = 23.69524f;

		// execute
		Float bmi = service.calculate(weight, height);

		// validate
		assertNotNull(bmi);
		assertEquals(resultExpect, bmi);
	}

	@Test
	public void shouldCalculateBMICorreted() {
		// prepare
		final Float weight = 70.100f;
		final Float height = 1.72f;
		final float resultExpect = 23.69524f;

		// execute
		Float bmi = service.calculate(weight, height);

		// validate
		assertNotNull(bmi);
		assertEquals(resultExpect, bmi);
	}

}
