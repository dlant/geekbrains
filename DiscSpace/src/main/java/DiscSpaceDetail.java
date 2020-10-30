import java.io.File;

public class DiscSpaceDetail
{
    public static void main(String[] args)
    {
        File file = new File("d:");
        long totalSpace = file.getTotalSpace(); // общее дисковое пространство в байтах.
        long usableSpace = file.getUsableSpace(); /// нераспределенное / свободное дисковое пространство в байтах.
        long freeSpace = file.getFreeSpace(); // нераспределенное / свободное дисковое пространство в байтах.

        System.out.println(" === Partition Detail ===");

        System.out.println(" === bytes ===");
        System.out.println("Total size : " + totalSpace + " bytes");
        System.out.println("Space free : " + usableSpace + " bytes");
        System.out.println("Space free : " + freeSpace + " bytes");

        System.out.println(" === mega bytes ===");
        System.out.println("Total size : " + totalSpace /1024 /1024 + " mb");
        System.out.println("Space free : " + usableSpace /1024 /1024 + " mb");
        System.out.println("Space free : " + freeSpace /1024 /1024 + " mb");
    }
}