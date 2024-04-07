package fr.univ_poitiers.m1_ihm_projet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class CharacterActivity extends AppCompatActivity {

    private EditText nameEditText;
    private CalendarView ageCalendarView;
    private int choosedYear;
    private Button validateCharacterButton;
    private GameInformation gameInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());
        nameEditText = findViewById(R.id.nameEditText);
        validateCharacterButton = findViewById(R.id.validateAgeButton);
        ageCalendarView = findViewById(R.id.ageCalendarView);


        choosedYear = (int) (1970 + (ageCalendarView.getDate()/31536000000L));
        ageCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if(choosedYear != year){
                    choosedYear = year;
                }
            }
        });
    }

    public void validateCharacter(View v) {
        String characterName = nameEditText.getText().toString();

        Intent intent;
        if(choosedYear <= getResources().getInteger(R.integer.oldSageYear)) {
            intent = new Intent(this, EndActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.oldSageClassName));
        }
        else if(choosedYear <= getResources().getInteger(R.integer.warriorYear)) {
            intent = new Intent(this, FirstWarriorChallengeActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.warriorClassName));
        }
        else if(choosedYear <= getResources().getInteger(R.integer.wizardYear)) {
            intent = new Intent(this, FirstWizardChallengeActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.wizardClassName));
        }
        else {
            intent = new Intent(this, FirstWizardChallengeActivity.class);
            gameInformation.setClassName(getResources().getString(R.string.bigBabyClassName));
        }

        gameInformation.setDetails(gameInformation.getDetails() + gameInformation.getClassName());
        intent.putExtra(GameInformation.class.getName(), gameInformation);
        startActivity(intent);
    }


}