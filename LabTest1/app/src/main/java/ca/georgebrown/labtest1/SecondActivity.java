package ca.georgebrown.labtest1;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //initialize elements.
        ListView listView;
        listView = findViewById(R.id.view_color);

        //create an array for the list of items.
        String[] arrayList = {"Blue", "Red", "Green"};

        //create an array adapter.
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);

        //set Adapter for the listView.
        listView.setAdapter(arrayAdapter);

        //create a listener for the button.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //change the colors by from array list indexes by clicking.
                if(i==0){
                    adapterView.setBackgroundColor(BLUE);
                } else if (i==1){
                    adapterView.setBackgroundColor(RED);
                } else if (i==2){
                    adapterView.setBackgroundColor(GREEN);
                }
            }
        });

    }
}