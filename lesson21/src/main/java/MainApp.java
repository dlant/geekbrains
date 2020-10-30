
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
//         invertArray();
//       fillArray();
//        changeArray();

//        int[][] tableX = new int[10][10];
//        fillDiagonal(tableX);

//        int[][] table = new int[10][10];
//        fillDiagonal2(table);

//       minMax();

//        int[] array = {1, 10, 2, 1, 2, 2, 2, 2};
//       System.out.println(" " + checkSum(array));

        int[] table = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n=3;
        System.out.println(Arrays.toString(pushArray((table),n)));

    }


    public static void invertArray() {                          //  1)заменить 0 на 1, 1 на 0;
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" - исходный массив");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] != 1 ? 1 : 0);

            System.out.print(arr[i] + " ");
        }
        System.out.println(" - противоположный");
        System.out.println();
    }


    public static void fillArray() {                        //  2) заполнить массив;
        int[] arr = new int[8];
        int j = 0;
        for (int i : arr) {
//      for (int i = 0; i < arr.length; i++) {
            arr[i] = j;
            j += 3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }


    public static void changeArray() {                             //  3) числа меньшие 6 умножить на 2;
        int[] change = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int base : change)
            System.out.printf("%3d", change);
        System.out.println(" - исходный массив");

        for (int a = 0; a < change.length; a++) {
            if (change[a] < 6) {
                change[a] *= 2;
            }
            System.out.printf("%3d", change[a]);
        }
        System.out.println(" - if<6 then x2");
        System.out.println();
    }

    public static void fillDiagonal2(int[][] table) {                //  4.1)заполнить диагонали все
//        int [][] table = new int[8][8];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    table[i][j] = 1;
                }
                System.out.printf("%3d", table[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fillDiagonal(int[][] table) {                        // 4) заполнить диагонали с угла в угол
        //   int[][] table = new int[8][8];
        if (table[0].length != table.length) {
            System.out.println("Проверьте длину массива, кол-во столбцов = кол-во строк");
            return;
        }
        for (int i = 0, m = table.length; i < table.length; i++, m--) {
            for (int j = 0; j < table.length; j++) {
                table[i][i] = 1;                            // координаты единицы меняются синхронно
                table[i][m - 1] = 1;                        //
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void minMax() {                                   // 5)  найти мин и макс

        int[] arr = {-26, 5, 3, 1, 11, 4, 5, 2, 4, 8, -9, 20, 270, 35, -50, 45};
        int max = arr[0];
        int min = max;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            // System.out.print(arr[i] + " |");
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("макс " + max);
        System.out.println("мин " + min);
        System.out.println();
    }


    static boolean checkSum(int[] arr) {                       //6) если долго мучиться, что-нибудь получится..
        int sumLeft = 0;
        int sumRight = 0;
        int counter = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            sumRight += arr[i];                                 // сумма элементов справа
            for (int j = 0; j < arr.length - counter; j++) {
                sumLeft += arr[j];                              // сумма элементов слева
            }
            if (sumLeft == sumRight) {
                System.out.println("Stop,:) " + sumRight + "=" + sumLeft + " ");
                System.out.print("Сумма " + (arr.length - counter) + " элементов cлева,");
                System.out.println(" равна " + (counter) + "" + " элементам справа:");
                System.out.println(Arrays.toString(arr));
                return true;
            }

            sumLeft = 0;                    // обнуляем сумму слева, обновляем счетчик элементов
            counter++;                      // погнали снова сравнивать
        }
        System.out.println("so sad :( ");
        return false;
    }

    public static int[] pushArray(int[] arr, int n) {        /// 7) уши вянут, мозги кипят 3дня((...
        if (n < 0){
            n = -n;
            for(int i = 0; i < n;i++)
            {
                int tmp = arr[0];                       // запоминаем первый
                for(int j = 0;j<arr.length-1;j++){
                    arr[j]=arr[j+1];                    // пишем второй в первый
                }
                arr[arr.length-1]=tmp;                  // вспоминаем первый, пишем его в последний
            }
            System.out.println("Сдвинули массив на "+n+" элементов влево");
            return arr;
        }

        for(int i = 0; i < n;i++)
        {
            int tmp = arr[arr.length-1];                // запоминаем последний
            for(int j=arr.length-1;j>0;j--) {
                arr[j] = arr[j - 1];                    // пишем предпоследний в последний
            }
            arr[0]=tmp;                                 // вспоминаем(склероз) последний, пишем в первый
        }
        System.out.println("Сдвинули массив на "+n+" элементов вправо");
        return arr;
    }
}



