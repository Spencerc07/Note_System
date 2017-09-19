package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by spencer on 9/18/17.
 */
public class Note {
    private String uniqueID;
    private String text;
    ArrayList<String> referenceIdentifiers = new ArrayList<String>();


    void setUniqueID (String id){
        uniqueID = id;
    }

    void setText(String text1){
        text = text1;
    }

    void addReferenceID(String id) {
        referenceIdentifiers.add(id);
    }

    String getText() {
        return text;
    }

    String getUniqueID() {
        return uniqueID;
    }

    ArrayList getReferences() {
        return referenceIdentifiers;
    }
}
