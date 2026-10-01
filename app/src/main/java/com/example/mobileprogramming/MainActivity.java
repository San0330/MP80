package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //- enable edge-to-edge display
        //- could be excluded, for exam
        EdgeToEdge.enable(this);

        setContentView(R.layout.events);

        //- used to handle window insets in an Android app
        //- could be excluded for exam
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //- Insets represent the areas of the screen occupied by system UI
        //- elements like the status bar, navigation bar, and gesture insets.

        // method 1: separate named inner class (MyClickListener) implementing OnClickListener
        //- reusable and keeps onCreate short
        Button myButton = findViewById(R.id.btn1);
        myButton.setOnClickListener(new MyClickListener());

        // method 2: anonymous inner class created inline with new View.OnClickListener()
        //- handler is written right where it is attached; good for one-off, short logic
        Button loginBtn = findViewById(R.id.btn2);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button2 clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Button1 Clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
