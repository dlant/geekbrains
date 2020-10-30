//1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
//        2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
//        потом текст из второго в новый файл.
//        3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово
//        в файле (работаем только с латиницей).
//        4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке
//        5. *** Написать метод, добавляющий, указанное слово в файлы в папке


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        String file = "D://testDir//test.txt";
        String fileOut = "D://testDir//test3.txt";
        String file2 = "D://testDir//test2.txt";

        fileWriter(file, fileOut);
        fileWriter(file2, fileOut);

        System.out.println(checkWord(file, "angel"));          // 3

        String path = "D://testDir";
        System.out.println(Arrays.toString(dir((path), "dreams")));      // 4

        addWordToFile(path, ".... A.S.Pushkin");            // 5

    }

    private static void fileWriter(String fileIn, String fileOut) {
        try {
            Scanner scan = new Scanner(new FileInputStream(fileIn));
            PrintStream ps = new PrintStream(new FileOutputStream(fileOut, true));
            while (scan.hasNextLine()) {
                ps.print(scan.nextLine());
            }
            ps.close();
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkWord(String file, String word) {
        try {
            Scanner scan = new Scanner(new FileInputStream(file));
            while (scan.hasNext()) {
                while (scan.next().equals(word)) return true;
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String[] dir(String path, String word) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            String[] arr = new String[dir.listFiles().length];
            for (int i = 0; i < dir.listFiles().length; i++) {

                String file = dir.listFiles()[i].getName();

                String filePath = path + "//" + file;
                arr[i] = String.valueOf(checkWord(filePath, word));
            }
            return arr;
        }
        return new String[0];
    }


    public static void addWordToFile(String path, String word) {
        File dir = new File(path);

        for (File item : dir.listFiles()) {

            String file = item.getName();
            String filePath = path + "//" + file;
            try {
                PrintStream ps = new PrintStream(new FileOutputStream(filePath, true));
                ps.println(word);
                ps.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
}




