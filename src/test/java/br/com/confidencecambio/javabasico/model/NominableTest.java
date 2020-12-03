package br.com.confidencecambio.javabasico.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.naming.InvalidNameException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NominableTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test()
	public void shouldReturnShortName() throws InvalidNameException {
		// prepare
		final String shortName = "Camilla M. U. Cyrino";

		// execute
		Nominable nominable = createNominable();

		// validate
		assertNotNull(nominable);
		assertEquals(shortName, nominable.getShortName());
	}

	@Test()
	public void shouldReturnUpperCaseName() throws InvalidNameException {
		// prepare
		final String upperCaseName = "CAMILLA MOREIRA UCHOA CYRINO";

		// execute
		Nominable nominable = createNominable();

		// validate
		assertNotNull(nominable);
		assertEquals(upperCaseName, nominable.getNameInUpperCase());
	}

	@Test()
	public void shouldReturnFirstName() throws InvalidNameException {
		// prepare
		final String firstName = "Camilla";

		// execute
		Nominable nominable = createNominable();

		// validate
		assertNotNull(nominable);
		assertEquals(firstName, nominable.getFirstName());
	}

	@Test()
	public void shouldReturnLastName() throws InvalidNameException {
		// prepare
		final String lastName = "Moreira Uchoa Cyrino";

		// execute
		Nominable nominable = createNominable();

		// validate
		assertNotNull(nominable);
		assertEquals(lastName, nominable.getLastName());
	}

	@Test()
	public void shouldCreateNominableIfNameIsNotNullAndEmptyAndWithExtrasSpaces() throws InvalidNameException {
		// prepare
		final String name = "Camilla Moreira Uchoa Cyrino";

		// execute
		Nominable nominable = createNominable();

		// validate
		assertNotNull(nominable);
		assertEquals(name, nominable.getName());
	}

	@Test()
	public void shouldNotCreateNominableIfNameIsNull() throws InvalidNameException {
		// prepare
		final String name = null;

		// validate
		exceptionRule.expect(InvalidNameException.class);
		exceptionRule.expectMessage("Name is null!");

		// execute
		Nominable nominable = new Nominable(name);

	}

	@Test()
	public void shouldNotCreateNominableIfNameIsEmpty() throws InvalidNameException {
		// prepare
		final String name = "";

		// validate
		exceptionRule.expect(InvalidNameException.class);
		exceptionRule.expectMessage("Name is empty!");

		// execute
		Nominable nominable = new Nominable(name);
	}

	@Test()
	public void shouldNotCreateNominableIfNameIsWithExtrasSpaces() throws InvalidNameException {
		// prepare
		final String name = " Camilla Moreira Uchoa Cyrino ";

		// validate
		exceptionRule.expect(InvalidNameException.class);
		exceptionRule.expectMessage("Name has whites spaces in the begin or end!");

		// execute
		Nominable nominable = new Nominable(name);
	}

	private Nominable createNominable() throws InvalidNameException {
		final String name = "Camilla Moreira Uchoa Cyrino";
		return new Nominable(name);
	}

}
