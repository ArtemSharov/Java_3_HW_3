package ru.gb.java_3.hw_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
public class ReadFile {


    public static void main(String[] args) {
        File file = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example1.txt");

        byte[] buf = new byte[50];

        try (FileInputStream in = new FileInputStream(file)) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




