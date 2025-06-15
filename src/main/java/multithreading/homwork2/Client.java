package multithreading.homwork2;


import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                ExampleClient client = new ExampleClient(
                        socket.getInputStream(),
                        socket.getOutputStream());
                client.send("");
                System.out.println("Введи первое число: ");
                String chislo1 = scanner.nextLine();
                System.out.println("Введи второе число: ");
                String chislo2 = scanner.nextLine();
                System.out.println("Введи команду: ");
                String command = scanner.nextLine();
                if(command.equalsIgnoreCase("exit")){
                    client.send(command);
                    break;
                }
                client.send(chislo1+" "+command+" "+chislo2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

