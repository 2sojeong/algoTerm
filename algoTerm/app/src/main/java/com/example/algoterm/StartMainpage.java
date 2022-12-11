package com.example.algoterm;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartMainpage extends AppCompatActivity {
    int count = 0;


    User newtb = (User) MainActivity.newtb;;

    EditText[] nameTexts ;
    EditText[] timeTexts ;
    EditText[] valTexts ;

    public static knapsack fra;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusBtn=(Button) findViewById(R.id.plus);
        Button startBtn = (Button) findViewById(R.id.start);

        SetVisble(newtb.gettotal());

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData(newtb.gettotal());
                Intent intent = new Intent(StartMainpage.this, Result.class);
                startActivity(intent);

            }
        });
    }
    //입력받은 과목수 만큼 칸을 생성
    void SetVisble(int total){
        nameTexts = new EditText[total];
        timeTexts = new EditText[total];
        valTexts = new EditText[total];

        for(int i = 0; i < total; i++){
            LinearLayout[] layouts = new LinearLayout[total];
            layouts[i] = findViewById(getResources().getIdentifier("block"+i,"id","com.example.algoterm"));
            layouts[i].setVisibility(View.VISIBLE);
        }
    }
    //과목개수를 넘겨받아 for문을 돌면서 입력한 과목의 정보 받기
    void GetData(int numData){
        Log.d("My tag", String.valueOf(numData));

        Subject[] subarr=new Subject[newtb.getnum()]; //과목 객체 생성;
        Subject[] sequence=new Subject[newtb.getnum()];

        for (int i = 0; i < numData; i++) {
            //이름 받기
            subarr[i] = new Subject();
            sequence[i] = new Subject();
            nameTexts[i] = findViewById(getResources().getIdentifier("block" + i+"_object", "id", "com.example.algoterm"));
            Log.d("My tag", nameTexts[i].getText().toString().trim());
            subarr[i].Setname(nameTexts[i].getText().toString().trim());
            //목표공부시간 입력 받기
            timeTexts[i] = findViewById(getResources().getIdentifier("block" + i+"_time", "id", "com.example.algoterm"));
            subarr[i].Settime(Integer.parseInt(timeTexts[i].getText().toString().trim()));
            //목표공부시간 입력 받기
            valTexts[i] = findViewById(getResources().getIdentifier("block" + i+"_val", "id", "com.example.algoterm"));
            subarr[i].Setval(Integer.parseInt(valTexts[i].getText().toString().trim()));
        }

        fra=new knapsack();
        fra.sort(subarr,numData);
        fra.fractional(subarr,sequence, newtb.getnum(),numData);
    }
}


