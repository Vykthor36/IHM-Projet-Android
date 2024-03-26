package fr.univ_poitiers.m1_ihm_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Attributes
    private SeekBar difficultySeekBar;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficultySeekBar = findViewById(R.id.difficultySeekBar);
    }

    public void startNewGame(android.view.View v) {
        int d = difficultySeekBar.getProgress();

        Intent intent;
        if (d == 0) {
            intent = new Intent(this, EndActivity.class);
            intent.putExtra("isWon", true);
            intent.putExtra("details", getResources().getString(R.string.gameDetailsTextViewEasy));
        } else if (d == 2) {
            intent = new Intent(this, EndActivity.class);
            intent.putExtra("isWon", false);
            intent.putExtra("details", getResources().getString(R.string.gameDetailsTextViewHard));
        } else intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);
    }
}