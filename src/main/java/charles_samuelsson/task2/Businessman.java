package charles_samuelsson.task2;

public class Businessman extends Human implements Informational {

    public Businessman(String firstname, String lastname, char sex, int age) {
        super(firstname, lastname, sex, age);
    }

    @Override
    public String info() {
        return getPrivateWord() + this.toString() + "Фирма: Альфа-Банк.";
    }
}
