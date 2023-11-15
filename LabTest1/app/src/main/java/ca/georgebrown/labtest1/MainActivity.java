package ca.georgebrown.labtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find UI elements to work on them.
        TextView fullName = findViewById(R.id.fullName);
        TextView studentID = findViewById(R.id.studentID);
        Button btn = findViewById(R.id.btn);

        //create a listener for the button.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            //create an intent and use it as a menu to access Colors Activity.
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}