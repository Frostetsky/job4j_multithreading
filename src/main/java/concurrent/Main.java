package concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Реализовать все методы классы Calculator

/* Предусмотреть выборку операций над двумя числами, если нужно посчитать разность, то нужно написать следующий код.
  if (condition.equals("Разность")) {
        int result = calculator.dif(a, b);
        System.out.println(result);
     }
 */

// по аналогии с показанным выше примером написать условия для всех методов.
// Незакомментированный код в main - НЕ ТРОГАТЬ!


public class Main {

    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String[] element = text.split(" ");
        int a = Integer.parseInt(element[0]);
        int b = Integer.parseInt(element[1]);
        String condition = "Разность";

        // int result = calculator.sum(a, b);
        // System.out.println(result);
    }
}

class Calculator {
    /**
     * @param a - 1-ое слагаемое
     * @param b - 2-ое слагаемое
     * @return сумма
     */
    public int sum(int a, int b) {
        // код
        return 0;
    }

    /**
     * @param a - уменьшаемое
     * @param b - вычитаемое
     * @return разность
     */
    public int dif(int a, int b) {
        // код
        return 0;
    }

    /**
     * @param a - 1-ый множитель
     * @param b - 2-ой множитель
     * @return - произведение
     */
    public int multiply(int a, int b) {
        // код
        return 0;
    }

    /**
     * @param a - делимое
     * @param b - делитель
     * @return частное
     */
    public double div(int a, int b) {
        // код
        return 0;
    }

    /**
     * @param a 1-ое число
     * @param b 2-ое число
     * @return остаток от деления a на b
     */
    public int mod(int a, int b) {
        // код
        return 0;
    }
}

