package fr.univ_poitiers.m1_ihm_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class CharacterActivity extends AppCompatActivity {

    private EditText nameEditText;
    private DatePicker ageCalendarView;
    private GameInformation gameInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());
        nameEditText = findViewById(R.id.nameEditText);
        ageCalendarView = findViewById(R.id.ageCalendarView);
    }

    public void validateCharacter(View v) {
        String characterName = nameEditText.getText().toString();
        int choosedYear = ageCalendarView.getYear();

        Intent intent;
        if (choosedYear <= getResources().getInteger(R.integer.oldSageYear)) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.oldSageClassName));
            gameInformation.setPlaceOfDeath(getResources().getString(R.string.placeOfDeathCharacter));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewOld));
        }
        else if (choosedYear <= getResources().getInteger(R.integer.warriorYear)) {
            intent = new Intent(this, FirstWarriorChallengeActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.warriorClassName));
        }
        else if (choosedYear <= getResources().getInteger(R.integer.wizardYear)) {
            intent = new Intent(this, FirstWizardChallengeActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.wizardClassName));
        }
        else {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.bigBabyClassName));
            gameInformation.setPlaceOfDeath(getResources().getString(R.string.placeOfDeathCharacter));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextViewBaby));
        }

        gameInformation.setName(characterName);
        intent.putExtra(GameInformation.class.getName(), gameInformation);
        startActivity(intent);
    }
}