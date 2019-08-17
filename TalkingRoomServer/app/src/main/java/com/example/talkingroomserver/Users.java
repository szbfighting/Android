package com.example.talkingroomserver;

import android.util.Log;
import android.widget.Toast;

import com.example.talkingroomserver.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Users extends Thread {
    private ArrayList<Socket> socketlist;
    private Socket socket;
    private InputStream input;

    public Users(Socket socket, ArrayList<Socket> list){
        socketlist=list;
        this.socket=socket;
    }
    public void run(){
        try {
            int l;
            input = socket.getInputStream();
            byte[] arr = new byte[1024*5];
            while(true){
                while((l = input.read(arr))!=-1){
                    for (Socket s:socketlist) {
                        if(!s.equals(socket)){
                            try {
                                OutputStream out = s.getOutputStream();
                                out.write(arr,0,l);
                            }catch(Exception e){
                                MainActivity.list.remove(s);
                                socketlist.remove(s);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
