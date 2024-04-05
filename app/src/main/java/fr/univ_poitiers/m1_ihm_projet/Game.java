package fr.univ_poitiers.m1_ihm_projet;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Game implements Parcelable {

    // Attributes
    private boolean isWon;
    private String placeOfDeath;
    private String difficulty;
    private int rating;
    private String name;
    private Date birthdate;
    private String details;

    // Constructors
    public Game() {}

    protected Game(Parcel in) {
        isWon = in.readByte() != 0;
        placeOfDeath = in.readString();
        difficulty = in.readString();
        rating = in.readInt();
        name = in.readString();
        details = in.readString();
    }

    // Interfaces
    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    // Methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (isWon ? 1 : 0));
        parcel.writeString(placeOfDeath);
        parcel.writeString(difficulty);
        parcel.writeInt(rating);
        parcel.writeString(name);
        parcel.writeString(details);
    }
}
