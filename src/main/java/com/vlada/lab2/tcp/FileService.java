//package com.vlada.lab2.tcp;
//
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//import java.util.concurrent.locks.ReentrantLock;
//
//@Service
//public class FileService {
//
//    private final ReentrantLock fileLock = new ReentrantLock();
//    private static final String FILE_PATH = "shared_file.txt";
//
//    // Read from the file
//    public String readFromFile() {
//        fileLock.lock();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH))) {
//            StringBuilder fileContents = new StringBuilder();
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                fileContents.append(line).append("\n");
//            }
//            return fileContents.toString();
//        } catch (IOException e) {
//            return "Error reading from file: " + e.getMessage();
//        } finally {
//            fileLock.unlock();
//        }
//    }
//
//    // Write to the file
//    public void writeToFile(String data) {
//        fileLock.lock();
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
//            fileWriter.write(data);
//            fileWriter.newLine();
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        } finally {
//            fileLock.unlock();
//        }
//    }
//}
