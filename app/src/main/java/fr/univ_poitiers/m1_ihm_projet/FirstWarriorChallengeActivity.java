package fr.univ_poitiers.m1_ihm_projet;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstWarriorChallengeActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior_challenge_1);

        videoView = findViewById(R.id.warriorVideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.warriorchallenge1question);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
