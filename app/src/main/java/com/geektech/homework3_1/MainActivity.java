package com.geektech.homework3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_send;
    private EditText email;
    private EditText lines;
    private EditText msg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = findViewById(R.id.btn_send);
        email = findViewById(R.id.email);
        lines = findViewById(R.id.lines);
        msg = findViewById(R.id.msg);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() && !lines.getText().toString().isEmpty()
                && !msg.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, lines.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());
                    intent.setType("message/rfc822");
                    if(intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Ошибка",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Введите текст",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

