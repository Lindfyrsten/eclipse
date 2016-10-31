package compositionBiDirGroupToManyPersons;

import java.util.ArrayList;

public class Group {
	private String name;
	// link to Person objects (--> 0..*)
	private ArrayList<Person> persons = new ArrayList<>();

	public Group(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns a list of persons in this group.
	 */
	public ArrayList<Person> getPersons() {
		return new ArrayList<>(persons);
	}

	/**
	 * Creates and returns a person linked to this group.
	 */
	public Person createPerson(String personName) {
		Person person = new Person(personName, this);
		persons.add(person);
		return person;
	}

	/**
	 * Deletes the person.
	 */
	public void deletePerson(Person person) {
		persons.remove(person);
	}
}
