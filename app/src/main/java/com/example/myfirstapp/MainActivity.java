package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String[] canteens = {"桃李", "紫荆", "丁香", "听涛", "万人", "清芬", "玉树", "芝兰", "照澜"};
    private Spinner spinner;
    private ArrayList<String> canteenList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        //利用适配器加载下拉列表样式
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dialog, canteens);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                tv.setGravity(android.view.Gravity.CENTER_HORIZONTAL);   //设置居中
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //当用户点击添加按钮时调用
    public void addCanteen(View view) {
        TableLayout canteenTabel = findViewById(R.id.canteenTable);
        //spinner中选择的餐厅名
        String canteen = spinner.getSelectedItem().toString();
        //已存在于列表中的不作处理
        if (canteenList.contains(canteen)) {
        } else {
            canteenList.add(canteen);
            TextView tv = new TextView(this);
            tv.setText(canteen);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setTextSize(30);
            tv.setTextColor(Color.WHITE);
            tv.setBackgroundResource(R.drawable.border);
            canteenTabel.addView(tv);
        }
    }

    //当用户点击选择按钮时调用
    public void selectCanteenRandomly(View view) {
        Intent intent = new Intent(this, SelectCanteenActivity.class);
        //未选择任何餐厅的情况下默认选择所有
        if (canteenList.size() == 0) {
            for (String canteen : canteens) {
                canteenList.add(canteen);
            }
        }
        intent.putStringArrayListExtra(EXTRA_MESSAGE, canteenList);
        startActivity(intent);
    }
}
