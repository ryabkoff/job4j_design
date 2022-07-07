package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    int startMsg;
                    String msg = "";
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        startMsg = str.indexOf("/?msg=");
                        if (startMsg != -1) {
                            msg = str.substring(startMsg + 6, str.indexOf(" HTTP"));
                            break;
                        }
                    }
                    if ("Exit".equals(msg)) {
                        server.close();
                    } else if (!msg.isBlank()) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write((("Hello".equals(msg) ? "Hello" : "What") + "\r\n").getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}