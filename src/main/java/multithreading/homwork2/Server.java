package multithreading.homwork2;


import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Server {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(8080)) {
            System.out.println("SERVER APPLICATION RUN!");
            while (true) {
                Socket client = socket.accept();
                DataInputStream inputStream = new DataInputStream(client.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                outputStream.writeUTF("Доступные команды: +,-,*,/");
                outputStream.flush();
                String test = inputStream.readUTF();
                String userInput = inputStream.readUTF();
                if(userInput.equalsIgnoreCase("exit")){
                    System.out.println("клиент с портом : "+client.getPort() +" отключился!");
                    client.close();
                    continue;
                }
                String result = transformToMath(userInput);
                outputStream.writeUTF("Ответ: " + result);
                outputStream.flush();
                System.out.println("result = " + result);
            }
        } catch (IOException e) {
            System.out.println("Сервер не поднялся");
        }
    }

    private static String transformToMath(String userInput) {
        String[] arr = userInput.split(" ");
        String result = "";
        if (arr[1].equals("+")) {
            result = String.valueOf(Double.parseDouble(arr[0]) + Double.parseDouble(arr[2]));
        } else if (arr[1].equals("-")) {
            result = String.valueOf(Double.parseDouble(arr[0]) - Double.parseDouble(arr[2]));
        } else if (arr[1].equals("*")) {
            result = String.valueOf(Double.parseDouble(arr[0]) * Double.parseDouble(arr[2]));
        } else if (arr[1].equals("/")) {
            result = String.valueOf(Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]));
        }
        return result;
    }

}
