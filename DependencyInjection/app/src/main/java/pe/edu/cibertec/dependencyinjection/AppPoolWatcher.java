package pe.edu.cibertec.dependencyinjection;

public class AppPoolWatcher {

    EventLogWriter eventLogWriter = null;

    public void notify(String message) {
        if (eventLogWriter == null) {
            eventLogWriter = new EventLogWriter();
        }

        eventLogWriter.write(message);

    }
}
