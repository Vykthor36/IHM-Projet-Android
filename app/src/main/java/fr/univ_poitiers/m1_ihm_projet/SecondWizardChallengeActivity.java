package fr.univ_poitiers.m1_ihm_projet;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Debug;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SecondWizardChallengeActivity extends AppCompatActivity {

    private SwitchCompat[][] switches;

    private int nbClick;

    private Button validateButton;

    private GameInformation gameInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_challenge_2);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());
        gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextWiz2)); // In case of loose
        gameInformation.setPlaceOfDeath(getResources().getString(R.string.placeOfDeathSecondChallenge));

        validateButton = findViewById(R.id.validateWizardChoice2);
        validateButton.setOnClickListener(view -> isWin());

        switches = new SwitchCompat[4][4];
        switches[0][0] = findViewById(R.id.switch00);
        switches[0][1] = findViewById(R.id.switch01);
        switches[0][2] = findViewById(R.id.switch02);
        switches[0][3] = findViewById(R.id.switch03);
        switches[1][0] = findViewById(R.id.switch10);
        switches[1][1] = findViewById(R.id.switch11);
        switches[1][2] = findViewById(R.id.switch12);
        switches[1][3] = findViewById(R.id.switch13);
        switches[2][0] = findViewById(R.id.switch20);
        switches[2][1] = findViewById(R.id.switch21);
        switches[2][2] = findViewById(R.id.switch22);
        switches[2][3] = findViewById(R.id.switch23);
        switches[3][0] = findViewById(R.id.switch30);
        switches[3][1] = findViewById(R.id.switch31);
        switches[3][2] = findViewById(R.id.switch32);
        switches[3][3] = findViewById(R.id.switch33);

        for(int i = 0; i< 4; i++) for(int j = 0; j< 4; j++) {
            int finalI = i;
            int finalJ = j;
            Logger.getAnonymousLogger().info("Index: "+i+j);
            switches[i][j].setOnClickListener(view ->
                    onSwicthChange(finalI, finalJ)
                );
        };

        nbClick = 0;
    }

    private void onSwicthChange(int si, int sj){
        Logger.getAnonymousLogger().info("switch: "+si+sj+"changed to: "+switches[si][sj].isChecked());
        nbClick++;

        for(int i = si-1; i<si+2; i++) for(int j = sj-1; j< sj+2; j++) {
            if(i>=0 && i<4 && j>=0 && j<4 && !(i==si && j==sj)) switches[i][j].setChecked(!switches[i][j].isChecked());
        }
    }

    private void isWin(){
        boolean won = true;

        for(int i = 0; i< 4; i++) for(int j = 0; j< 4; j++) won &= switches[i][j].isChecked();

        gameInformation.setWon(won);
        gameInformation.setPlaceOfDeath(getResources().getString(R.string.victory));

        Intent intent = new Intent(this, EndActivity.class);

        intent.putExtra(GameInformation.class.getName(), gameInformation);

        startActivity(intent);
    }
}
