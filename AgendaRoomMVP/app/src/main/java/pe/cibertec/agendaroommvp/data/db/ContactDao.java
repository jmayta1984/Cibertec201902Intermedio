package pe.cibertec.agendaroommvp.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pe.cibertec.agendaroommvp.data.db.model.Contact;

@Dao
public interface ContactDao {

    @Insert
    void insertContacts(Contact... contacts);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("select * from Contact")
    List<Contact> getAll();

    @Query("select * from Contact where:name")
    List<Contact> searchByName(String name);

}
