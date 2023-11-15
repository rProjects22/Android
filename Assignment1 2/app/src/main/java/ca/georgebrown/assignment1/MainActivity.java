package ca.georgebrown.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find UI elements to work on them.
        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        TextView out1 = findViewById(R.id.output1);
        TextView out2 = findViewById(R.id.output2);

        //set outputs to empty.
        out1.setText(R.string.empty1);
        out2.setText(R.string.empty2);

        //create a listener for the button.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //read input1 from the user, if no input set to 0.
                String no_of_hours = input1.getText().toString();
                if(no_of_hours.isEmpty()){
                    no_of_hours ="0";
                }
                float val1 = Float.valueOf(no_of_hours);

                //read input2 from the user, if no input set to 0
                String hourly_rate = input2.getText().toString();
                if(hourly_rate.isEmpty()){
                    hourly_rate ="0";
                }
                float val2 = Float.valueOf(hourly_rate);

                //calculate the pay.
                double pay;
                if(val1 <= 40.00){
                     pay = val1 * val2;
                }
                else {
                     pay = ((val1-40)*(val2*1.5) + (40*val2));
                }
                //calculate the tax.
                double tax= pay*(0.18);

                out1.setText("Total Pay: "+pay);
                out2.setText("Tax: "+tax);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}