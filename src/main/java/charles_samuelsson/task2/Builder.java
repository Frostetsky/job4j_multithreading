package charles_samuelsson.task2;

public class Builder extends Human implements Informational {
    public Builder(String firstname, String lastname, char sex, int age) {
        super(firstname, lastname, sex, age);
    }

    @Override
    public String info() {
        return getPrivateWord() + this.toString() + "Профиль: Строительство уникальных зданий и сооружений.";
    }
}
