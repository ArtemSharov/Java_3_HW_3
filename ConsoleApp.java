package ru.gb.java_3.hw_3;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConsoleApp {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example6.txt");
        int maxLengthFile = 10;
        long time = System.currentTimeMillis();
        double finishTime;
        byte[] buf = new byte[150];
        if (file.length() / (1024 * 1024) < maxLengthFile) {
            try (FileInputStream in = new FileInputStream(file)) {
                int count = 0;
                int x;
                int limit = 1800;
                while ((x = in.read()) != -1) {
                    if (count == limit) {
                        System.out.println();
                        System.out.println('\n'+"<<<!NEW PAPER!>>>");
                        System.out.println();
                        count = 0;
                    }
                    System.out.print((char) x);
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else System.out.println("Файл должен быть не больше 10 mb");

        finishTime = (System.currentTimeMillis() - time);
        System.out.println();
        System.out.println("Время выполения: " + finishTime/1000 + " секунд");
    }
}
