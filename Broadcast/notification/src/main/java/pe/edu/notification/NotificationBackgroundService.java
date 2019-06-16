package pe.edu.notification;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class NotificationBackgroundService extends Service {

    private NotificationReceiver notificationReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);

        return START_STICKY;

    }

    @Override
    public void onCreate() {
        super.onCreate();


        notificationReceiver = new NotificationReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("pe.edu.cibertec.broadcast.ACTION");

        this.registerReceiver(notificationReceiver, intentFilter);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (notificationReceiver != null) {
            unregisterReceiver(notificationReceiver);
        }
    }


}
