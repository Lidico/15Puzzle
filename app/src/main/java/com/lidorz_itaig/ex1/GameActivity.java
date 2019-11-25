package com.lidorz_itaig.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidorz_itaig.ex1.R;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private GameBoard gb = new GameBoard();
    private Timer time;
    private ImageView a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
    private Button startNewGameBtn;
    private int[] pPosition;
    private int[] pressedPosition = new int[2];
    private String[][] arrayOfBoard;
    private MediaPlayer appMusic;
    private int movesCounter = 0;
    private TextView tVmovesCounter;
    private TextView tVtimer;
    private Intent intent;
    private TextView timer;
    private String pTag;
    private boolean turnTheMusic;
    private boolean buttonClicked = false;
    private  boolean gameOver;


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
                    this.pTag = (String)ig.getTag();
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

            //Start New Game Button.
            startNewGameBtn.setOnClickListener(this);

    }

    private void setClickablity(String pPos) {
        switch(pPos) {
            case "00":
                b.setClickable(true);
                e.setClickable(true);
                break;
            case "01":
                a.setClickable(true);
                c.setClickable(true);
                f.setClickable(true);
                break;
            case "02":
                b.setClickable(true);
                d.setClickable(true);
                g.setClickable(true);

                break;
            case "03":
                c.setClickable(true);
                h.setClickable(true);

                break;
            case "10":
                a.setClickable(true);
                f.setClickable(true);
                i.setClickable(true);
                break;
            case "11":
                b.setClickable(true);
                e.setClickable(true);
                g.setClickable(true);
                j.setClickable(true);
                break;
            case "12":
                c.setClickable(true);
                f.setClickable(true);
                h.setClickable(true);
                k.setClickable(true);
                break;
            case "13":
                d.setClickable(true);
                g.setClickable(true);
                l.setClickable(true);
                break;
            case "20":
                e.setClickable(true);
                j.setClickable(true);
                m.setClickable(true);
                break;
            case "21":
                i.setClickable(true);
                f.setClickable(true);
                n.setClickable(true);
                k.setClickable(true);
                break;
            case "22":
                g.setClickable(true);
                j.setClickable(true);
                l.setClickable(true);
                o.setClickable(true);
                break;
            case "23":
                h.setClickable(true);
                p.setClickable(true);
                k.setClickable(true);
                break;
            case "30":
                i.setClickable(true);
                n.setClickable(true);
                break;
            case "31":
                j.setClickable(true);
                m.setClickable(true);
                o.setClickable(true);
                break;
            case "32":
                n.setClickable(true);
                k.setClickable(true);
                p.setClickable(true);
                break;
            case "33":
                l.setClickable(true);
                o.setClickable(true);
                break;

            default:
                // code block
        }

    }

    private void boardInit() {
            setMovesCounter(this.tVmovesCounter);
            this.gameOver = gb.isGameOver();
            this.arrayOfBoard = gb.getToBoard();
            this.pPosition = gb.getPPosition();
            setBoard();
            lockItAll();
            setClickablity(pTag);
            if(gameOver){
                lockItAll();
                time.pause();
                Toast.makeText(this, "Game Over - Puzzle Solved", Toast.LENGTH_LONG).show();
            }
    }

    private void setMovesCounter(TextView tvC) {
        this.movesCounter++;
        final String counterTV = String.format("%04d", this.movesCounter);
        tvC.setText(counterTV);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameOver = false;
        tVtimer = findViewById(R.id.timeCounter);
        time = new Timer(tVtimer);
        time.start();
        startNewGameBtn = findViewById(R.id.startNewGameBtn);
        gb.setPPosition();
        arrayOfBoard = gb.getToBoard();
        setBoard();
        appMusic = MediaPlayer.create(getApplicationContext(),R.raw.appsong);
        appMusic.setLooping(true);
        tVmovesCounter = findViewById(R.id.moveCounter);

        intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            turnTheMusic = extras.getBoolean("turnTheMusic");
        }
        giveUsMusic();
        lockItAll();
        setClickablity(pTag);
    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        appMusic.pause();
        time.pause();
    }

    @Override
    public void onResume(){
        super.onResume();
        giveUsMusic();
        time.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 0;
                this.pressedPosition[1] = 0;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();

                break;
            case R.id.b:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 0;
                this.pressedPosition[1] = 1;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.c:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 0;
                this.pressedPosition[1] = 2;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.d:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 0;
                this.pressedPosition[1] = 3;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.e:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 1;
                this.pressedPosition[1] = 0;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.f:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 1;
                this.pressedPosition[1] = 1;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.g:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 1;
                this.pressedPosition[1] = 2;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.h:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 1;
                this.pressedPosition[1] = 3;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.i:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 2;
                this.pressedPosition[1] = 0;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.j:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 2;
                this.pressedPosition[1] = 1;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.k:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 2;
                this.pressedPosition[1] = 2;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.l:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 2;
                this.pressedPosition[1] = 3;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.m:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 3;
                this.pressedPosition[1] = 0;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.n:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 3;
                this.pressedPosition[1] = 1;
                gb.swapPosition(pPosition, pressedPosition);
                boardInit();
                break;
            case R.id.o:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 3;
                this.pressedPosition[1] = 2;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.p:
                this.pPosition= gb.getPPosition();
                this.pressedPosition[0] = 3;
                this.pressedPosition[1] = 3;
                gb.swapPosition(pPosition, pressedPosition);
                this.pPosition= gb.getPPosition();
                boardInit();
                break;
            case R.id.startNewGameBtn:
                gb = new GameBoard();
                gameOver = false;
                gb.setPPosition();
                arrayOfBoard = gb.getToBoard();
                setBoard();
                time.reset();
                time.start();
                appMusic.pause();
                appMusic.seekTo(0);
                giveUsMusic();
                this.movesCounter = -1;
                setMovesCounter(this.tVmovesCounter);
                break;

            default:
        }
    }



}


