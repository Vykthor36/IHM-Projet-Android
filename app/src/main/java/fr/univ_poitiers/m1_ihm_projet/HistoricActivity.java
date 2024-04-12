package fr.univ_poitiers.m1_ihm_projet;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoricActivity extends AppCompatActivity {

    // Attributes
    private RecyclerView recyclerViewHistoric;
    private HistoricAdapter historicAdapter;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        recyclerViewHistoric = findViewById(R.id.recyclerViewHistoric);

        //Création de l'historique de conversion
        recyclerViewHistoric.setLayoutManager(new LinearLayoutManager((this)));
        List<GameInformation> G = new ArrayList<>();
        historicAdapter = new HistoricAdapter(G);
        recyclerViewHistoric.setAdapter(historicAdapter);
    }
}