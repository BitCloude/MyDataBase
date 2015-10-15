package com.appers.ayvaz.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateOrderActivity extends AppCompatActivity {
EditText name, num;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        name = (EditText) findViewById(R.id.editTextName);
        num = (EditText) findViewById(R.id.editTextNum);
        save = (Button) findViewById(R.id.butsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("num",num.getText().toString());
                startActivity(intent);
            }
        });
    }
}
