package charles_samuelsson.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Firm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Введите должность.");
        String speciality = reader.readLine();
        Employee employee = createEmployeeBySpeciality(speciality);
        System.out.println("2. Введите ФИО.");
        String name = reader.readLine();
        employee.setFull_name(name);
        System.out.println("3. Введите образование.");
        String education = reader.readLine();
        employee.setEducation(education);
        System.out.println("4. Введите дату рождения");
        String birthday = reader.readLine();
        employee.setDate(birthday);

        System.out.println(employee.toString() + System.lineSeparator() + employee.getResponsibilities());

        reader.close();
    }

    private static Employee createEmployeeBySpeciality(String speciality) {
        if (speciality.equalsIgnoreCase("директор")) {
            return new Director();
        } else if (speciality.equalsIgnoreCase("секретарь")) {
            return new Secretary();
        } else if (speciality.equalsIgnoreCase("разработчик сайтов")) {
            return new WebProgrammer();
        } else if (speciality.equalsIgnoreCase("уборщица")) {
            return new Cleaner();
        } else {
            throw new IllegalArgumentException("Некорректная должность");
        }
    }
}
