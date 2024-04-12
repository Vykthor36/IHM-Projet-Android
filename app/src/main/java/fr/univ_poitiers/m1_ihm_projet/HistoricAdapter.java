package fr.univ_poitiers.m1_ihm_projet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.ViewHolder> {

    //Attributs
    private List<GameInformation> G;

    //Classe statique
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Attributs
        private final TextView textView;

        //Constructeur
        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textHistoricRecycler);
        }

        //Méthodes
        public TextView getTextView() { return textView; }
    }

    //Constructeur
    public HistoricAdapter(List<GameInformation> G) { this.G = G; }

    //Méthodes
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Création d'une nouvelle vue
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historic_layout, parent, false);

        return new ViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameInformation c = G.get(position);
        String text = c.getName() + " | " + c.getClassName() + " (" + c.getDifficulty() + ") | " + c.getPlaceOfDeath();
        ((ViewHolder) holder).getTextView().setText(text);
    }

    @Override
    public int getItemCount() { return G.size(); }

    public void addConversion(GameInformation g) { G.add(g); }
}