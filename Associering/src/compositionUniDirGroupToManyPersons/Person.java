package compositionUniDirGroupToManyPersons;

public class Person {
	private String name;

	Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}
}
