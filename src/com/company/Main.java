package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        //K so start with getting a regex or file reader
        //read in .txt file to a string

        Note test = new Note();

        String path = "/Users/spencer/Desktop/Untitled.txt";

        Scanner scanner = new Scanner(new File(path));
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();

        test.setText(text);
        //System.out.println(test.getText());

        Pattern reg = Pattern.compile("[!@#^][A-z]+");
        Matcher matcher = reg.matcher(text);

        bamfRegex(test, matcher, reg);

        System.out.println(test.getUniqueID());
        System.out.println(test.getReferences().get(0));
    }

    public static void bamfRegex(Note note, Matcher matcher, Pattern pattern) {
        matcher = pattern.matcher(note.getText());

        while (matcher.find()) {
            String sub = matcher.group();

            if (Character.toLowerCase(sub.charAt(0)) == '!') {
                note.setUniqueID(matcher.group());
            }

            else if(Character.toLowerCase(sub.charAt(0)) == '^') {
                note.addReferenceID(sub);
            }

            else if(Character.toLowerCase(sub.charAt(0)) == '#') {
                return;
            }

            else if(Character.toLowerCase(sub.charAt(0)) == '@') {
                return;
            }
        }





    }





}
