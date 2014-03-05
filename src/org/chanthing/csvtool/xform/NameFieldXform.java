package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;

/*
 * Transform class for the manipulation of the Rally User Story "Name" field as specified in the
 * exercise.
 */
public class NameFieldXform extends CSVFieldXform {

    /*
     *  Return the passed in string, truncated to 256 characters if necessary
     */
    public String xform(CSVRecord src) {
	String nameStr = src.get("citation");
        if (nameStr.length() > 256) {
	    return nameStr.substring(0,256);
        } else {
	    return nameStr;
        }
    }

}


