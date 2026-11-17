package com.example.mobileprogramming;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //- enable edge-to-edge display
        //- could be excluded, for exam
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        //- used to handle window insets in an Android app
        //- could be excluded for exam
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //- Insets represent the areas of the screen occupied by system UI
        //- elements like the status bar, navigation bar, and gesture insets.

        Log.i("MY_APP", "Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MY_APP", "Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY_APP", "Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY_APP", "Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MY_APP", "Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MY_APP", "Activity destroyed");
    }

}
