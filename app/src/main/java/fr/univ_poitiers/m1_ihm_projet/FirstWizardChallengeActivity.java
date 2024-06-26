package fr.univ_poitiers.m1_ihm_projet;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;

public class FirstWizardChallengeActivity extends AppCompatActivity {

    private long time;
    private CheckBox buttonA, buttonB, buttonC, buttonD;

    private GameInformation gameInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_challenge_1);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());

        time = Instant.now().toEpochMilli();

        buttonA = findViewById(R.id.checkBoxA);
        buttonB = findViewById(R.id.checkBoxB);
        buttonC = findViewById(R.id.checkBoxC);
        buttonD = findViewById(R.id.checkBoxD);

        Button validateButton = findViewById(R.id.validateWizardChoice2);
        validateButton.setOnClickListener(view -> validateWizardChoice1());

        WebView webView = findViewById(R.id.wizardWebView);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest webResourceRequest){
                return false;
            }
        });

        webView.canGoForward();
        webView.loadUrl("https://www.google.fr/");
    }

    private void validateWizardChoice1(){
        if(!buttonA.isChecked() && !buttonB.isChecked() && !buttonC.isChecked() && !buttonD.isChecked()){
            Toast.makeText(this, R.string.noAnswerMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent;
        if(buttonA.isChecked() && !buttonB.isChecked() && buttonC.isChecked() && !buttonD.isChecked()){ // Bon choix (A&D)
            intent = new Intent(this, SecondWizardChallengeActivity.class);
        }
        else { // Mauvais choix
            intent = new Intent(this, EndActivity.class);
            gameInformation.setPlaceOfDeath(getResources().getString(R.string.placeOfDeathFirstChallenge));
            gameInformation.setDetails(getResources().getString(R.string.gameDetailsTextWiz1));
        }

        gameInformation.setTime(time - Instant.now().toEpochMilli());

        intent.putExtra(GameInformation.class.getName(), gameInformation);
        startActivity(intent);
    }
}
