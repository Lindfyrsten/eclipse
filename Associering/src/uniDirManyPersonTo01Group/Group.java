package uniDirManyPersonTo01Group;

public class Group {
    private String name;

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

}
