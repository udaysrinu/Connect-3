package com.example.connect_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{   int j=9;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningpositions={{0,1,2},{3,4,5,},{6,7,8},{0,4,8},{6,4,2},{0,3,6},{1,4,7},{2,5,8}};
    //yellow=0
    int activePlayer =0;
    boolean gameactive=true;
    public void dropIn(View v)
    {
        ImageView counter=(ImageView)v;
        int tapcount=Integer.parseInt(counter.getTag().toString());
        if(gamestate[tapcount]==2&&gameactive){
        gamestate[tapcount]=activePlayer;
        counter.setTranslationY(-1000);
        if(activePlayer==0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer=1;
            j--;
        }
        else {
            counter.setImageResource(R.drawable.red);
            activePlayer=0;
            j--;
        }
        counter.animate().translationYBy(1000).rotation(3600).setDuration(400);
            String winner="It,s a TIE";
        for(int[] winningPosition:winningpositions)
        {
            if(gamestate[winningPosition[0]]==gamestate[winningPosition[1]]&&gamestate[winningPosition[1]]== gamestate[winningPosition[2]]&&gamestate[winningPosition[0]]!=2) {
                gameactive =false;

               if (activePlayer == 1)
                    winner = "Yellow has won!!";
               else
                   winner = "Red has won!!";


               Toast.makeText(this,"congratulations!!",Toast.LENGTH_SHORT).show();
                Button playagain =(Button)findViewById(R.id.button);
                TextView winnertext=(TextView)findViewById(R.id.winnertext);
                winnertext.setText(winner);
                playagain.setVisibility(View.VISIBLE);
                winnertext.setVisibility(View.VISIBLE);
                j++;
                }
            }
            if(j==0) {
                Toast.makeText(this, "Oops!!", Toast.LENGTH_SHORT).show();
                Button playagain =(Button)findViewById(R.id.button);
                TextView winnertext=(TextView)findViewById(R.id.winnertext);
                winnertext.setText(winner);
                playagain.setVisibility(View.VISIBLE);
                winnertext.setVisibility(View.VISIBLE);
            }
        }
    }
    public void youplayagain(View x) {
        Button playagain =(Button)findViewById(R.id.button);
        TextView winnertext=(TextView)findViewById(R.id.winnertext);

        playagain.setVisibility(View.INVISIBLE);

        winnertext.setVisibility(View.INVISIBLE);

        GridLayout grid = (GridLayout) findViewById(R.id.GRIDLAYOUT);

        for(int i=0;i<grid.getChildCount();i++){
            ImageView block = (ImageView) grid.getChildAt(i);
            block.setImageDrawable(null);
        }

        for(int i=0;i<gamestate.length;i++)
            gamestate[i]=2;
        activePlayer =0;
         gameactive=true;
        j=9;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
