package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SelectCanteenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_canteen);

        //获取Intent并提取所需信息
        Intent intent = getIntent();
        ArrayList<String> canteenList = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);
        int canteenNum = canteenList.size();
        Random random = new Random();
        int num = random.nextInt(canteenNum);
        String canteen_selected = canteenList.get(num);

        //将随机结果显示到文本框中去
        TextView textView = findViewById(R.id.textView);
        textView.setText("那就去" + canteen_selected + "吧");
    }
}
