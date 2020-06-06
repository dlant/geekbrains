import java.sql.SQLOutput;

public class MainClass {
    public static void main(String[] args) {
        Personnel[] staff = new Personnel[5];
        staff[0] = new Personnel("Ivan Smirnov", "security", "jail@mail.ru", "89995553231",
                40000,1994);
        staff[1] = new Personnel("Alex Ivanov", "engineer", "knowhow@gmail.com", "89018785421",
                80000, 1979);
        staff[2] = new Personnel("Maria Petrova", "economist", "cash@mail.ru", "89257775511",
                80000, 1989);
        staff[3] = new Personnel("Ashot Berdyev", "driver", "yzbek@gmail.com", "89515443256",
                40000, 1975);
        staff[4] = new Personnel("Sergei Belov", "medic", "cureit@yandex.ru", "89283217678",
                60000, 1978);
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t Список сотрудников старше 40 лет\n");
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40) {staff[i].print();}
//            staff[i].getAge();
//            staff[i].printAllStaff();
//            if(staff[i].getPosition().equals("driver")){staff[i].print();}

//            if(staff[i].getSalary()> 60000){staff[i].print();}

        }
    }
}