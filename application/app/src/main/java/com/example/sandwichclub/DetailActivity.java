package com.example.sandwichclub;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView name,age;
    private View color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle arguments = getIntent().getExtras();
        String str_name = arguments.get("NAME").toString();
        String str_age = arguments.get("AGE").toString();
        String str_color =  arguments.get("COLOR").toString();
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        color =findViewById(R.id.colorCat);
        name.setText(str_name);
        age.setText(str_age);
        color.setBackgroundColor(Integer.parseInt(str_color));



    }
}