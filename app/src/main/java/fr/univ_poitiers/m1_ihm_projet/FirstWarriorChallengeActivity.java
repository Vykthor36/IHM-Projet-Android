package fr.univ_poitiers.m1_ihm_projet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstWarriorChallengeActivity extends AppCompatActivity {
    private VideoView videoView;
    private RadioGroup radioGroup;
    private Button validateButton;
    private GameInformation gameInformation;
    private String pathAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior_challenge_1);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());

        validateButton = findViewById(R.id.validateButton);
        videoView = findViewById(R.id.videoView);
        radioGroup = findViewById(R.id.answersRadioGroup);

        String pathQuestion = "android.resource://" + getPackageName() + "/" + R.raw.warriorchallenge1question;
        pathAnswer = "android.resource://" + getPackageName() + "/" + R.raw.warriorchallenge1answer;

        videoView.setVideoURI(Uri.parse(pathQuestion));
        videoView.start();

        validateButton.setOnClickListener(l -> validateAnswer(validateButton));
    }

    public void validateAnswer(android.view.View v)
    {
        if(radioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, R.string.noAnswerMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        radioGroup.setVisibility(View.INVISIBLE);
        findViewById(R.id.validateButton).setVisibility(View.GONE);

        Intent intent;
        gameInformation.setWarrior1Choice(radioGroup.getCheckedRadioButtonId() == findViewById(R.id.B).getId());
        if(gameInformation.isWarrior1Choice()) intent = new Intent(this, SecondWarriorChallengeActivity.class);
        else intent = new Intent(this, EndActivity.class);

        videoView.setVideoURI(Uri.parse(pathAnswer));
        videoView.start();

        intent.putExtra(GameInformation.class.getName(), gameInformation);

        videoView.setOnCompletionListener(l -> startActivity(intent));

    }
}
