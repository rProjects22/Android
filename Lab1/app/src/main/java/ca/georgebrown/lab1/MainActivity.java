package ca.georgebrown.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate is where layout is created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView is the action that does it.
        //R class, layout folder --> activity_main.

        Button btn = findViewById(R.id.button);
        EditText input = findViewById(R.id.input);
        TextView out = findViewById(R.id.output);

        //instead of hardcoding, creating a string and setting it to default empty for output.
        out.setText(R.string.empty);

        //reaction to the button click.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting text
                String txt = input.getText().toString();
                //there is a class called edit --> getText() belongs to this class.
                String res = txt.toUpperCase(Locale.ROOT);
                out.setText(res);
                //certain methods are not visible here, bc we are on the OnClickListener.
                //Lab2,ZOOM,39:30sec
            }
        });


    }
}