
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {
        inputDialog();
        System.out.println("пока, пока");
//            invertArray();
//              fillArr();
//            minMax();
//            changeArr();
//            fillDiagonal();

    }

    public static void inputDialog() {
        String[] choice = {"1. Заменить 0 на 1, 1 на 0", "2. Заполнить массив значениями 0 3 6 9...",
                "3. Задать массив, числа меньшие 6 умножить на 2",
                "4. Заполнить диагональные элементы массива единицами",
                "5. Найти минимальный и максимальный элементы"};
        String n = (String) JOptionPane.showInputDialog(null, "Выберите номер задания :",
                " - Домашнее задание - Массивы -", JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);
        if (n == choice[0]) {
            invertArray();
            inputDialog();
        }
        if (n == choice[1]) {
            fillArr();
            inputDialog();
        }
        if (n == choice[2]) {
            changeArr();
            inputDialog();
        }
        if (n == choice[3]) {
            int[][] table = new int[8][8];
            fillDiagonal(table);
            inputDialog();
        }
        if (n == choice[4]) {
            minMax();
            inputDialog();
        }
        //        else return;

    }


    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        String text = " -- противоположный массив --";
        String title = "- Задание 1. -";
        text += "\n";
//        for (int i : arr) {
//            System.out.print(i + " ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            text += arr[i];
        }
        System.out.println(" - исходный массив");


        text += "\n";
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] != 1 ? 1 : 0);

            text += arr[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println(" - противоположный");

        JOptionPane.showMessageDialog(null, text, title, JOptionPane.PLAIN_MESSAGE);
        System.out.println();
    }


    public static void fillArr() {
        String text = " складываем 3+3...";
        String title = "- Задание 2. -";
        text += "\n";
        int[] arr2 = new int[8];
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = j;
            j += 3;
            text += arr2[i] + " |";
            System.out.print(arr2[i] + " ");
        }
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.PLAIN_MESSAGE);
        System.out.println();
        System.out.println();
    }


    public static void changeArr() {
        int[] change = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < change.length; i++) {
            if (change[i] < 10) {
                System.out.print(" " + change[i] + " ");
            } else System.out.print(" " + change[i]);
        }
        System.out.println(" - исходный массив");

        for (int a = 0; a < change.length; a++) {
            if (change[a] < 6) {
                change[a] *= 2;
            }
            if (change[a] < 10) {
                System.out.print(" " + change[a] + " ");
            } else
                System.out.print(" " + change[a]);
        }
        System.out.println(" - if<6 then x2");
        System.out.println();
    }


    public static void fillDiagonal(int[][] table) {
     //   int[][] table = new int[8][8];
        for (int c = 0, m = table.length; c < table.length; c++, m--) {
            for (int i = 0; i < table.length; i++) {
                table[c][c] = 1;
                table[c][m - 1] = 1;
                System.out.print(table[c][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void minMax() {

        int[] arr = {-26, 5, 3, 1, 11, 4, 5, 2, 4, 8, -9, 20, 270, 35, -50, 45};
        String title = "- Задание 5.";
        String text = " мин и МАКС ";
        text += "\n";
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (arr[i] > max ? 1 : 0);
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            text += arr[i] + " |";
            System.out.print(arr[i] + " |");
        }
        text += "\n";
        text += " максимальный элемент " + max + "\n";
        text += " минимальный элемент " + min;
        System.out.println();
        System.out.println("макс " + max);
        System.out.println("мин " + min);
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.PLAIN_MESSAGE);
        System.out.println();
    }
}

