package multithreading.homwork1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFromFile {

    public static void main(String[] args) throws FileNotFoundException {
        File papka = new File("C:\\Users\\User\\Desktop\\june-third-project");
        File[] listOfFiles = papka.listFiles();
        List<String> listArray = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.getName().contains(".txt"))
                listArray.add(file.getName());
        }
        for (String str : listArray) {
            System.out.println(str);
        }
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try (FileReader reader = new FileReader(line)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        String line1 = scanner.nextLine();
        try (FileWriter writer = new FileWriter(line, true)) {
            writer.write("\n");
            writer.write(line1);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



