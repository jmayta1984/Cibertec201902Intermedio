package pe.edu.cibertec.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    Context context;

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_info_window,null);
        TextView tvTitle, tvDescription,tvSchedule;
        ImageView ivImage;

        tvTitle = view.findViewById(R.id.tvTitle);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvSchedule = view.findViewById(R.id.tvSchedule);
        ivImage = view.findViewById(R.id.ivImage);

        tvTitle.setText("Prueba");
        tvDescription.setText("Descripción");
        tvSchedule.setText("Horario");

        ivImage.setImageResource(R.drawable.ic_marker);

        return view;
    }
}
