package charles_samuelsson.task1;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Employee extends Human {
    String full_name;
    String birthday;
    String leadership;
    String education;

    public Employee() {
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate() {
        return birthday;
    }

    public void setDate(String birthday) {
        this.birthday = birthday;
    }

    public String getLeadership() {
        return leadership;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getResponsibilities() {
        return "Обязанности: ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(full_name, employee.full_name)
                && Objects.equals(birthday, employee.birthday)
                && Objects.equals(leadership, employee.leadership)
                && Objects.equals(education, employee.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(full_name, birthday, leadership, education);
    }

    @Override
    public String toString() {
        return "Данные: " + full_name + " | " + birthday + " | " + leadership + " | " + education;
    }
}
