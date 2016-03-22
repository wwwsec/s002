package com.example.heng.s002;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private ServiceDemo.TestBinder testBinder;
    private static final String TAG = "ServiceDemo" ;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            testBinder = (ServiceDemo.TestBinder) service;
            testBinder.start();
            testBinder.getv();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,ServiceDemo.class);
                startService(i);
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(this,ServiceDemo.class);
                stopService(ii);
                break;
            case R.id.button3:
                Intent i3 = new Intent(this,ServiceDemo.class);
                bindService(i3,conn,BIND_AUTO_CREATE);
                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();
                unbindService(conn);
                break;
            case R.id.button5:
                testBinder.getv();
                break;
            case R.id.button6:
                Log.v(TAG,"Thread id is" + Thread.currentThread().getId() );
                Intent intentService = new Intent(this, IntentServiceDemo.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}
