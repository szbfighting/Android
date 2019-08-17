package com.example.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forceOffLine = (Button)findViewById(R.id.force_offline);
        forceOffLine.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                Log.d(TAG, "onClick: click");
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                intent.setComponent(new ComponentName("com.example.broadcastbestpractice","com.example.broadcastbestpractice.ForceOffLineReceiver"));
                sendBroadcast(intent);
                /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("warning");
                builder.setMessage("You are forced to be offline .Please try to login again.");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCollector.finishAll();
                        Intent it = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(it);
                    }
                });
                builder.show();*/
            }
        });
    }
}
