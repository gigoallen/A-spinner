package com.gigoallen.a_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] viceMeal = {"咖啡", "果汁", "可樂"};
    static String mainMealOK, mainMeals, viceMealOK, viceMeals;
    //private Spinner spinnerMainMeal;
    //private Spinner spinnerViceMeal;

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

       //註冊 MainMeal OnItemsSelectedListener 監聽
        spinnerMainMeal.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        mainMealOK = adapterView.getSelectedItem().toString();
                        mainMeals = "主餐為：" + mainMealOK;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

        //註冊 ViceMeal OnItemsSelectedListener 監聽
        spinnerViceMeal.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        viceMealOK = adapterView.getSelectedItem().toString();
                        viceMeals = "副餐為：" + viceMealOK;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

    }
/*
    private AdapterView.OnItemClickListener spinnerMainListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    mainMeal = parent.getSelectedItem().toString();
                    mainMeals = "主餐為：" + mainMeal;
                }

            };
*/
    public void btnOrder(View view) {

        TextView txtShow = findViewById(R.id.txtShow);
        txtShow.setText(mainMeals + "\n" + viceMeals);
    }
}
