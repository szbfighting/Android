package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{


    private List<Song> songList = new ArrayList<>();
    private EditText editText;
    private Button search;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = findViewById(R.id.edit_text);
        search = findViewById(R.id.search);
        listView = findViewById(R.id.list_view);
        search.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = songList.get(i);
                String adress = "https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%22358840384%22%2C%22songmid%22%3A%5B%22"+song.getSongMid()+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%221443481947%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%2C%22comm%22%3A%7B%22uin%22%3A%2218585073516%22%2C%22format%22%3A%22json%22%2C%22ct%22%3A24%2C%22cv%22%3A0%7D%7D";

                //Toast.makeText(MainActivity.this, song.getSongName()+" "+song.getAlbumName(), Toast.LENGTH_SHORT).show();
                HttpUtil.sendOkHttpRequest(adress, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONObject req_0 = jsonObject.getJSONObject("req_0");
                            JSONObject data = req_0.getJSONObject("data");
                            JSONArray midurlinfo = data.getJSONArray("midurlinfo");
                            JSONObject info = midurlinfo.getJSONObject(0);
                            Log.d("INFO", "onResponse: "+info.getString("purl"));
                            JSONArray sip = data.getJSONArray("sip");
                            Log.d("SIP", "onResponse: "+sip.get(0));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search:
                songList.clear();
                String song = editText.getText().toString();
                requestSong(song);

                Log.d("ADAPTER", "onClick: ");
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN){
            View view = getCurrentFocus();
            if(isShouldHideKeyBord(view,ev)){
                hideSoftInput(view.getWindowToken());
            }else
                editText.setCursorVisible(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isShouldHideKeyBord(View v,MotionEvent ev){
        if(v!=null&&(v instanceof EditText)){
            int[] l ={0,0};
            v.getLocationInWindow(l);
            int left = l[0],bottom=l[1],top = bottom+v.getHeight(),right = left+v.getWidth();
            return !(ev.getX()>left&&ev.getX()<right&&ev.getY()>bottom&&ev.getY()<top);
        }
        return false;
    }

    public void hideSoftInput(IBinder token){
        if(token!=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(token,InputMethodManager.HIDE_NOT_ALWAYS);
            editText.setCursorVisible(false);
        }
    }


    public  void requestSong(final String songname){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=1&n=30&w="+songname+"&format=json")
                        .build();
                Response response;
                String responseContent;
                try {
                    response = client.newCall(request).execute();
                    responseContent = response.body().string();
                    parseSongInfo(responseContent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public  void parseSongInfo(String response) throws JSONException {
        JSONObject songsInfoObject = new JSONObject(response);
        JSONObject data = songsInfoObject.getJSONObject("data");
        JSONObject songs = data.getJSONObject("song");
        Log.d("SONGS", "parseSongInfo: "+songs.getInt("totalnum"));
        JSONArray list = songs.getJSONArray("list");
        for (int i =0;i<list.length();i++){
            JSONObject song = list.getJSONObject(i);
            Log.d("SONG", "parseSongInfo: "+song.getInt("albumid")+" "+song.getString("albumname")+" "+song.getString("songmid")+" "+song.getString("songname"));
            Song song1 = new Song();
            song1.setAlbumId(song.getInt("albumid"));
            song1.setAlbumName(song.getString("albumname"));
            song1.setSongName(song.getString("songname"));
            song1.setSongMid(song.getString("songmid"));
            songList.add(song1);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SongAdapter adapter = new SongAdapter(SearchActivity.this,R.layout.song_list,songList);
                listView.setAdapter(adapter);
            }
        });

    }
}
