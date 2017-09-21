package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    /*
    TODO - Add error detection to user file path. (Complete)

     */

    public static void main(String[] args) throws IOException {

        //Get user supplied filepath for folder of .txt
        System.out.println("Enter filepath of folder.");
        Scanner sc = new Scanner(System. in);
        String input = sc. nextLine();

        while (!new File(input).exists()) {
            System.out.println("File not found, please re-enter directory path, or type 'quit' to exit the program");
            input = sc. nextLine();
            if(input.equals("quit")) {
                System.exit(0);
            }
        }
        sc.close();

        HashMap<String, Note> uniqueIdHash = new HashMap<>();

        ArrayList<Note> noteList = new ArrayList<>();

        File folder = new File(input);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().toLowerCase().endsWith(".txt")) {
                Scanner scanner = new Scanner(listOfFiles[i]);
                String text = scanner.useDelimiter("\\A").next();
                scanner.close();
                noteList.add(new Note(listOfFiles[i].getName(), text));
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        Pattern reg = Pattern.compile("[!@#^][A-z]+");
        Matcher matcher;
        for (int j = 0; j < noteList.size(); j++) {
            matcher = reg.matcher(noteList.get(j).getText());
            bamfRegex(noteList.get(j), matcher, reg, uniqueIdHash);
        }




        for (int y = 0; y < noteList.size(); y++) {
            System.out.println(noteList.get(y).getName());
            System.out.println(noteList.get(y).getUniqueID());
            System.out.println(noteList.get(y).getReferences().size());
            System.out.println(noteList.get(y).getText());
            System.out.println();
        }


        //System.out.println(uniqueIdHash.keySet());
        /*
        for (int x = 0; x < noteList.size(); x++) {
            System.out.println(noteList.get(x).getUniqueID());
        }
        */

    }

    public static void bamfRegex(Note note, Matcher matcher, Pattern pattern, HashMap<String, Note> hashMap) {
        matcher = pattern.matcher(note.getText());
        String sub;
        char first;
        while (matcher.find()) {
            sub = matcher.group();
            //System.out.println(sub);

            first = Character.toLowerCase(sub.charAt(0));

            if (first == '!') {

                if (!note.hasUniqueID()) {
                    if (!hashMap.containsKey(sub)) {
                        note.setUniqueID(sub);
                        hashMap.put(sub, note);
                    }
                }
            }

            else if(first == '^') {
                note.addReferenceID(sub);
            }

            else if(first == '#') {
                note.addTopic(sub);
            }

            else if(first == '@') {
                note.addMention(sub);
            }
        }
    }
}
