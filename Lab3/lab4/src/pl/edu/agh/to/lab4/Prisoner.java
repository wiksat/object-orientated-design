package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;
    private final int sentenceDuration;
    private final String pesel;
    public Prisoner(String name, String surname,int age, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname, age);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    public boolean canBeAccused() {
        return !IsJailedNow();
    }

    public boolean IsJailedNow() {
        return judgementYear + sentenceDuration >= getCurrentYear();
    }


    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
