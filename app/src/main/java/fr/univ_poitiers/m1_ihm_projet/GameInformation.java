package fr.univ_poitiers.m1_ihm_projet;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class GameInformation implements Parcelable {

    // Attributes
    private boolean isWon;
    private String placeOfDeath;
    private String difficulty;

    private String className;
    private int rating;
    private String name;
    private Date birthdate;
    private String details;
    private boolean warrior1Choice;

    private long time;

    // Constructors
    public GameInformation() {
        isWon = false;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) { this.className = className; }

    public boolean isWarrior1Choice() {
        return warrior1Choice;
    }

    public void setWarrior1Choice(boolean warrior1Choice) {
        this.warrior1Choice = warrior1Choice;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isWon() {
        return isWon;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getClassName() {
        return className;
    }

    public int getRating() {
        return rating;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getDetails() {
        return details;
    }

    protected GameInformation(Parcel in) {
        isWon = in.readByte() != 0;
        placeOfDeath = in.readString();
        difficulty = in.readString();
        rating = in.readInt();
        name = in.readString();
        details = in.readString();
    }

    // Interfaces
    public static final Creator<GameInformation> CREATOR = new Creator<GameInformation>() {
        @Override
        public GameInformation createFromParcel(Parcel in) {
            return new GameInformation(in);
        }

        @Override
        public GameInformation[] newArray(int size) {
            return new GameInformation[size];
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
