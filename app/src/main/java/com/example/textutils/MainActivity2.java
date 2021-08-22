package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    String Text2;
    EditText text;
    Button uppercase,copyText;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().hide();

        text = findViewById(R.id.edit_text);
        uppercase = findViewById(R.id.upper_case);
        view = findViewById(R.id.view);
        copyText = findViewById(R.id.copy_text);

        uppercase.setOnClickListener(v -> {
            String Text = text.getText().toString();
            Text2 = Text.toUpperCase();
            text.setText(Text2);
        });

        copyText.setOnClickListener(v -> {
            ClipboardManager myClipboard;
            myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData myClip;

            myClip = ClipData.newPlainText("text", Text2);
            myClipboard.setPrimaryClip(myClip);

            Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
        });

    }
}