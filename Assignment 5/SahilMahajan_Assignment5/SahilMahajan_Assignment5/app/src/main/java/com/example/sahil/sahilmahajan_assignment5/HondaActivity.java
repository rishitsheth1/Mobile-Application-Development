package com.example.sahil.sahilmahajan_assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HondaActivity extends AppCompatActivity {
    String[] italianarray = {"Honda Civic","Honda Accord"};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honda);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listview, italianarray);

        final ListView listView = (ListView) findViewById(R.id.italianrestaurants);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                //String item = (String) lstView.getItemAtPosition(position);
                switch(itemPosition)
                {
                    case 0:
                        intent = new Intent(HondaActivity.this, MapsActivity.class);
                        intent.putExtra("lat","43.6456");
                        intent.putExtra("lng","-79.3905");
                        startActivity(intent);
                        break;

                }

            }

        });
    }
}
