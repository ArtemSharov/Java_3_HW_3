package ru.gb.java_3.hw_3.PassObject;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame {
        private final String SERVER_ADDR = "localhost";
        private final int SERVER_PORT = 8189;

        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public Client() {
            try {
                openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            regUser("Ivanov", "1234");
        }

        public void openConnection() throws IOException {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//                        while (true) {
//                            String strFromServer = in.readUTF();
//                            if (strFromServer.equalsIgnoreCase("/end")) {
//                                break;
//                            }
//                            System.out.println(strFromServer);
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public void closeConnection() {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void regUser(String name, String password) {
            byte[] byteUsrOut = null;
            try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
                 ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
                NewUser usr = new NewUser(name, password);
                objOut.writeObject(usr);
                byteUsrOut = barrOut.toByteArray();
                out.write(byteUsrOut);
                closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }





        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Client();
                }
            });
        }
}
