package ru.gb.java_3.hw_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
//Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
// Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>();
// ... Enumeration<InputStream> e = Collections.enumeration(al);
public class JoinFile {
    public static void main(String[] args) throws IOException {
        File file_1 = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example1.txt");
        File file_2 = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example2.txt");
        File file_3 = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example3.txt");
        File file_4 = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example4.txt");
        File file_5 = new File("C:\\Users\\Sharov\\IdeaProjects\\Java_3\\src\\ru\\gb\\java_3\\hw_3\\example5.txt");
        ArrayList<FileInputStream> arrFile = new ArrayList<>();
        arrFile.add(new FileInputStream(file_1));
        arrFile.add(new FileInputStream(file_2));
        arrFile.add(new FileInputStream(file_3));
        arrFile.add(new FileInputStream(file_4));
        arrFile.add(new FileInputStream(file_5));
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arrFile));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);
        }
    }

}
