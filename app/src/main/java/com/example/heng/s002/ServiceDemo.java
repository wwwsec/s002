package com.example.heng.s002;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by heng on 2016/3/22.
 */
public class ServiceDemo extends Service {

    private static final String TAG = "ServiceDemo" ;
    public static final String ACTION = "com.example.heng.s001.ServiceDemo";
    private TestBinder mBinder = new TestBinder();

    class TestBinder extends Binder{
        public void start(){
            Log.v(TAG, "....start");
        }
        public void stop(){
            Log.v(TAG, "....stop");
        }
        public int getv(){
            Log.v(TAG, "....get");
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "ServiceDemo onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "ServiceDemo onCreate");
        super.onCreate();
        //Notification notification = new Notification(R.drawable.ii,"Notification comes",System.currentTimeMillis());

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        //notification.(this,"this is title","this is content",pendingIntent);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setAutoCancel(true)
                .setContentTitle("title")
                .setContentText("describe")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .build();
        startForeground(2, notification);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.v(TAG, "ServiceDemo onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "ServiceDemo onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        Log.v(TAG, "ServiceDemo onDestroy");
        super.onDestroy();
    }

}
