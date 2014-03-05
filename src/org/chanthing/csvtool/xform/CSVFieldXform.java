package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;


/**
 * Interface for transforming a field in a CSV record to a field in 
 * a record making up the contents of a CSV file in a new format.
 */

public abstract class CSVFieldXform {

    /**
     * Method to properly escape a field's value for inclusion in a CSV file
     * <p>
     * Currently incomplete. Only handles case of needing to add surrounding
     * quotes to a string containing spaces.
     *
     * @param inStr     the string to escape
     * @return          the "safe" version of the string
     */
    public static String escapeFieldValue(String inStr) {
	String rtnStr = null;

	rtnStr = handleContainingWhitespace(inStr);
	return rtnStr;
    }

    /**
     * Method to put quotes around a string when it contains relevant whitespace
     *
     * @param inStr     the string to quote
     * @return          the passed in string with necessary surrounding quotes
     */
    public static String handleContainingWhitespace(String inStr) {
	String trimmedStr = inStr.trim();
	String rtnStr = null;

	if (trimmedStr.indexOf(' ') != -1) {
	    rtnStr = '"' + trimmedStr + '"';
	} else {
	    rtnStr = inStr;
	}   
	return rtnStr;
    }   


    /**
	 *   Abstract method that is the heart of this class and must be implemented by
	 *   any concreted subclasses.
	 *
	 * @param    src   CSVRecord to be transformed
	 * @return         The transformed version of the field 
	 */
	 public abstract String xform(CSVRecord src); 

}
