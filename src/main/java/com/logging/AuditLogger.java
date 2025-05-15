package com.logging;

/** The AuditLogger class is a task that simulates writing a log entry asynchronously.
 *  It implements Runnable so it can be executed by a Thread.
 */
public class AuditLogger implements Runnable {

    private final String message;

    /**
     * @param message store the log message
     */
    public AuditLogger(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Logging has started. Message : " + message + " by " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000); // Pauses for 1 second1 to simulate delay
        } catch (InterruptedException e) { // If the thread is interrupted while sleeping, we:
            System.out.println("Logging interrupted "); // Print an error
            Thread.currentThread().interrupt();  // Reset the interrupt flag.
        }
        //Continue the simulation
        System.out.println("Logging is finished. Messasge : " + message + " by " + Thread.currentThread().getName());
    }
}
