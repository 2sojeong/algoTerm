package com.example.algoterm;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    knapsack fra;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        fra = (knapsack) StartMainpage.fra;

        String result;
        String output1;
        String output2;

        result = fra.PrintOut();

        int check = result.indexOf("@");
        output1 = result.substring(0,check);
        output2 = result.substring(check+1);

        TextView studyText = (TextView) findViewById(R.id.studySeq);
        TextView remainText = (TextView) findViewById(R.id.remainStu);
        //Log.d("My tag2",result);
        studyText.setText(output1);
        remainText.setText(output2);

    }
}
