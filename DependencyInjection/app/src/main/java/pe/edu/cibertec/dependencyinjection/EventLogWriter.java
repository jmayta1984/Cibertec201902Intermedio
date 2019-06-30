package pe.edu.cibertec.dependencyinjection;

import android.util.Log;

public class EventLogWriter implements INotificationAction {


    @Override
    public void write(String message) {
        Log.d("MainActivity", message);

    }
}
