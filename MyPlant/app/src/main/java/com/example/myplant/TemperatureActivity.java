package com.example.myplant;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TemperatureActivity extends AppCompatActivity {//알림 처리 추가

    private TextView right_temperature, temperature_txt;
    private ImageView temperature_img, back;
    private String right_tem[], tem[];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        back = findViewById(R.id.back);

        temperature_img =  findViewById(R.id.temperature_img);
        right_temperature =  findViewById(R.id.right_temperature);
        temperature_txt =  findViewById(R.id.temperature_txt);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        right_tem = right_temperature.getText().toString().split("°");
        tem = temperature_txt.getText().toString().split("°");
       if(Math.abs(Integer.parseInt(right_tem[0])-Integer.parseInt(tem[0]))<=2&&Math.abs(Integer.parseInt(right_tem[0])-Integer.parseInt(tem[0]))>=0)
            temperature_img.setImageResource(R.drawable.sun);
        else if(Math.abs(Integer.parseInt(right_tem[0])-Integer.parseInt(tem[0]))>2&&(Integer.parseInt(right_tem[0])<Integer.parseInt(tem[0]))) //더울 때
            temperature_img.setImageResource(R.drawable.hot);
        else //추울 때
            temperature_img.setImageResource(R.drawable.cold);

    }

}