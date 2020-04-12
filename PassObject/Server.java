package ru.gb.java_3.hw_3.PassObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

        public static void main(String[] args) {
            Socket socket = null;
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                System.out.println("Сервер запущен, ожидаем подключения...");
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    byte[] byteUsrIn = new byte[(1024*1024)];
                    in.read(byteUsrIn);
                    try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteUsrIn);
                         ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
                        NewUser usrIn = (NewUser) objIn.readObject();
                        System.out.println("Получены данные о новом пользователе " + usrIn.getName() + " " + usrIn.getPassword());
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    out.writeUTF("User передан на сервер");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

