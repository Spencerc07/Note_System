package com.company;

import sun.nio.cs.US_ASCII;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by spencer on 9/18/17.
 */
public class testing {
    public static void main(String[] args) throws IOException {

        String path = "/Users/spencer/Desktop/Notes";

        Scanner scanner = new Scanner( new File(path));
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();

        System.out.println(text);


        /*
        for(int j = 0; j < noteList.size(); j++) {
            System.out.println(noteList.get(j).getText());
        }
        */

        //read in a file
                /*
        Matcher uniqueMatch = reg.matcher("!valid ! notvalid !3notvalid !thisoneis121_");
        while (uniqueMatch.find()) {
            System.out.println(uniqueMatch.group());
            System.out.print("Start index: " + uniqueMatch.start());
            System.out.print(" End index: " + uniqueMatch.end() + " ");
            System.out.println(uniqueMatch.group());
        }

         Scanner scanner = new Scanner(new File(path));
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        test.setText(text);
        //System.out.println(test.getText());



        System.out.println(test.getUniqueID());
        System.out.println(test.getReferences().get(0));
        System.out.println(test.getReferences().get(1));
        */


    }




}