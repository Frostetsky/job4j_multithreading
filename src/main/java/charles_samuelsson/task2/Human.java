package charles_samuelsson.task2;

import java.util.Objects;

public class Human {

    String firstname;
    String lastname;
    char sex;
    int age;

    public Human(String firstname, String lastname, char sex, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return sex == human.sex
                && age == human.age
                && Objects.equals(firstname, human.firstname)
                && Objects.equals(lastname, human.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, sex, age);
    }

    @Override
    public String toString() {
        return firstname + " | " + lastname + " | " + sex + " | " + age + System.lineSeparator();
    }
}
