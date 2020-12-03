package br.com.confidencecambio.javabasico.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

import javax.naming.InvalidNameException;

import org.springframework.util.StringUtils;

class Nominable {

	private String name;

	public Nominable(final String name) throws InvalidNameException {
		validateNull(name);
		validateEmpty(name);
		validateExtraSpaces(name);
		setName(name);
	}

	/**
	 * @return the first name
	 */
	public String getFirstName() {
		final String[] nameArray = transformNameInWordsArray();
		return nameArray[0];
	}

	/**
	 * @return the last name
	 */
	public String getLastName() {
		final String[] nameArray = transformNameInWordsArray();
		return formateLastName(nameArray);

	}

	/**
	 * @return the name in all UpperCase
	 */
	public String getNameInUpperCase() {
		return getName().toUpperCase();

	}

	/**
	 * @return the short name
	 */
	public String getShortName() {
		final String[] nameArray = transformNameInWordsArray();
		String shortName = formateShortName(nameArray);
		return shortName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	private void validateExtraSpaces(final String name) throws InvalidNameException {
		if (!Objects.equals(name, name.strip()))
			throw new InvalidNameException("Name has whites spaces in the begin or end!");
	}

	private void validateEmpty(final String name) throws InvalidNameException {
		if (StringUtils.isEmpty(name))
			throw new InvalidNameException("Name is empty!");
	}

	private void validateNull(final String name) throws InvalidNameException {
		if (Objects.isNull(name))
			throw new InvalidNameException("Name is null!");
	}

	private String[] transformNameInWordsArray() {
		String nameTemp = getName();
		return Arrays.stream(nameTemp.split("\\s+|,\\s*|\\.\\s*")).map(String::strip).toArray(String[]::new);
	}

	private String formateLastName(final String[] nameArray) {
		StringJoiner shortName = new StringJoiner(" ");
		for (int i = 1; i < nameArray.length; i++) {
			shortName.add(nameArray[i]);
		}
		return shortName.toString();
	}

	private String formateShortName(final String[] nameArray) {
		StringJoiner shortName = new StringJoiner(" ");
		for (int i = 0; i < nameArray.length; i++) {
			if (i == 0 || i == nameArray.length - 1)
				shortName.add(nameArray[i]);
			else
				shortName.add(Character.toUpperCase(nameArray[i].charAt(0)) + ".");
		}
		return shortName.toString();
	}
}
