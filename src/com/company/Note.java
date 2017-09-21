package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by spencer on 9/18/17.
 */
public class Note {
    private String uniqueID;
    private String text;
    private String name;
    ArrayList<String> referenceIdentifiers = new ArrayList<String>();
    ArrayList<String> mentions = new ArrayList<String>();
    ArrayList<String> topics = new ArrayList<String>();

    Note(String name1, String text1) {
        name = name1;
        text = text1;
    }

    void setUniqueID (String id){
        uniqueID = id;
    }

    void setText(String text1){
        text = text1;
    }

    void addReferenceID(String id) {
        referenceIdentifiers.add(id);
    }

    void addMention(String mention) {
        mentions.add(mention);
    }

    void addTopic(String topic) {
        topics.add(topic);
    }

    String getName() {
        return name;
    }

    boolean hasUniqueID() {
        if (uniqueID != null) {
            return true;
        }
        else {
            return false;
        }
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
