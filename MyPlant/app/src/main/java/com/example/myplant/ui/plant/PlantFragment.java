package com.example.myplant.ui.plant;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myplant.MainActivity;
import com.example.myplant.PlantListItem;
import com.example.myplant.R;
import com.example.myplant.databinding.FragmentPlantBinding;

import java.util.ArrayList;

public class PlantFragment extends Fragment {

    private ListView plantList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_plant,container, false);

        plantList = root.findViewById(R.id.plant_list);
        myAdapter adapter = new myAdapter();
        plantList.setAdapter(adapter);
        setList(adapter);



        return root;
    }

    public void setList(myAdapter adapter){
        adapter.addItem(R.drawable.plant1, "연두", "2021.07.17");
        adapter.addItem(R.drawable.plant2, "푸름", "2021.08.15");
        adapter.addItem(R.drawable.plant3, "초록", "2021.09.21");
        adapter.addItem(R.drawable.plant4, "노랑", "2021.10.03");
    }

    public class myAdapter extends BaseAdapter {

        public ArrayList<PlantListItem> list = new ArrayList<PlantListItem>();

        //초기화
        public myAdapter() {}

        //리스트 뷰 아이템 개수 알려줌
        public int getCount() {
            return list.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //현재 아이템 알려줌
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        //리스트뷰에서 아이템과 xml을 연결하여 화면에 출력
        @NonNull
        @Override
        public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

            final Context c = parent.getContext();
            if (view == null) {//xml로 된 layout파일을 view 객체로 변환
                LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.plant_list, parent, false);
            }

            ImageView plant_img =view.findViewById(R.id.plant_img);
            TextView plant_name = view.findViewById(R.id.plant_name);
            TextView plant_date = view.findViewById(R.id.plant_date);

            final PlantListItem myList = list.get(position);
            plant_img.setImageResource(myList.getPlant_img());
            plant_name.setText(myList.getPlant_name());
            plant_date.setText(myList.getPlant_date());


            return view;
        }

        //HosListItem 클래스에 정의한 set 메소드에 데이터를 담아서 리턴함
        public void addItem(Integer plant_img, String plant_name, String plant_date) {
            PlantListItem item = new PlantListItem();

            item.setPlant_img(plant_img);
            item.setPlant_name(plant_name);
            item.setPlant_date(plant_date);

            list.add(item);
        }
    }

}