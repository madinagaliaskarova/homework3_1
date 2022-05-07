package com.geektech.homework3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
                        email.getText().toString(), null));
                intent.putExtra(Intent.EXTRA_EMAIL, email.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, lines.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());
                startActivity(Intent.createChooser(intent, "send"));
            }
        });
    }
}