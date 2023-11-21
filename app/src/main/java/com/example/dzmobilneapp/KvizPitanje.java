package com.example.dzmobilneapp;

public class KvizPitanje {
    //Klasa za pitanja koja koristi aplikacija
    private int id; //Numerični id primarno za debugging - trenutno se ne koristi
    private String textPitanje; //Tekstualno pitanje
    private String textOdgovor; //Kratki teksutalni opis odgovora
    private boolean isTrue; // true/false vrijednost odgovora na pitanje
    private boolean isAnswered; // je li pitanje već odgovoreno

    public KvizPitanje(int id, String textPitanje, String textOdgovor, boolean isTrue){
        this.id = id;
        this.textPitanje = textPitanje;
        this.textOdgovor = textOdgovor;
        this.isTrue = isTrue;
        this.isAnswered = false;
    }

    public void setAnswered(boolean isAnswered){
        this.isAnswered = isAnswered;
    }
    public boolean getAnswered(){
        return this.isAnswered;
    }
    public int getId(){
        return id;
    }
    public String getTextPitanje(){
        return textPitanje;
    }
    public String getTextOdgovor(){
        return textOdgovor;
    }
    public boolean getTrue() {
        return isTrue;
    }
}
