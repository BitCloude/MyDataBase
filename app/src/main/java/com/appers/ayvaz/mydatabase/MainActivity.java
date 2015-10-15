package com.appers.ayvaz.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button butAct2, butAct3;
    String name;
    String num;
    DBUtility dbUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butAct2 = (Button) findViewById(R.id.butAct2);
        butAct3 = (Button) findViewById(R.id.butAct3);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        num = intent.getStringExtra("num");
        dbUtility = new DBUtility(getApplicationContext());
        if(name != null && num != null)
        dbUtility.insertData(name,num);

        butAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateOrderActivity.class);
                startActivity(intent);
            }
        });

        butAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowOrderActivity.class);
                startActivity(intent);
            }
        });

    }
}
