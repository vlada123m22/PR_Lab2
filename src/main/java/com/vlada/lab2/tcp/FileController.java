package com.vlada.lab2.tcp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.concurrent.locks.*;
import java.util.Random;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final String FILE_NAME = "shared_file.txt";
    private static final ReentrantLock fileLock = new ReentrantLock();

    // Ensure that the file exists
    static {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write to the file
    @PostMapping("/write")
    public String writeToFile(@RequestBody String data) {
        // Handle the write operation in a separate thread
        new Thread(() -> {
            // Simulate random sleep before executing the operation
            sleepRandomly();

            fileLock.lock();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(data);
                writer.newLine();
                System.out.println("Data written: " + data);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            } finally {
                fileLock.unlock();
            }
        }).start();

        return "Write request received. Data will be written soon.";
    }

    // Read from the file
    @GetMapping("/read")
    public String readFromFile() {
        // Handle the read operation in a separate thread
        final StringBuilder result = new StringBuilder();
        Thread thread = new Thread(() -> {
            // Simulate random sleep before executing the operation
            sleepRandomly();

            fileLock.lock();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");

                }
                System.out.println("File read successfully.");
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } finally {
                fileLock.unlock();
            }
            System.out.println(result.toString());;
        });
        thread.start();

        // The result is returned asynchronously, after the thread completes processing
        return "The request has been sent. The data will be returned soon";
    }

    // Sleep for a random period between 1 and 7 seconds
    private void sleepRandomly() {
        Random rand = new Random();
        int sleepTime = rand.nextInt(7) + 1;  // Sleep time between 1 to 7 seconds
        try {
            System.out.println("Sleeping for " + sleepTime + " seconds...");
            Thread.sleep(sleepTime * 1000);  // Convert to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
