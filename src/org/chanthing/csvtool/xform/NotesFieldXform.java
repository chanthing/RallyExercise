package org.chanthing.csvtool.xform;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.util.State;

/**
 * Transform class for the manipulation of the Rally User Story "Notes" field as specified in the
 * exercise.
 */
public class NotesFieldXform extends CSVFieldXform {

    /**
     *  Return a string consisting of a bulleted list with the make of the car, the state,
     * and the license number.
     * <p>
     *  Since we know that the field will contain embedded newlines, we return the value
     * surrounded by double quotes.
     */
    public String xform(CSVRecord src) {
	String notesStr = "\"\u2022 " + src.get("make") + "\n" +
	    "\u2022 " + State.valueOfAbbreviation(src.get("state")) + "\n" +
	    "\u2022 " + src.get("tag") + "\"";
	
	return notesStr;
    }

}


