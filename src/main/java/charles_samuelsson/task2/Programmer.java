package charles_samuelsson.task2;

public class Programmer extends Human implements Informational {

    public Programmer(String firstname, String lastname, char sex, int age) {
        super(firstname, lastname, sex, age);
    }

    @Override
    public String info() {
        return getPrivateWord() + this.toString() +
                "Сфера деятельности и язык программирования: Бекэнд разработка, язык Java.";
    }
}
