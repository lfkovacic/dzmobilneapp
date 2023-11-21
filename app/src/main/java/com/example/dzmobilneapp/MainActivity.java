package com.example.dzmobilneapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static final int DELAY_IN_MS = 2000;
    private TextView textPitanje;
    private TextView textOdgovor;
    private TextView textBodovi;
    private Button buttonTocno;
    private Button buttonNetocno;
    private ImageButton buttonSljedece;
    private ImageButton buttonPrethodno;
    private List<KvizPitanje> pitanjaArray;
    private int currentPitanjeIndex;
    private KvizPitanje currentPitanje;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pitanjaArray = PitanjaGenerator.getShuffledPitanjaArray();
        currentPitanjeIndex = 0;

        //Veži id-jeve

        textPitanje = findViewById(R.id.textPitanje);
        textOdgovor = findViewById(R.id.textOdgovor);
        textBodovi = findViewById(R.id.textBodovi);
        buttonTocno = findViewById(R.id.buttonTocno);
        buttonNetocno = findViewById(R.id.buttonNetocno);
        buttonPrethodno = findViewById(R.id.buttonPrethodno);
        buttonSljedece = findViewById(R.id.buttonSljedece);

        //Inicijalno postavi bodove na 0 i prikaži bodove

        score = 0;
        updateBodovi();

        //Veži event listenere na gumbe

        buttonPrethodno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getPreviousPitanje();
            }
        });
        buttonSljedece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNextPitanje();
            }
        });

        buttonTocno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true); //Korisnik je odabrao "točno"
                updateTextOdgovor();
                updateBodovi();
                delayAndGetNextPitanje(DELAY_IN_MS);
            }
        });
        buttonNetocno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false); //Korisnik je odabrao "netočno"
                updateTextOdgovor();
                updateBodovi();
                delayAndGetNextPitanje(DELAY_IN_MS);
            }
        });
        getNextPitanje();
    }

    protected void getNextPitanje(){ //Dohvaća sljedeće pitanje, briše prethodni odgovor
        int numPitanja = pitanjaArray.size();
        currentPitanjeIndex = ++currentPitanjeIndex%numPitanja;
        currentPitanje = pitanjaArray.get(currentPitanjeIndex);
        clearTextOdgovor();
        updateTextPitanje();
    }
    protected void getPreviousPitanje() {
        int numPitanja = pitanjaArray.size();
        currentPitanjeIndex = (--currentPitanjeIndex+numPitanja)%numPitanja;
        currentPitanje = pitanjaArray.get(currentPitanjeIndex); //Java misli da je -1%25 = -1...
        clearTextOdgovor();
        updateTextPitanje();
    }
    protected void updateTextPitanje(){ //Dohvaća tekst pitanja
        textPitanje.setText(currentPitanje.getTextPitanje());
    }
    protected void updateTextOdgovor(){ //Dohvaća tekst odgovora
        textOdgovor.setText(currentPitanje.getTextOdgovor());
    }
    protected void clearTextOdgovor(){ //Briše tekst odgovora
        textOdgovor.setText("");
    }

    protected void updateBodovi(){ //Prikazuje broj bodova
        textBodovi.setText("Bodovi: "+score);
    }
    protected void checkAnswer(boolean answer){ //Provjerava je li korisnikov odgovor točan i ažurira broj bodova
        if (!currentPitanje.getAnswered()){
            if (answer == currentPitanje.getTrue()) score++;
            currentPitanje.setAnswered(true);
        }
    }
    private void delayAndGetNextPitanje(int delayMillis) { //Nakon određene stanke dohvaća sljedeće pitanje
        //Onemogući korisnikov unos
        buttonTocno.setEnabled(false);
        buttonNetocno.setEnabled(false);

        //Radi novi handler za Runnable akciju koja se izvršava nakon određene stanke

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Ponovno omogući korisnikov unos
                buttonTocno.setEnabled(true);
                buttonNetocno.setEnabled(true);

                //Dohvati sljedeće pitanje
                getNextPitanje();
            }
        }, delayMillis);
    }
}