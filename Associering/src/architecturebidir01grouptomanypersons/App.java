package architecturebidir01grouptomanypersons;

public class App {
	public static void main(String[] args) {
		Group g1 = new Group("TeamA");

		Person p1 = Service.createPerson("Ulla", g1);
		Person p2 = Service.createPerson("Jens", g1);

		System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
		for (Person p : Storage.getAllPersons()) {
			System.out.printf("%s's group: %s.%n", p, p.getGroup());
		}
		System.out.println();

		Service.deletePerson(p1);

		System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
		for (Person p : Storage.getAllPersons()) {
			System.out.printf("%s's group: %s.%n", p, p.getGroup());
		}

		Group g2 = new Group("TeamB");
		Service.connectPersonToGroup(p2, g2);

		System.out.printf("%s's persons: %s.%n", g1, g1.getPersons());
		for (Person p : Storage.getAllPersons()) {
			System.out.printf("%s's group: %s.%n", p, p.getGroup());
		}
		System.out.println();

		System.out.printf("%s's persons: %s.%n", g2, g2.getPersons());
		for (Person p : Storage.getAllPersons()) {
			System.out.printf("%s's group: %s.%n", p, p.getGroup());
		}
		System.out.println();

	}
}
