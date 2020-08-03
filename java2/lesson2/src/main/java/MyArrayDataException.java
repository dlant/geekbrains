public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(String message) {
        super("Некорректные данные: "+message);
    }


}
