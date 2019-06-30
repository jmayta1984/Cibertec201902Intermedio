package pe.edu.cibertec.dependencyinjection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Base

        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();

        appPoolWatcher.notify("Ocurrió el evento");
        */

        // Inyección de constructor
        /*
        EmailSender action = new EmailSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher(action);

        appPoolWatcher.notify("Ocurrió el evento");
        */

        // Inyección de método
        /*
        SmsSender action = new SmsSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();
        appPoolWatcher.notify(action,"Ocurrió el evento");
        */


        // Inyección de propiedadd
        EventLogWriter action = new EventLogWriter();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();

        appPoolWatcher.setAction(action);
        appPoolWatcher.notify("Ocurrió el evento");

    }
}
