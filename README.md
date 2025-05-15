#Logging / Audit Trail Writer (Simulation)

Creating an AuditLogger class that implements Runnable.
Accept a log message and simulate writing the log (with Thread.sleep()).
In the main app, simulate multiple user actions.
For each action, create a new thread for logging.
Use join() so main thread waits for logs to complete (optional for realism).