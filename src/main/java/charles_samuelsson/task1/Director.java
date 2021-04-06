package charles_samuelsson.task1;

public class Director extends Employee {

    public Director() {
        this.leadership = "Директор";
    }

    @Override
    public String getResponsibilities() {
        return super.getResponsibilities() + "управление фирмой.";
    }
}
