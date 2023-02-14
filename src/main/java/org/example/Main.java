package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String readFromFile(String path) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        return new String(content);
    }

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String json = readFromFile("src/main/resources/analisi.json");
        String json2 = readFromFile("src/main/resources/esami.json");
        Analisi[] analisi = gson.fromJson(json, Analisi[].class);
        EsameRegistrato[] esame = gson.fromJson(json2, EsameRegistrato[].class);

        HashMap<String, EsameRegistrato> esami = new HashMap<>();

        for(EsameRegistrato e : esame){
            esami.put(e.nome, e);
        }

        for(Analisi a : analisi){
            for(Esame e : a.esami){
                if(esami.containsKey(e.nomeAnalisi)){
                    if(esami.get(e.nomeAnalisi).giorniDopoPrelievo < TimeUnit.DAYS.convert(Math.abs(a.dataOraPrelievo.getTime() - e.dataOraAnalisi.getTime()), TimeUnit.MILLISECONDS)){
                        System.out.println("esame " + e.nomeAnalisi + " eseguito dopo il termine massimo di validità");
                    }
                    for(String s : e.matricolaStrumenti){
                        if(!esami.get(e.nomeAnalisi).strumenti.contains(s)){
                            System.out.println("Esame " + e.nomeAnalisi + " eseguito con uno strumento non valido");
                        }
                    }
                    for(Strumenti s: esami.get(e.nomeAnalisi).strumenti){
                        boolean check = true;
                        for(String op: s.operatoriAbilitati){
                            if(!op.equals(e.codiceOperatore)){
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            System.out.println("Strumento " + s.matricola + " usato da un operatore non abilitato");
                        }
                    }
                }else{
                    System.out.println("Esame " + e.nomeAnalisi + " non registrato");
                }
            }
        }
    }


}