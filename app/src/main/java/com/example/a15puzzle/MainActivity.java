package com.example.a15puzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ConstraintLayout myLayout;
    private AnimationDrawable animationDrawable;
    private Button btn1;
    private Switch musicSw;
    private boolean musicTurn;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        btn1 = findViewById(R.id.btn1ID);
        musicSw = findViewById(R.id.musicSwitch);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        btn1.setOnClickListener(this);
        musicSw.setOnCheckedChangeListener(this);
        musicTurn = sp.getBoolean("musicTurn",true);
        musicSw.setChecked(musicTurn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1ID:
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("turnTheMusic",musicTurn);
                startActivity(intent);
                break;
            default:
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton cB, boolean b){
        if(musicSw.isChecked()) {
            Toast.makeText(this, "Music is On", Toast.LENGTH_SHORT).show();
            this.musicTurn=true;
            this.editor = sp.edit();
            this.editor.putBoolean("musicTurn",true);
            editor.commit();

        }
        else {
            Toast.makeText(this, "Music is Off", Toast.LENGTH_SHORT).show();
            this.musicTurn=false;
            this.editor = sp.edit();
            this.editor.putBoolean("musicTurn",false);
            editor.commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("About");
        MenuItem menuItem2 = menu.add("Exit");


        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("About");
                alertDialog.setMessage("This app implement the Game of Fifteen\r\n\r\nBy Lidor Zaken and Itai Gabai (c)");
                alertDialog.show();

                return true;
            }
        });

        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Exit App");
                alertDialog.setMessage("Do you really want to exit?");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // destroy this activity
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();

                return true;
            }
        });

        return true;
    }

}
