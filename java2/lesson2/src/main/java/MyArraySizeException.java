public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(String message){
        super("Неверный размер массива: "+message);
    }
}