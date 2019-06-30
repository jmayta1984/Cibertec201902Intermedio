package pe.cibertec.agendaroommvp;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etNombre;
    Button btAdd;
    RecyclerView rvContact;

    List<Contact> items;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etName);
        btAdd = findViewById(R.id.btAdd);
        rvContact = findViewById(R.id.rvContact);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Agregar el contact
                Contact contact = new Contact(etNombre.getText().toString());

                new TaskAddContac().execute(contact);
                new TaskGetContacts().execute();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        new TaskGetContacts().execute();
    }

    private class TaskAddContac extends AsyncTask<Contact,Void,Void>{
        @Override
        protected Void doInBackground(Contact... contacts) {
            AppDatabase.nuevaInstancia(MainActivity.this).getContactDao().insertContacts(contacts);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }

    private class TaskGetContacts extends AsyncTask<Void, Void,List<Contact>>{
        @Override
        protected List<Contact> doInBackground(Void... voids) {
           return AppDatabase.nuevaInstancia(MainActivity.this).getContactDao().getAll();
        }


        @Override
        protected void onPostExecute(List<Contact> contacts) {
            super.onPostExecute(contacts);
            items = contacts;
            adapter = new ContactAdapter(items);
            rvContact.setAdapter(adapter);

            rvContact.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        }
    }
}
