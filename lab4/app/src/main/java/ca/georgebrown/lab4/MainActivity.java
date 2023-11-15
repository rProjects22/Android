package ca.georgebrown.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements MovieFragment.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_fragment,
                        DetailsFragment.newInstance("10"))
                .commit();

    }

    @Override
    public void onClick(int position) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_fragment,
                        DetailsFragment.newInstance(String.valueOf(position)))
                .commit();
    }
}