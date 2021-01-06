package com.example.sandwichclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView name,age;
    private View colorCat;
    RecyclerView recyclerView ;
    DummyContent content;
    private ArrayList<Cat>cats;
    ArrayList<String>date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date= new ArrayList<>();
        cats = new ArrayList<>();
        setDataCats();
        recyclerView = findViewById(R.id.list);
        RViewAdapter adapter = new RViewAdapter(cats);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    private void setDataCats(){
        for (int i = 0; i <12 ; i++) {
            Cat murzik = new Cat();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Log.i("GSON", gson.toJson(murzik));
            String jsonText = "{\"name\":\"Мурзик\",\"color\":-19757216,\"age\":8}";
            murzik = gson.fromJson(jsonText, Cat.class);
            Log.i("GSON", "Имя: " + murzik.name + "\nВозраст: " + murzik.age);

            cats.add(murzik);

        }
    }
}