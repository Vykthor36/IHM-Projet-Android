package fr.univ_poitiers.m1_ihm_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
        HistoricActivity.createAdapter();
        Button quitButton = findViewById(R.id.buttonQuit);

        quitButton.setOnClickListener(l -> {
            finishAffinity();
            System.exit(0);
        });
    }

    public void startNewGame(android.view.View v) {
        int d = difficultySeekBar.getProgress();

        GameInformation gameInformation = new GameInformation();
        Intent intent;
        if (d == 0) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setName(getResources().getString(R.string.unknownCharacterName));
            gameInformation.setClassName(getResources().getString(R.string.unknownClassName));
            gameInformation.setDifficulty(getResources().getString(R.string.easyTextView));
            gameInformation.setWon(true);
            gameInformation.setPlaceOfDeath(getResources().getString(R.string.victory));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewEasy));
        } else if (d == 2) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setName(getResources().getString(R.string.unknownCharacterName));
            gameInformation.setClassName(getResources().getString(R.string.unknownClassName));
            gameInformation.setDifficulty(getResources().getString(R.string.difficultTextView));
            gameInformation.setPlaceOfDeath(getResources().getString(R.string.placeOfDeathMenu));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewHard));
        } else {
            intent = new Intent(this, CharacterActivity.class);
            gameInformation.setDifficulty(getResources().getString(R.string.normalTextView));
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