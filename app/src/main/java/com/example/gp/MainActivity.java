package com.example.gp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean stop=false;

    public void playerTap(View view) {
        ImageView img = (ImageView)view;
        Integer chng = Integer.parseInt(img.getTag().toString());
//        Toast.makeText(this, img.getTag().toString(), Toast.LENGTH_SHORT).show();
        if(stop)
            Toast.makeText(this, "Please restart", Toast.LENGTH_SHORT).show();
        else if(gameState[chng]==2 && activePlayer==0) {
            img.setImageResource(R.drawable.x);
            gameState[chng]=0;
            if(checkWin(activePlayer,gameState)) {
                Toast.makeText(this, "Player X won", Toast.LENGTH_SHORT).show();
                stop=true;
            }
            activePlayer = 1;
        }
        else if(gameState[chng]==2 && activePlayer==1) {
            img.setImageResource(R.drawable.o);
            gameState[chng]=1;
            if(checkWin(activePlayer,gameState)) {
                Toast.makeText(this, "Player O won", Toast.LENGTH_SHORT).show();
                stop=true;
            }
            activePlayer = 0;
        }
        else {
            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkWin(int player,int[] state) {
        int[][] winPos = {{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
        for(int i=0;i<8;i++) {
            if(state[winPos[i][0]]==state[winPos[i][1]] && state[winPos[i][0]]==state[winPos[i][2]] && state[winPos[i][0]]!=2) {
                return true;
            }
        }
        return false;
    }

    public void refresh(View view) {
        for(int i=0;i<9;i++) {
            gameState[i]=2;
        }
         stop=false;
         activePlayer = 0;
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
