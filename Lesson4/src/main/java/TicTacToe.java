import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Ты меня сделал!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Ты проиграл железяке, как так то!?");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {

        int countDiagLeft = 0;
        int countDiagRight = 0;
        int diagLeft1 = 0;
        int diagLeft2 = 0;
        int diagRight1 = 0;
        int diagRight2 = 0;
        for (int i = 0; i < SIZE; i++) {
            int countRow = 0;
            int countCol = 0;
            if (map[i][i] == symb) countDiagLeft++;                 // 2 диагонали по центру
            if (map[i][SIZE - i - 1] == symb) countDiagRight++;
            if (map[i][i] != symb && countDiagLeft != DOTS_TO_WIN)
                countDiagLeft = 0;                                              //проверка что подряд по диагоналям
            if (map[i][SIZE - i - 1] != symb && countDiagLeft != DOTS_TO_WIN)
                countDiagRight = 0;

            for (int k = 1; k < SIZE; k++) {
                if (map[k][k - 1] == symb) diagLeft1++;                       /// малые диагонали 2 левых
                if (map[k - 1][k] == symb) diagLeft2++;
                if (map[k - 1][DOTS_TO_WIN - k] == symb) diagRight1++;          /// 2 правых
                if (map[k][SIZE - k] == symb) diagRight2++;
            }
//            if(map[1][0]==symb && map[2][1]==symb && map[3][2]==symb && map[4][3]==symb) return true;
//            if(map[0][1]==symb&&map[1][2]==symb&&map[2][3]==symb&&map[3][4]==symb) return true;
//            if(map[0][3]==symb&&map[1][2]==symb&&map[2][1]==symb&&map[3][0]==symb) return true;
//            if(map[1][4]==symb&&map[2][3]==symb&&map[3][2]==symb&&map[4][1]==symb) return true;
            if (diagLeft1 == DOTS_TO_WIN || diagLeft2 == DOTS_TO_WIN || diagRight1 == DOTS_TO_WIN || diagRight2 == DOTS_TO_WIN)
                return true;
            for (int j = SIZE; j > 0; j--) {

                if (map[i][j - 1] == symb) countRow++;
                if (map[j - 1][i] == symb) countCol++;
                if (map[i][j - 1] != symb && countRow != DOTS_TO_WIN) {             // проверка что подряд по горизонтали
                    countRow = 0;
                }
                if (map[j - 1][i] != symb && countCol != DOTS_TO_WIN) {             // по вертикали
                    countCol = 0;
                }

                if (countRow == DOTS_TO_WIN || countCol == DOTS_TO_WIN || countDiagLeft == DOTS_TO_WIN || countDiagRight == DOTS_TO_WIN)
                    return true;
            }
            diagLeft1 = 0;
            diagLeft2 = 0;
            diagRight1 = 0;
            diagRight2 = 0;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Твой ход, вводи координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 1; i <= SIZE; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "");
            for (int j = 0; j < SIZE; j++) {
                System.out.print("[" + map[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println();
    }
}