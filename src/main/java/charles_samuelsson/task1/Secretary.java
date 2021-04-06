package charles_samuelsson.task1;

public class Secretary extends Employee {

    public Secretary() {
        this.leadership = "Секретарь";
    }

    @Override
    public String getResponsibilities() {
        return super.getResponsibilities() + "принимать звонки.";
    }
}
