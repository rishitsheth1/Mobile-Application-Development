package com.example.sahil.sahilmahajan_assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] brandsArray = {"Honda","Chevrolet","Ford","Nissan"};
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listview, brandsArray);

        final ListView listView = (ListView) findViewById(R.id.brandslistView);
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
                        intent = new Intent(MainActivity.this, HondaActivity.class);
                        break;
                }
                startActivity(intent);

            }

        });
    }

}
