package charles_samuelsson.task1;

public class Cleaner extends Employee {

    public Cleaner() {
        this.leadership = "Уборщица";
    }

    @Override
    public String getResponsibilities() {
        return super.getResponsibilities() + "уборка помещений.";
    }
}
