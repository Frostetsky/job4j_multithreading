package charles_samuelsson.task2;

public class Doctor extends Human implements Informational {

    public Doctor(String firstname, String lastname, char sex, int age) {
        super(firstname, lastname, sex, age);
    }

    @Override
    public String info() {
        return getPrivateWord() + this.toString() + "Ученая степень: Доктор наук.";
    }
}
