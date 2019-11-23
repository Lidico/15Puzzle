package com.example.a15puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameBoard gb = new GameBoard();
    private ImageView a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
    private String[][] arrayOfBoard;
    private MediaPlayer appMusic;
    private Intent intent;
    private TextView timer;
    boolean turnTheMusic;


    private void whichPic(ImageView ig, String a) {
            switch(a) {
                case "a":
                    ig.setImageResource(R.drawable.a);
                    break;
                case "b":
                    ig.setImageResource(R.drawable.b);
                    break;
                case "c":
                    ig.setImageResource(R.drawable.c);
                    break;
                case "d":
                    ig.setImageResource(R.drawable.d);
                    break;
                case "e":
                    ig.setImageResource(R.drawable.e);
                    break;
                case "f":
                    ig.setImageResource(R.drawable.f);
                    break;
                case "g":
                    ig.setImageResource(R.drawable.g);
                    break;
                case "h":
                    ig.setImageResource(R.drawable.h);
                    break;
                case "i":
                    ig.setImageResource(R.drawable.i);
                    break;
                case "j":
                    ig.setImageResource(R.drawable.j);
                    break;
                case "k":
                    ig.setImageResource(R.drawable.k);
                    break;
                case "l":
                    ig.setImageResource(R.drawable.l);
                    break;
                case "m":
                    ig.setImageResource(R.drawable.m);
                    break;
                case "n":
                    ig.setImageResource(R.drawable.n);
                    break;
                case "o":
                    ig.setImageResource(R.drawable.o);
                    break;
                case "p":
                    ig.setImageResource(R.drawable.p);
                    break;

                default:
                    // code block
            }
    }

    private void giveUsMusic() {
        if(turnTheMusic) {
            appMusic.start();
        }
    }

    private void lockItAll() {
        a.setClickable(false);
        b.setClickable(false);
        c.setClickable(false);
        d.setClickable(false);
        e.setClickable(false);
        f.setClickable(false);
        g.setClickable(false);
        h.setClickable(false);
        i.setClickable(false);
        j.setClickable(false);
        k.setClickable(false);
        l.setClickable(false);
        m.setClickable(false);
        n.setClickable(false);
        o.setClickable(false);
        p.setClickable(false);
    }

    private void setBoard() {
            //row 1
            a = findViewById(R.id.a);
            whichPic(a,arrayOfBoard[0][0]);
            a.setOnClickListener(this);
            b = findViewById(R.id.b);
            whichPic(b,arrayOfBoard[0][1]);
            b.setOnClickListener(this);
            c = findViewById(R.id.c);
            whichPic(c,arrayOfBoard[0][2]);
            c.setOnClickListener(this);
            d = findViewById(R.id.d);
            whichPic(d,arrayOfBoard[0][3]);
            d.setOnClickListener(this);


            //row 2
            e = findViewById(R.id.e);
            whichPic(e,arrayOfBoard[1][0]);
            e.setOnClickListener(this);
            f = findViewById(R.id.f);
            whichPic(f,arrayOfBoard[1][1]);
            f.setOnClickListener(this);
            g = findViewById(R.id.g);
            whichPic(g,arrayOfBoard[1][2]);
            g.setOnClickListener(this);
            h = findViewById(R.id.h);
            whichPic(h,arrayOfBoard[1][3]);
            h.setOnClickListener(this);

            //row 3
            i = findViewById(R.id.i);
            whichPic(i,arrayOfBoard[2][0]);
            i.setOnClickListener(this);
            j = findViewById(R.id.j);
            whichPic(j,arrayOfBoard[2][1]);
            j.setOnClickListener(this);
            k = findViewById(R.id.k);
            whichPic(k,arrayOfBoard[2][2]);
            k.setOnClickListener(this);
            l = findViewById(R.id.l);
            whichPic(l,arrayOfBoard[2][3]);
            l.setOnClickListener(this);

            //row 4
            m = findViewById(R.id.m);
            whichPic(m,arrayOfBoard[3][0]);
            m.setOnClickListener(this);
            n = findViewById(R.id.n);
            whichPic(n,arrayOfBoard[3][1]);
            n.setOnClickListener(this);
            o = findViewById(R.id.o);
            whichPic(o,arrayOfBoard[3][2]);
            o.setOnClickListener(this);
            p = findViewById(R.id.p);
            whichPic(p,arrayOfBoard[3][3]);
            p.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        timer.findViewById(R.id.timeCounter);
        arrayOfBoard = gb.getToBoard();
        setBoard();
        appMusic = MediaPlayer.create(getApplicationContext(),R.raw.appsong);
        appMusic.setLooping(true);

        intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            turnTheMusic = extras.getBoolean("turnTheMusic");
        }
        giveUsMusic();

    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        appMusic.pause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                break;
            case R.id.b:
                break;
            case R.id.c:
                break;
            case R.id.d:
                break;
            case R.id.e:
                break;
            case R.id.f:
                break;
            case R.id.g:
                break;
            case R.id.h:
                break;
            case R.id.i:
                break;
            case R.id.j:
                break;
            case R.id.k:
                break;
            case R.id.l:
                break;
            case R.id.m:
                break;
            case R.id.n:
                break;
            case R.id.o:
                break;
            case R.id.p:
                break;
            default:
        }
    }



}


