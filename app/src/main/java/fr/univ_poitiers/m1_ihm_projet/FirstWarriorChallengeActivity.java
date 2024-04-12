package fr.univ_poitiers.m1_ihm_projet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstWarriorChallengeActivity extends AppCompatActivity {
    private VideoView videoView;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior_challenge_1);

        videoView = findViewById(R.id.warriorVideoView);
        radioGroup = findViewById(R.id.answersRadioGroup);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.warriorchallenge1question;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

    public void validateAnswer(android.view.View v)
    {
        Intent intent;
        if (radioGroup.getCheckedRadioButtonId() == 0)
        {
            //TODO
        }
        else
        {
            //TODO
        }
    }
}
