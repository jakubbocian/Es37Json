package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

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
    }


}