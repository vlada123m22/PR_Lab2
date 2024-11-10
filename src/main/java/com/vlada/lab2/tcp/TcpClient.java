//package com.vlada.lab2.tcp;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class TcpClient {
//
//    private static final String SERVER_ADDRESS = "localhost";  // Server IP address
//    private static final int SERVER_PORT = 12345;  // Server port
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Connect to the server
//        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
//             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//
//            System.out.println("Connected to the server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
//
//            while (true) {
//                // Get user input for command
//                System.out.println("Enter command (READ/WRITE <data>) or 'exit' to quit:");
//                String userInput = scanner.nextLine();
//
//                if (userInput.equalsIgnoreCase("exit")) {
//                    break;
//                }
//
//                // Send the command to the server
//                writer.println(userInput);
//
//                // Read and display the server's response
//                String serverResponse = reader.readLine();
//                System.out.println("Server response: " + serverResponse);
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error connecting to the server: " + e.getMessage());
//        }
//    }
//}
