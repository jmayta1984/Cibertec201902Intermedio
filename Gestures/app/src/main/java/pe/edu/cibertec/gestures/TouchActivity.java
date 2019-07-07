package pe.edu.cibertec.gestures;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class TouchActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    final static String TOUCH_LOG = "TouchActivityGestures";
    GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        detector = new GestureDetectorCompat(this, this);
        detector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (this.detector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TOUCH_LOG, "Down: " + e.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(TOUCH_LOG, "ShowPress: " + e.toString());

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TOUCH_LOG, "SingleTapUp: " + e.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TOUCH_LOG, "Scroll: " + e1.toString() + e2.toString());

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(TOUCH_LOG, "LongPress: " + e.toString());

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TOUCH_LOG, "Fling: " + e1.toString() + e2.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TOUCH_LOG, "SingleTapConfirmed: " + e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TOUCH_LOG, "DoubleTap: " + e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(TOUCH_LOG, "DoubleTapEvent: " + e.toString());
        return true;
    }
}
