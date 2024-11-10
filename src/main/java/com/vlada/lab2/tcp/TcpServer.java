//package com.vlada.lab2.tcp;
//
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Service
//public class TcpServer {
//
//    private final FileService fileService;
//    private ExecutorService executorService;
//    private ServerSocket serverSocket;
//
//    public TcpServer(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @PostConstruct
//    public void startTcpServer() {
//        executorService = Executors.newFixedThreadPool(10); // Thread pool to handle multiple clients
//        try {
//            serverSocket = new ServerSocket(12345); // Start the server on port 12345
//            System.out.println("TCP Server started on port 12345");
//
//            while (true) {
//                // Accept incoming client connections
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("Client connected: " + clientSocket.getInetAddress());
//
//                // Handle the client request in a new thread
//                TcpServerController controller = new TcpServerController(clientSocket, fileService);
//                executorService.submit(controller);
//            }
//        } catch (IOException e) {
//            System.err.println("Server failed to start: " + e.getMessage());
//        }
//    }
//
//    @PreDestroy
//    public void stopTcpServer() {
//        try {
//            if (serverSocket != null && !serverSocket.isClosed()) {
//                serverSocket.close();
//                executorService.shutdown();
//                System.out.println("TCP Server stopped.");
//            }
//        } catch (IOException e) {
//            System.err.println("Error closing server socket: " + e.getMessage());
//        }
//    }
//}
