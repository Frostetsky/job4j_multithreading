package concurrent.threads;

public class Dog implements Voice {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void vc() {
        System.out.println("гав-гав");
    }

    @Override
    public String toString() {
        return name + " | " + age;
    }
}
