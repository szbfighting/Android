package com.example.talkingroomserver;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText port_server;
    private ServerSocket server;
    public static final  ArrayList<Socket> list = new ArrayList<>();
    private Integer portd;
    private Button power;
    private Button down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        port_server = (EditText)findViewById(R.id.port);
        power = (Button)findViewById(R.id.power);
        down = (Button)findViewById(R.id.down);
        power.setOnClickListener(this);
        down.setOnClickListener(this);
        power.setEnabled(true);
        down.setEnabled(false);
    }
    class ServerThread extends Thread{
        public void run(){
            try {
                server = new ServerSocket(portd);
                Log.d("MainActivity", "run: "+server.toString());
                while(true){
                    Socket socket = server.accept();
                    list.add(socket);
                    new Users(socket,list).start();
                }
            } catch (IOException e) {
                Log.d("MainActivity", "onClick: "+portd.intValue());
                Log.d("MainActivity", "onClick: ");
                Log.d("MainActivity", "run: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.power:
                Log.d("MainActivity", "onClick: ");
                String port = port_server.getText().toString();
                try {
                    portd = Integer.parseInt(port);
                }catch (NumberFormatException n){
                    Toast.makeText(this, "端口号错误!!", Toast.LENGTH_SHORT).show();
                    break;
                }
                new ServerThread().start();
                Toast.makeText(this, "启动成功.", Toast.LENGTH_SHORT).show();
                power.setEnabled(false);
                down.setEnabled(true);
                break;
            case R.id.down:
                try {
                    server.close();
                    list.clear();
                    power.setEnabled(true);
                    down.setEnabled(false);
                } catch (IOException e) {
                    Toast.makeText(this, "关闭错误!!", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
