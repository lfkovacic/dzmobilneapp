package com.example.dzmobilneapp;

import java.util.Random;

public class PitanjaGenerator {
    //Definiraj pitanja kao konstante
    //Za novo pitanje samo dodaj KvizPitanje na kraj PITANJA array-a
    private static final KvizPitanje[] PITANJA = {
            new KvizPitanje(0, "Planeta Saturn ima prsten.", "Točno: Planeta Saturn poznata je po svojim prstenovima.", true),
            new KvizPitanje(1, "Zemlja se okreće oko Sunca.", "Točno: Zemlja se kreće oko Sunca u svojoj putanji.", true),
            new KvizPitanje(2, "Voda ključa na temperaturi od 100°C.", "Točno: Voda ključa na 100°C na standardnom tlaku.", true),
            new KvizPitanje(3, "Mjesec nema vlastitu svjetlost.", "Točno: Mjesec svijetli zahvaljujući Sunčevom svjetlu.", true),
            new KvizPitanje(4, "Banana je crvena.", "Netočno: Banane su obično žute.", false),
            new KvizPitanje(5, "Australija je najveći otok na svijetu.", "Netočno: Australija je kontinent, ne otok.", false),
            new KvizPitanje(6, "Svemir je ravan.", "Točno: Geometrija svemira je eksperimentalno potvrđena kao ravna na velikim skalama.", true),
            new KvizPitanje(7, "Sunce je planet.", "Netočno: Sunce je zvijezda, ne planet.", false),
            new KvizPitanje(8, "Lisica je ptica.", "Netočno: Lisica je sisavac.", false),
            new KvizPitanje(9, "Pluton je planet u Sunčevom sustavu.", "Netočno: Pluton više nije klasificiran kao planet.", false),
            new KvizPitanje(10, "Koale su mesožderi.", "Netočno: Koale su biljojedi.", false),
            new KvizPitanje(11, "Barcelona je glavni grad Španjolske.", "Netočno: Glavni grad Španjolske je Madrid.", false),
            new KvizPitanje(12, "Piramide u Egiptu su grobnice.", "Točno: Piramide su grobnice faraona.", true),
            new KvizPitanje(13, "Mars je crveni planet.", "Točno: Mars je poznat po crvenoj površini.", true),
            new KvizPitanje(14, "Nil je najduža rijeka na svijetu.", "Točno: Nil je najduža rijeka na svijetu.", true),
            new KvizPitanje(15, "Svijet se ne okreće oko svoje osi.", "Netočno: Svijet se okreće oko svoje osi.", false),
            new KvizPitanje(16, "Puma je vrsta ptice.", "Netočno: Puma je sisavac.", false),
            new KvizPitanje(17, "Svemir se širi.", "Točno: Znanstveni dokazi ukazuju na širenje svemira.", true),
            new KvizPitanje(18, "Ljubav je kemija mozga.", "Točno: Kemija mozga ima ulogu u zaljubljenosti.", true),
            new KvizPitanje(19, "Planina Everest je najviša na svijetu.", "Točno: Planina Everest je najviša planina na svijetu, visine 8.849m.", true),
            new KvizPitanje(20, "Srednji vijek je doba viteza.", "Točno: Srednji vijek je poznat po vitezovima i viteškim turnirima.", true),
            new KvizPitanje(21, "Slonovi mogu letjeti.", "Netočno: Slonovi ne mogu letjeti.", false),
            new KvizPitanje(22, "More se sastoji od slatke vode.", "Netočno: More sadrži slanu vodu.", false),
            new KvizPitanje(23, "Amerika je kontinent.", "Točno: Amerika je kontinent koji se sastoji od Sjeverne i Južne Amerike.", true),
            new KvizPitanje(24, "Antarktika je naseljiva.", "Netočno: Antarktika nema stalno naseljenih ljudi.", false)
    };

    public static KvizPitanje getRandomPitanje(){
        //Dohvati nasumično pitanje iz PITANJA array-a uz pomoć java.util.Random
        Random random = new Random();
        int randomId = random.nextInt(PITANJA.length);
        return PITANJA[randomId];
    }
}
