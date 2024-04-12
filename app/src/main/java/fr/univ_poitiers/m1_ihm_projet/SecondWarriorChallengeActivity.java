package fr.univ_poitiers.m1_ihm_projet;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SecondWarriorChallengeActivity extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {

    TextView word,word1,word2,word3,word4,word5;

    ImageView imageBin, imageWarrior;

    TextView dragged;

    List<TextView> goodForWarrior;

    private GameInformation gameInformation;

    int nbWordRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warrior_challenge_2);

        gameInformation = getIntent().getParcelableExtra(GameInformation.class.getName());

        word = findViewById(R.id.wordTV);
        word1 = findViewById(R.id.wordTV1);
        word2 = findViewById(R.id.wordTV2);
        word3 = findViewById(R.id.wordTV3);
        word4 = findViewById(R.id.wordTV4);
        word5 = findViewById(R.id.wordTV5);
        imageBin = findViewById(R.id.binImage);
        imageWarrior = findViewById(R.id.warriorImage);

        dragged = null;

        word.setOnLongClickListener(this);
        word1.setOnLongClickListener(this);
        word2.setOnLongClickListener(this);
        word3.setOnLongClickListener(this);
        word4.setOnLongClickListener(this);
        word5.setOnLongClickListener(this);

        imageWarrior.setOnDragListener(this);
        imageBin.setOnDragListener(this);

        goodForWarrior = Arrays.asList(word, word3, word5);
        nbWordRight = 0;
    }

    @Override
    public boolean onLongClick(View v) {
        dragged = (TextView) v;

//        ClipData.Item item = new ClipData.Item((CharSequence) "Drag");
//        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
//        ClipData data = new ClipData("drag", mimeTypes, item);

        v.invalidate();

        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);

        v.startDragAndDrop(null        // data to be dragged
                , dragshadow   // drag shadow builder
                , v           // local data about the drag and drop operation
                , 0          // flags (not currently used, set to 0)
        );
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:

            case DragEvent.ACTION_DRAG_ENTERED:

            case DragEvent.ACTION_DRAG_LOCATION:

            case DragEvent.ACTION_DRAG_EXITED:

            case DragEvent.ACTION_DRAG_ENDED:
                return true;

            case DragEvent.ACTION_DROP:

                ImageView imageView = (ImageView) v;
                if(imageView.equals(imageWarrior) && goodForWarrior.contains(dragged) || !imageView.equals(imageWarrior) && !goodForWarrior.contains(dragged)){
                    nbWordRight++;
                    dragged.setVisibility(View.INVISIBLE);
                    Toast.makeText(this, R.string.yummy, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, R.string.gross, Toast.LENGTH_SHORT).show();
                    end(false);
                }

                if(nbWordRight >= 6) end(true);

                return true;

            default:
                break;
        }
        return false;
    }


    private void end(boolean win){

        Intent intent;
        intent = new Intent(this, EndActivity.class);

        gameInformation.setWon(win);
        gameInformation.setPlaceOfDeath(getResources().getString(R.string.victory));
        intent.putExtra(GameInformation.class.getName(), gameInformation);

        startActivity(intent);
    }
}
