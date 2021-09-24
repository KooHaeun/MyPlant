package com.example.myplant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TemperatureFragment extends Fragment {

    private TextView right_temperature, temperature_txt;
    private ImageView temperature_img;
    private String right_tem, tem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_temperature,container, false);

        temperature_img = root.findViewById(R.id.temperature_img);
        right_temperature = root.findViewById(R.id.right_temperature);
        temperature_txt = root.findViewById(R.id.temperature_txt);
        right_tem = (String) right_temperature.getText();
        tem = (String) temperature_txt.getText();
        if(Math.abs(Integer.parseInt(right_tem)-Integer.parseInt(tem))<=2)
            temperature_img.setImageResource(R.drawable.heat);
        else if(Integer.parseInt(right_tem)-Integer.parseInt(tem)>2) //더울 때
            temperature_img.setImageResource(R.drawable.heat);
        else //추울 때
            temperature_img.setImageResource(R.drawable.heat);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}