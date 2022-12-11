package com.example.algoterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static User newtb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        
        //id로 패널들 가져오기
        Button startbtn=(Button) findViewById(R.id.next_btn);

        //시간
        EditText numEdit = (EditText) findViewById(R.id.number_EditText);
        //과목
        EditText totalEdit = (EditText) findViewById(R.id.time_EditText);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*입력한거 저장하기*/
                //시간
                int num = Integer.parseInt(numEdit.getText().toString().trim());
                //과목
                int total = Integer.parseInt(totalEdit.getText().toString().trim());
                
                newtb=new User();
                newtb.setnum(num);
                newtb.settotal(total);

                Intent intent = new Intent(MainActivity.this, StartMainpage.class);
                startActivity(intent);

            }
        });
    }

    public void btn(View view) {
    }
}