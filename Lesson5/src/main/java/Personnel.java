import java.util.Arrays;

public class Personnel {
    //    Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//    Конструктор класса должен заполнять эти поля при создании объекта.
//    Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//    Создать массив из 5 сотрудников.
    private static final int CURRENT_YEAR = 2020;
    private String name;
    private String position;
    private int birthYear;
    private int age;
    private String email;
    private String phone;
    private int salary;


    public Personnel(String name, String position, String email, String phone, int salary, int birthYear) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age = CURRENT_YEAR - birthYear;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getPosition() {
        return this.position;
    }

    public String toString() {
        return "ФИО: " + name + " \tдолжность: " + position + "\t  E-mail: " + email + "\t    телефон: " + phone + "\t зп: " + salary + "\t возраст: " + age + "\tгод рождения: " + birthYear;

    }

    public void printAllStaff() {
        System.out.println(this);
    }

    public void print() {
        System.out.println("ФИО: " + name + " \tдолжность: " + position + "\t  E-mail: " + email + "\t    телефон: " + phone + "\t зп: " + salary + "\t возраст: " + age);
    }

}
