package lectures.lecture3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        String text = "Hello world!";
        try (FileOutputStream out = new FileOutputStream("src/lectures/lecture3/task5.txt")) {
            byte[] buffer = text.getBytes();
            out.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try (FileInputStream in = new FileInputStream("src/lectures/lecture3/task5.txt")) {
            System.out.println("Size of file is " + in.available() + " bytes");
            byte[] inArray = in.readAllBytes();
            System.out.println(Arrays.toString(inArray));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
