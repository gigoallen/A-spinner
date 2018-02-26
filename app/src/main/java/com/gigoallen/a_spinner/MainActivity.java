package com.gigoallen.a_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] viceMeal = {"咖啡", "果汁", "可樂"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //使用Spinner元件
        Spinner spinnerMainMeal = findViewById(R.id.spMainMeal);
        Spinner spinnerViceMeal = findViewById(R.id.spViceMeal);

        //取得 array.xml 裡面的 mainMeal 字串陣列
        ArrayAdapter<CharSequence> adapterMain =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.mainMeal,
                        android.R.layout.simple_spinner_item);

        spinnerMainMeal.setAdapter(adapterMain);

       //取得 程式裡面的 viceMeal 字串陣列
        ArrayAdapter<String> adapterVice =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        viceMeal);
        adapterVice.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerViceMeal.setAdapter(adapterVice);


    }
}
