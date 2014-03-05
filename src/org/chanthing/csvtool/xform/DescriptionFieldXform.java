package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;

/**
 * Transform class for the manipulation of the Rally User Story "Name" field as specified in the
 * exercise.
 */
public class DescriptionFieldXform extends CSVFieldXform {

    /**
     *  Return the passed in string, truncated to 32k characters if necessary
     */
    public String xform(CSVRecord src) {
	    String descStr = src.get("Description");

        if (descStr.length() > 32766) {
	    descStr = descStr.substring(0,32766);
        } 
//	return '"' + descStr + '"';
	    return escapeFieldValue(descStr);
    }

}


