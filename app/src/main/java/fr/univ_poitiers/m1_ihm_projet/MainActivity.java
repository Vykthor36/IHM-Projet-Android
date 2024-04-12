package fr.univ_poitiers.m1_ihm_projet;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

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

        GameInformation gameInformation = new GameInformation();
        Intent intent;
        if (d == 0) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setDifficulty(getResources().getString(R.string.easyTextView));
            gameInformation.setWon(true);
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewEasy));
        } else if (d == 2) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setDifficulty(getResources().getString(R.string.normalTextView));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewHard));
        } else {
            intent = new Intent(this, CharacterActivity.class);
            gameInformation.setDifficulty(getResources().getString(R.string.difficultyTextView));
        }

        intent.putExtra(GameInformation.class.getName(), gameInformation);
        startActivity(intent);
    }

    public void showHistory(android.view.View v)
    {
        Intent intent = new Intent(this, HistoricActivity.class);
        startActivity(intent);
    }
}