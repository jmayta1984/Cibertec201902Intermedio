package pe.cibertec.agendaroommvp.ui.main;

import java.util.List;

import pe.cibertec.agendaroommvp.data.db.model.Contact;

public interface MainContract {

    interface MainView{
        void showContacts(List<Contact> contacts);
    }

    interface MainPresenter {
        void addContact(Contact contact);
        void getAllContacts();

    }
}
