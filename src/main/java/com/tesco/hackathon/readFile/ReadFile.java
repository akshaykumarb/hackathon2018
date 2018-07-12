package com.tesco.hackathon.readFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        List<String> IDList = new LinkedList<>();

        String path = "/Users/mishankchordia/Documents/Hackathon/Hello.txt";

        String line;

        FileReader fileReader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {

            String[] keyWords = line.split(" ");

            for (int i = 0; i < keyWords.length; i++) {

                IDList.add(keyWords[i]);

            }

        }

        for (String i : IDList) {
            System.out.println(i);
        }

    }

}
