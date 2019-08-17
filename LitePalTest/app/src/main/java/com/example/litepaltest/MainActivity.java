package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.parser.LitePalParser;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });

        Button addData = (Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("UnKnown");
                book.save();
            }
        });

        Button updateData = (Button)findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author = ?","The Lost Symbol","Dan Brown");
            }
        });

        Button deleteData = (Button)findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.deleteAll(Book.class,"price<?","15");
            }
        });

        Button queryButton = (Button)findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book:books) {
                    Log.d("MainActivity", "book name is"+book.getName());
                    Log.d("MainActivity", "book author is"+book.getAuthor());
                    Log.d("MainActivity", "book pages is"+book.getPages());
                    Log.d("MainActivity", "book price is"+book.getPrice());
                    Log.d("MainActivity", "book press is"+book.getPress());
                }
            }
        });
    }
}
