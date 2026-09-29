package com.example.mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
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

        setContentView(R.layout.widgets);

        //- used to handle window insets in an Android app
        //- could be excluded for exam
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //- Insets represent the areas of the screen occupied by system UI
        //- elements like the status bar, navigation bar, and gesture insets.

        //- Spinner has no android:onClick, so a listener is set in Java
        Spinner spCountry = findViewById(R.id.spCountry);
        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Country: " + country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //- required by the interface; nothing to do here
            }
        });
    }

    //- called when the button with android:onClick="onSubmitClick" is tapped
    public void onSubmitClick(View view) {
        Toast.makeText(this, "Submitted!", Toast.LENGTH_SHORT).show();
    }

    //- called when the checkbox is tapped; view is the CheckBox itself
    public void onCheckboxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        Toast.makeText(this, checked ? "Agreed" : "Not agreed", Toast.LENGTH_SHORT).show();
    }

    //- called when a radio button is tapped; view is the RadioButton itself
    public void onRadioClick(View view) {
        RadioButton rb = (RadioButton) view;
        Toast.makeText(this, "Selected: " + rb.getText(), Toast.LENGTH_SHORT).show();
    }
}
