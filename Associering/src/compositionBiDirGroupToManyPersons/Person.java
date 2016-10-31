package compositionBiDirGroupToManyPersons;

public class Person {
	private String name;
	private Group group;

	Person(String name, Group group) {
		this.name = name;
		this.group = group;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

	public Group getGroup() {
		return group;
	}
}
