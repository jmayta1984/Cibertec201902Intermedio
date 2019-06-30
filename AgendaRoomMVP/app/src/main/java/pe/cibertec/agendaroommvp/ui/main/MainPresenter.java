package pe.cibertec.agendaroommvp.ui.main;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import pe.cibertec.agendaroommvp.data.db.AppDatabase;
import pe.cibertec.agendaroommvp.data.db.model.Contact;

public class MainPresenter implements MainContract.MainPresenter {

    MainContract.MainView mainView;

    // Inyección de dependencia de constructor
    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void addContact(Contact contact) {
        new TaskAddContac().execute(contact);
    }

    @Override
    public void getAllContacts() {
        new TaskGetContacts().execute();

    }

    private class TaskAddContac extends AsyncTask<Contact, Void, Void> {
        @Override
        protected Void doInBackground(Contact... contacts) {
            AppDatabase.getInstance((Context) mainView)
                    .getContactDao().insertContacts(contacts);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //adapter.notifyDataSetChanged();
        }
    }

    private class TaskGetContacts extends AsyncTask<Void, Void, List<Contact>> {
        @Override
        protected List<Contact> doInBackground(Void... voids) {
            return AppDatabase.getInstance((Context) mainView).getContactDao().getAll();
        }


        @Override
        protected void onPostExecute(List<Contact> contacts) {
            super.onPostExecute(contacts);
            mainView.showContacts(contacts);
        }
    }
}
