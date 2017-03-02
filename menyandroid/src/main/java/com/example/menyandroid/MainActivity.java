package com.example.menyandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chb1,chb2;
    TextView tvColor, tvSize;
    final int TEXT_COLOR_RED = 1;
    final int TEXT_COLOR_GREEN = 2;
    final int TEXT_COLOR_BLUE = 3;
    final int TEXT_SIZE_22 = 4;
    final int TEXT_SIZE_26 = 5;
    final int TEXT_SIZE_30 = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chb1 = (CheckBox) findViewById(R.id.checkBox1);
        chb2 = (CheckBox) findViewById(R.id.checkBox2);

        tvColor = (TextView) findViewById(R.id.textViewColor);
        tvSize = (TextView) findViewById(R.id.textViewSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);



    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupVisible(R.id.action_group1,chb1.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textViewColor:
                menu.add(0,TEXT_COLOR_RED,0,"Red");
                menu.add(0,TEXT_COLOR_GREEN,0,"Green");
                menu.add(0,TEXT_COLOR_BLUE,0,"Blue");
                break;
            case R.id.textViewSize:
                menu.add(0,TEXT_SIZE_22,0,"22");
                menu.add(0,TEXT_SIZE_26,0,"26");
                menu.add(0,TEXT_SIZE_30,0,"30");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case TEXT_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = RED");
                break;
            case TEXT_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = GREEN");
                break;
            case TEXT_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = BLUE");
                break;
            case TEXT_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case TEXT_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case TEXT_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("Text size = 30");
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.android_bar,menu);
        final MenuItem menuItem = menu.findItem(R.id.action_menu5);
        chb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chb2.isChecked()){
                    menuItem.setVisible(true);
                }else {
                    menuItem.setVisible(false);
                }
            }
        });
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_menu3){
            Toast.makeText(MainActivity.this,"Menu3",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_menu5){
            Toast.makeText(MainActivity.this,"I am a camera",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_menu6){
            Toast.makeText(MainActivity.this,"I am a compass",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_menu1){
            Toast.makeText(MainActivity.this,"I am a menu1",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_menu2){
            Toast.makeText(MainActivity.this,"I am a menu2",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_menu4){
            Toast.makeText(MainActivity.this,"I am a menu 4",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
