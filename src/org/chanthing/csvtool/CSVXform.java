package org.chanthing.csvtool;

import org.apache.commons.csv.CSVRecord;


/*
 * Class that represents information on how to transform a record in a CSV file to a record in 
 * another CSV file format.
 *
 * It records information, such as the field header and field index for each transformed field, as
 * well as transformations that, given the source field value, returns the proper destination field
 * value (both Strings).
 * 
 * By convention, values relevant to the initial record are identified as src (source), values 
 * relevant to the transformed record are identified as dest (destination).
 */

public class CSVXform {

    private int numDestFields;
    private String destHeaderStrings[];
    private CSVFieldXform fieldXforms[];

    /*
     * Constructor for transform where all important attributes are specified in call.
     */
    public CSVXform(int numDestFields, String destHeaderStrings[], CSVFieldXform fieldXforms[]) throws IllegalArgumentException {
	this.numDestFields = numDestFields;

	if (destHeaderStrings.length != numDestFields) {
	    throw new IllegalArgumentException("Must have a header string for each field.");
	}
	this.destHeaderStrings = destHeaderStrings;
	if (fieldXforms.length != numDestFields) {
	    throw new IllegalArgumentException("Must have a transform for each field.");
	}
	this.fieldXforms = fieldXforms;
    }
	    

    public String[] xform(CSVRecord src) { 
	String destRecord[] = new String[numDestFields];

	for (int i = 0; i < numDestFields; i++) {
	    destRecord[i] = fieldXforms[i].xform(src.get(i));
	}
	return destRecord;
    }

    public String[] getDestHeaders() {
	return destHeaderStrings;
    }

    public int getNumDestFields() {
	return numDestFields;
    }

    public void setNumDestFields(int n) {
	numDestFields = n;
    }

}
