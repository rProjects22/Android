package ca.georgebrown.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //creating layouts using XML resources.
    private Button second_btn, web_btn, map_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to associate main_activity.xml layout with the activity, use the method call
        //setContentView() with the identifier of the main_activity.xml layout.
        //(the id of the layout matches  XML file without the extension.)
        setContentView(R.layout.main_activity);

        second_btn = findViewById(R.id.second_btn);
        map_btn = findViewById(R.id.map_btn);
        web_btn = findViewById(R.id.web_btn);

        second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this button should open another activity we don't have yet.
                //creating an intent. (starting another activity with intent.)
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //SecondActivity.class(?)
                //this kind of intent called explicit intent. Leading to parent.
                startActivity(intent); // starting and finishing the activity.
                //starting intent in main activity and finish activity on SecondActivity after you are finished.
            }
        });
        //having a navigation element and the intent.
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW); //same syntax with ACTION_DIAL on the slides pg.4
                //an implicit intent, action. For this intent we have to set data.
                //there are different ways to do this but this is the laziest way.
                intent.setData(Uri.parse("https://georgebrown.ca"));
                startActivity(intent);
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:43.6761356,-79.4130149?q="
                +Uri.encode("160 Kendal Avenue, Toronto"))); //you can write what ever you want
                startActivity(intent);
            }
        });
    }
}