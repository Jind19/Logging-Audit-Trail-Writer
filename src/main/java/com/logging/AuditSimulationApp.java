package com.logging;

import java.util.Arrays;
import java.util.List;

/**
 * AuditSimulationApp demonstrates logging messages concurrently using threads.
 */
public class AuditSimulationApp {
    // Entry Point
    public static void main(String[] args) {

        // messages list
        List<String> messages = Arrays.asList(
                "User logged in",
                "User viewed dashboard",
                "User updated settings",
                "User logged out"
        );

        // Creating an array of threads, empty but same size of Messages List
        Thread[] threads = new Thread[messages.size()];

        for (int i = 0; i < messages.size(); i++) {
            // Creating an AuditLogger instance for each logged message:
            AuditLogger logger = new AuditLogger(messages.get(i));

            //Creating a thread for each logger:
            threads[i] = new Thread(logger, "AuditThread-" + (i + 1)); //A new Thread is wrapped around it.
            // A custom thread name is assigned (AuditThread-1, etc.) — great for debugging/logs!

            threads[i].start(); // is called → logs each messages in its own thread.
            // This makes the message logging concurrent. All messages are being "logged" (simulated) in parallel.
        }

        // Waiting for Threads to Finish : using join().

        for (Thread thread : threads) {
            try {
                // join() blocks the main thread until the child thread completes
                thread.join();
            } catch (InterruptedException e) {
                // Properly handles InterruptedException — logs and restores the interrupt flag.
                System.err.println("Thread interrupted: " + thread.getName()); // log
                Thread.currentThread().interrupt(); // restore the interrupt flag.
            }
        }
        //Final Message
        System.out.println("All messages have been logged"); // Once all threads are done, a final confirmation is printed.
    }
}
