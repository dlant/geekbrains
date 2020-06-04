import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon",
                "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        do {
            int attempt = 1;
            System.out.println("Угадай слово:");
            int cpu = rand.nextInt(words.length);       // получаем номер слова в массиве
            String cpuWord = words[cpu];                // вытягиваем слово из массива
            boolean run = true;
            while (run) {
                String userWord = sc.next();

                if (!userWord.equals(cpuWord)) {
                    compareWords(cpuWord, userWord);
                    if(cpuWord.length()!=userWord.length())
                    attempt++;
                } else {
                    run = false;
                }
            }
            System.out.println(attempt >3 ? "Ну ты и тормоз)":"Слишком легкое слово для тебя");
            System.out.println(attempt >= 2 ? "C " + attempt + " попытки!" : "Блин с первой попытки!");
            System.out.println(attempt >3 ? "неужели догадался !? Я загадал слово " + cpuWord:"как ты догадался!? Я загадал слово " + cpuWord);
            System.out.println(" Сыграем еще? Да-1, Нет-0");
        } while (sc.nextInt() == 1);
        System.out.println("слабак)");
    }

    public static void compareWords(String cpuWord, String userInput) {

        int counter = 0;                                          //счетчик угаданных букв
        char[] tmp = new char[cpuWord.length()];
        Arrays.fill(tmp, '*');                        // заполняем временный массив '*' длиной слова компьютера
        for (int i = 0; i < cpuWord.length(); i++) {
            char cpu = cpuWord.charAt(i);                               // букву слова компьютера
            for (int j = 0; j < userInput.length(); j++) {       // сравниваем с каждой буквой слова пользователя
                char user = userInput.charAt(j);
                if (cpu == user) {
                    tmp[i] = cpu;                                // пишем в tmp при совпадении
                }
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != '*') {                    //сколько букв угадали
                counter++;
            }
        }

        if(userInput.length() > tmp.length && tmp.length==counter || userInput.length() < tmp.length && tmp.length==counter  ){
            System.out.println("Читер, ты ошибся буквой, но я все равно не знаю такого слова, я тупой");
            System.out.println("Напиши слово правильно,я проверю еще раз:");
            counter++;
        }
        if(counter<tmp.length){
        System.out.print(tmp);
        System.out.print("*********");
        System.out.println();
        System.out.println(counter<2&&counter!=0?"кое что угадал":"а если подумать?");
        System.out.println(counter > 1 && counter < 5 ? "Хорошая попытка, ты угадал " + counter + " буквы" : "Попробуй еще разок:");
        }

}}