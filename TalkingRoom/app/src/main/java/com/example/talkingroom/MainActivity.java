package com.example.talkingroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText userName;
    private EditText editIp;
    private EditText editPort;
    private int port;
    private String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText)findViewById(R.id.edit_name);
        editIp = (EditText)findViewById(R.id.edit_ip);
        editPort = (EditText)findViewById(R.id.edit_port);
        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        String regex2 = "^[ \\f\\n\\r\\t\\v]*$";
        String name = userName.getText().toString();
        ip = editIp.getText().toString();
        if(name.matches(regex2)){
            Toast.makeText(this, "昵称不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ip.matches(regex2)||!(ip.matches(regex))){
            Toast.makeText(this, "请输入正确的IP地址", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            port = Integer.parseInt(editPort.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "端口号错误!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this,TalkActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("ip",ip);
        intent.putExtra("port",String.valueOf(port));
        startActivity(intent);
    }
}
