package fr.univ_poitiers.m1_ihm_projet;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;

public class FirstWizardChallengeActivity extends AppCompatActivity {
    private WebView webView;

    private long time;
    private CheckBox buttonA, buttonB, buttonC, buttonD;

    private Button validateButton;

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

        validateButton = findViewById(R.id.validateWizardChoice2);
        validateButton.setOnClickListener(view -> validateWizardChoice1());

        webView = findViewById(R.id.wizardWebView);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest webResourceRequest){
                return false;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.canGoForward();
        webView.loadUrl("https://www.google.fr/");

    }

    private void validateWizardChoice1(){
        Intent intent;
        if(buttonA.isChecked() && !buttonB.isChecked() && buttonC.isChecked() && !buttonD.isChecked()){ // Bon choix (A&D)
            intent = new Intent(this, SecondWizardChallengeActivity.class);
        }
        else { // Mauvais choix
            intent = new Intent(this, EndActivity.class);
        }
        gameInformation.setTime(time - Instant.now().toEpochMilli());

        intent.putExtra(GameInformation.class.getName(), gameInformation);
        startActivity(intent);
    }
}
