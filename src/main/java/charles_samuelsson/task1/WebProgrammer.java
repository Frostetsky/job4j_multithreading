package charles_samuelsson.task1;

public class WebProgrammer extends Employee {

    public WebProgrammer() {
        this.leadership = "Разработчик сайтов";
    }

    @Override
    public String getResponsibilities() {
        return super.getResponsibilities() + "разработка онлайн-платформы.";
    }
}
