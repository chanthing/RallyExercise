package org.chanthing.csvtool;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.csvtool.xform.*;


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
    private CSVFieldXform fieldXforms[];

    /*
     * Constructor for transform where all important attributes are specified in call.
     */
    public CSVXform(int numDestFields, CSVFieldXform fieldXforms[]) throws IllegalArgumentException {
	this.numDestFields = numDestFields;

	if (fieldXforms.length != numDestFields) {
	    throw new IllegalArgumentException("Must have a transform for each field.");
	}
	for (int i = 0; i < numDestFields; i++) {
	    if (fieldXforms[i] == null) {
		throw new IllegalArgumentException("Null transform passed to CSVXform().");
	    }
	}
	this.fieldXforms = fieldXforms;
    }
	    

    public List<String> xform(CSVRecord src) { 
	List<String> destRecord = new ArrayList(numDestFields);

	for (int i = 0; i < numDestFields; i++) {
	    destRecord.add(fieldXforms[i].xform(src));
	}
	return destRecord;
    }

    public int getNumDestFields() {
	return numDestFields;
    }

    public void setNumDestFields(int n) {
	numDestFields = n;
    }

}
