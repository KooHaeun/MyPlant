package com.example.myplant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myplant.databinding.FragmentHumidityBinding;

public class HumidityFragment extends Fragment {

    private ImageView humidity_img;
    private String humidity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_humidity,container, false);

        humidity_img = root.findViewById(R.id.humidity);
        Integer humidity_int = Integer.parseInt(humidity);
        if(humidity_int>=80)
            humidity_img.setImageResource(R.drawable.drop);
        else if(humidity_int>=50)
            humidity_img.setImageResource(R.drawable.drop);
        else if(humidity_int>=30)
            humidity_img.setImageResource(R.drawable.drop);
        else
            humidity_img.setImageResource(R.drawable.drop);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

