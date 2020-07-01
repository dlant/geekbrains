
public class Main {
    public static void main(String[] args) {
//        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String str = "10 3 1 2\n2 3 2 2\n5 o 7 1\n300 3 1 0";

        try {
            System.out.println("Сумма элементов/2 = "+arrayToInteger(strToArray(str,4,4)));

        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("В матрице должно быть одинаковое(4) число строк и столбцов");

        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Неверный формат элемента матрицы");
        }
    }

    public static String[][] strToArray(String str,int row, int col) throws ArrayIndexOutOfBoundsException {
        String[] values = str.split("\\s");

        if (values.length!=16) throw new MyArraySizeException("1.Матрица должна быть квадратная");

        String[][] twoDimArr = new String[row][col];
        if(col!=4 || row!=4) throw new MyArraySizeException("2.Матрица должна быть квадратная");
        int i = 0;
        for (int j = 0; j < twoDimArr.length; j++) {
            for (int k = 0; k < twoDimArr[j].length; k++) {
                twoDimArr[j][k] = values[i];
                i++;
                    System.out.print(twoDimArr[j][k]+" ");
            }
                System.out.println();

        }
        return twoDimArr;

    }

    public static double arrayToInteger(String[][] arr) throws NumberFormatException,ArrayIndexOutOfBoundsException {
        double sum = 0;
        int[][] myIntArray = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    myIntArray[i][j] = Integer.parseInt(arr[i][j]);

                } catch (NumberFormatException e) {

                    throw new MyArrayDataException("В матрице,в строке " + (i + 1) + " в столбце " + (j + 1) + " - не число");
                } catch (ArrayIndexOutOfBoundsException e){
                    throw new MyArraySizeException("проверьте размер матрицы ");
                }


                sum += myIntArray[i][j];
            }
        }
        return  (sum / 2);
    }

}



