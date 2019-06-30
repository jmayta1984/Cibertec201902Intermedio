package pe.cibertec.agendaroommvp.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.cibertec.agendaroommvp.R;
import pe.cibertec.agendaroommvp.data.db.model.Contact;

class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactoCelda> {

    List<Contact> contacts;


    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactoCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prototype_contact,parent,false);

        return new ContactoCelda(vista);
    }

    // Mostrar la información
    @Override
    public void onBindViewHolder(@NonNull ContactoCelda celda, int posicion) {
        celda.tvNombre.setText(contacts.get(posicion).getName());

    }


    // Cantidad de items a mostrar
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactoCelda extends RecyclerView.ViewHolder {

        TextView tvNombre;

        public ContactoCelda(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);

        }
    }
}
