package charles_samuelsson.task2;

public interface Informational {
    String info();

    default String getPrivateWord() {
        return "Информация о сотруднике:" + System.lineSeparator();
    }
}
