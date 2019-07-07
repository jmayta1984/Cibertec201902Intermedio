package pe.edu.cibertec.gestures;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.AppCompatImageView;

public class ScaleImageView extends AppCompatImageView {

    private GestureDetectorCompat gestureDetectorCompat;
    
    public ScaleImageView(Context context) {
        super(context);
    }
}
