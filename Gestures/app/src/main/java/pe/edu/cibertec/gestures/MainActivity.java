package pe.edu.cibertec.gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final String LOG_TAG = "MainActivityGestures";
    static final String IMAGE_TAG = "ImageViewGestures";
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListeners();
    }

    private void setListeners() {
        ivImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        Log.d(IMAGE_TAG, "Action was down");
                        return true;
                    case (MotionEvent.ACTION_MOVE):
                        Log.d(IMAGE_TAG, "Action was move");
                        return true;
                    case (MotionEvent.ACTION_UP):
                        Log.d(IMAGE_TAG, "Action was up");
                        return true;
                    case (MotionEvent.ACTION_CANCEL):
                        Log.d(IMAGE_TAG, "Action was cancel");
                        return true;
                    case (MotionEvent.ACTION_OUTSIDE):
                        Log.d(IMAGE_TAG, "Action was outside");
                        return true;
                }
                return false;
            }
        });
    }

    private void initView() {
        ivImage = findViewById(R.id.ivImage);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getActionMasked();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(LOG_TAG, "Action was down");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(LOG_TAG, "Action was move");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(LOG_TAG, "Action was cancel");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(LOG_TAG, "Action was up");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(LOG_TAG, "Action was outside");
                return true;
            default:
                return super.onTouchEvent(event);

        }

    }
}
