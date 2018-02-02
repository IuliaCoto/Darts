package com.example.android.darts;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    final static int SCORE = 180;

    private static final String KEY_INDEX = "index";
    private static final String KEY_INDEX2 = "index2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            scorePlayerOne = savedInstanceState.getInt(KEY_INDEX, scorePlayerOne);
        }
        if (savedInstanceState != null) {
            scorePlayerTwo = savedInstanceState.getInt(KEY_INDEX2, scorePlayerTwo);
        }
        setContentView(R.layout.activity_main);
        displayForPlayerOne(0);
        displayForPlayerTwo(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Increase the score for First Player by 1 point.
     */
    public void addOneForPlayerOne(View v) {
        displayForPlayerOne(1);

    }

    /**
     * Increase the score for First Player by 5 points.
     */
    public void addFiveForPlayerOne(View v) {
        displayForPlayerOne(5);

    }

    /**
     * Increase the score for First Player by 10 points.
     */
    public void addTenForPlayerOne(View v) {
        displayForPlayerOne(10);

    }

    /**
     * Increase the score for First Player by 20 points.
     */
    public void addTwentyForPlayerOne(View v) {
        displayForPlayerOne(20);
    }


    /**
     * Displays the given score for First Player.
     * Indicates that the player cannot obtain more than 180 points in a game.
     */
    public void displayForPlayerOne(int score) {
        scorePlayerOne = scorePlayerOne + score;
        if (scorePlayerOne < 180) {
            TextView scoreView = findViewById(R.id.player_one_score);
            scoreView.setText(String.valueOf(scorePlayerOne));
        } else if (scorePlayerOne == SCORE) {
            TextView scoreView = findViewById(R.id.player_one_score);
            scoreView.setText(String.valueOf(scorePlayerOne));
            Toast.makeText(this, "180 points, Player 1 - You Win!", Toast.LENGTH_SHORT).show();
            resetScore(scoreView);
        } else {
            scorePlayerOne = scorePlayerOne - score;
            Toast.makeText(this, "You cannot obtain more than 180 points!", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, scorePlayerOne);
        savedInstanceState.putInt(KEY_INDEX2, scorePlayerTwo);
    }


    /**
     * Increase the score for Second Player by 1 point.
     */
    public void addOneForPlayerTwo(View v) {
        displayForPlayerTwo(1);
    }

    /**
     * Increase the score for Second Player by 5 points.
     */
    public void addFiveForPlayerTwo(View v) {
        displayForPlayerTwo(5);
    }

    /**
     * Increase the score for Second Player by 10 points.
     */
    public void addTenForPlayerTwo(View v) {
        displayForPlayerTwo(10);

    }

    /**
     * Increase the score for Second Player by 20 points.
     */
    public void addTwentyForPlayerTwo(View v) {
        displayForPlayerTwo(20);

    }

    /**
     * Displays the given score Second Player.
     * Indicates that the player cannot obtain more than 180 points in a game.
     */
    public void displayForPlayerTwo(int scoreTwo) {
        scorePlayerTwo = scorePlayerTwo + scoreTwo;
        if (scorePlayerTwo < 180) {
            TextView scoreView = findViewById(R.id.player_two_score);
            scoreView.setText(String.valueOf(scorePlayerTwo));
        } else if (scorePlayerTwo == SCORE) {
            TextView scoreView = findViewById(R.id.player_two_score);
            scoreView.setText(String.valueOf(scorePlayerTwo));
            Toast.makeText(this, "180 points, Player 2 - You Win!", Toast.LENGTH_SHORT).show();
            resetScore(scoreView);
        } else {
            scorePlayerTwo = scorePlayerTwo - scoreTwo;
            Toast.makeText(this, "You cannot obtain more than 180 points!", Toast.LENGTH_SHORT).show();
        }
    }

    // Reset button - reset the score for player one and for player two.

    public void resetScore(View v) {
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        displayForPlayerOne(scorePlayerOne);
        displayForPlayerTwo(scorePlayerTwo);
    }

}
