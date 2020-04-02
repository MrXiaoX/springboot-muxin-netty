package com.cardlan.springboot.socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SocketTcpBioClient {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket();
            SocketAddress address=new InetSocketAddress(InetAddress.getLocalHost(),8801);
            socket.connect(address);
            while (true){
                Scanner scanner=new Scanner(System.in);
                socket.getOutputStream().write(scanner.next().getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
