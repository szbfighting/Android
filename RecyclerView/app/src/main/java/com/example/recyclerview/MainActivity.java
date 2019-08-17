package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitlist);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits(){
        for (int i =0;i<2;i++){
            Fruit apple = new Fruit(getRandomLengthName("apple"),R.mipmap.ic_launcher_round);
            fruitlist.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"),R.mipmap.ic_launcher_round);
            fruitlist.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("orange"),R.mipmap.ic_launcher_round);
            fruitlist.add(orange);
            Fruit pear = new Fruit(getRandomLengthName("pear"),R.mipmap.ic_launcher_round);
            fruitlist.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("grape"),R.mipmap.ic_launcher_round);
            fruitlist.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("pineapple"),R.mipmap.ic_launcher_round);
            fruitlist.add(pineapple);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"),R.mipmap.ic_launcher_round);
            fruitlist.add(cherry);
            Fruit mengo = new Fruit(getRandomLengthName("mengo"),R.mipmap.ic_launcher_round);
            fruitlist.add(mengo);

        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
