package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Fruit> fruitlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitlist);
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitlist.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for (int i =0;i<2;i++){
            Fruit apple = new Fruit("apple",R.mipmap.ic_launcher_round);
            fruitlist.add(apple);
            Fruit banana = new Fruit("banana",R.mipmap.ic_launcher_round);
            fruitlist.add(banana);
            Fruit orange = new Fruit("orange",R.mipmap.ic_launcher_round);
            fruitlist.add(orange);
            Fruit pear = new Fruit("pear",R.mipmap.ic_launcher_round);
            fruitlist.add(pear);
            Fruit grape = new Fruit("grape",R.mipmap.ic_launcher_round);
            fruitlist.add(grape);
            Fruit pineapple = new Fruit("pineapple",R.mipmap.ic_launcher_round);
            fruitlist.add(pineapple);
            Fruit cherry = new Fruit("cherry",R.mipmap.ic_launcher_round);
            fruitlist.add(cherry);
            Fruit mengo = new Fruit("mengo",R.mipmap.ic_launcher_round);
            fruitlist.add(mengo);

        }
    }
}
