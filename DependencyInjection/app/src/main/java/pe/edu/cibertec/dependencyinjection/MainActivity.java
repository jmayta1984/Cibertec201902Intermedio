package pe.edu.cibertec.dependencyinjection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();

        appPoolWatcher.notify("Ocurrió el evento");

    }
}
