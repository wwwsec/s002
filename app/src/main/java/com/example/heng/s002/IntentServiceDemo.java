package com.example.heng.s002;

import android.app.IntentService;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by heng on 2016/3/22.
 */
public class IntentServiceDemo extends IntentService{
    private static final String TAG = "ServiceDemo" ;

    public IntentServiceDemo() {
        super("IntentServiceDemo");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i =0;i<1000;i++){
            Log.v(TAG,"thread is "+ Thread.currentThread().getId());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
    }
}
