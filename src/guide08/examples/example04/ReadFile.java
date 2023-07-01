package guide08.examples.example04;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "src/guide08/examples/example04/input.txt";
        FileReader reader = new FileReader(path); // FileReader is a subclass of InputStreamReader
        int counter; // Stores the value of the read character
        while ((counter = reader.read()) != -1) { // -1 means EOF
            System.out.print((char) counter); // Cast the int value to char
        }
        reader.close(); // Close the file
    }
}
