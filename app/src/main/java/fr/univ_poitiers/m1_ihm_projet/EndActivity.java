package fr.univ_poitiers.m1_ihm_projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    // Attributes
    private String details;
    private ConstraintLayout endConstraintLayout;
    private TextView gameResultTextView;
    private TextView gameDetailsTextView;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        endConstraintLayout = findViewById(R.id.endConstraintLayout);
        gameResultTextView = findViewById(R.id.gameResultTextView);
        gameDetailsTextView = findViewById(R.id.gameDetailsTextView);

        Intent i = getIntent();
        boolean isWon = i.getBooleanExtra("isWon", false);
        if (isWon) gameWon();
        else gameLost();

        details = i.getStringExtra("details");
        gameDetailsTextView.setText(details);
    }

    private void gameWon() {
        endConstraintLayout.setBackgroundColor(Color.rgb(24, 151, 34));
        gameResultTextView.setTextColor(Color.rgb(38, 50, 56));
        gameDetailsTextView.setTextColor(Color.rgb(38, 50, 56));

        gameResultTextView.setText("YOU WON!");
    }

    private void gameLost() {
        endConstraintLayout.setBackgroundColor(Color.rgb(195, 19, 19));
        gameResultTextView.setTextColor(Color.rgb(0, 0, 0));
        gameDetailsTextView.setTextColor(Color.rgb(0, 0, 0));

        gameResultTextView.setText("YOU LOST!");
    }
}