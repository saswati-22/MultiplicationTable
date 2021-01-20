package com.saswati.multiplicationtable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView heading;
    SeekBar seek;
    ListView listview;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heading=findViewById(R.id.heading);
        seek=findViewById(R.id.seek);
        listview=findViewById(R.id.listview);
        seek.setMax(20);
        seek.setMin(1);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this,"Populating table of" + progress,Toast.LENGTH_SHORT).show();
                Table(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public  void Table(int table)
    {
        ArrayList<String> multipleTable=new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
           multipleTable.add(table +"x"+i +"="+ table*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, multipleTable);
        listview.setAdapter(arrayAdapter);

    }


}