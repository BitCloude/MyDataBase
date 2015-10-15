package com.appers.ayvaz.mydatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowOrderActivity extends AppCompatActivity {
DBUtility dbUtility;
    Spinner spinner;
    ArrayList<String> options=new ArrayList<String>();
    ArrayList<String> test=new ArrayList<String>();

    ArrayList<String> options2=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        spinner = (Spinner) findViewById(R.id.spinner);
        test.add("A");
        test.add("B");
        int i=0;
        String name= "null";
        dbUtility = new DBUtility(getApplicationContext());
        Cursor cursor = dbUtility.retreive();
        if((cursor.getCount() >0)){
            while (cursor.moveToNext()){
                options.add(cursor.getString(0));
                options2.add(cursor.getString(1));
                Log.i("OPTIONS",""+options);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,options);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String name = "alex";
                String amount = "null";
                Toast.makeText(getApplicationContext(),"Amount: "+ options2.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
