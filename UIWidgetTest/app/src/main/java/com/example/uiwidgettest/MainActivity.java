package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        //editText = (EditText)findViewById(R.id.edit_text);
        //imageView = (ImageView)findViewById(R.id.image_view);
        progressBar =(ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String inputText = editText.getText().toString();
                //Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                //imageView.setImageResource(R.drawable.ki);
                /*if(progressBar.getVisibility()== View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }*/
                /*int progress = progressBar.getProgress();
                progress=progress+10;
                progressBar.setProgress(progress);*/
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is dialog.");
                dialog.setMessage("somthing important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.setNegativeButton("cancel",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

    }
}
