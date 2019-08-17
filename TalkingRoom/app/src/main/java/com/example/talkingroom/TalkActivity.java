package com.example.talkingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;

public class TalkActivity extends AppCompatActivity {
    private ArrayList<Msg> msgArrayList = new ArrayList<>();
    private Button send;
    private EditText input;
    private RecyclerView msgRecycler;
    private MsgAdapter msgAdapter;
    private String ip;
    private String port;
    private InputStream receiveMsg;
    private OutputStream sendMsg;
    private Socket socket;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        send = (Button)findViewById(R.id.send_msg);
        input = (EditText)findViewById(R.id.input_text);
        msgRecycler = (RecyclerView)findViewById(R.id.msg_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecycler.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgArrayList);
        msgRecycler.setAdapter(msgAdapter);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        ip = intent.getStringExtra("ip");
        port = intent.getStringExtra("port");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
        try {
            socket = new Socket(ip,Integer.parseInt(port));
            receiveMsg = socket.getInputStream();
            sendMsg = socket.getOutputStream();
        } catch (IOException e) {
            //finish();
            Toast.makeText(this, "连接服务器失败...", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        if(socket!=null){
            Toast.makeText(this, "连接成功!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "连接服务器失败...", Toast.LENGTH_SHORT).show();
            Log.d("MainActivity", "onClick: "+ip+":"+port);
            finish();
        }

        new Thread(){
            public void run(){
                try {
                    int len;
                    byte[] arr = new byte[1024*5];
                    String s;
                    while(true) {
                        while ((len = receiveMsg.read(arr)) != -1) {
                            s = new String(arr, 0, len);
                            final Msg msg = new Msg(s, Msg.TYPE_RECEIVED);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    msgArrayList.add(msg);
                                    msgAdapter.notifyItemChanged(msgArrayList.size() - 1);
                                    msgRecycler.scrollToPosition(msgArrayList.size() - 1);
                                }
                            });

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(input.getText().toString())) {
                    StringBuilder l = new StringBuilder();
                    l.append(name + ":" + input.getText().toString() + "\n");
                    Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time = dateFormat.format(now);
                    l.append(time);
                    try {
                        sendMsg.write(l.toString().getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Msg msg = new Msg(l.toString(), Msg.TYPE_SEND);
                    msgArrayList.add(msg);
                    msgAdapter.notifyItemChanged(msgArrayList.size() - 1);
                    msgRecycler.scrollToPosition(msgArrayList.size() - 1);
                    input.setText("");
                }

            }
        });

    }
}
