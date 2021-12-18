package com.example.myplant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HumidityActivity extends AppCompatActivity {

    private ImageView humidity_img, back;
    private String humidity[];
    private TextView humidity_txt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);
        back = findViewById(R.id.back);
        humidity_img =  findViewById(R.id.humidity_img);
        humidity_txt = findViewById(R.id.humidity_txt);
        humidity = humidity_txt.getText().toString().split("%");
        Integer humidity_int = Integer.parseInt(humidity[0]);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if(humidity_int>=80)
            humidity_img.setImageResource(R.drawable.high);
        else if(humidity_int>=40)
            humidity_img.setImageResource(R.drawable.right);
        else
            humidity_img.setImageResource(R.drawable.low);
    }

}

