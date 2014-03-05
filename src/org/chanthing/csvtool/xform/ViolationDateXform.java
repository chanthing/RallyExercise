package org.chanthing.csvtool.xform;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.util.State;

/**
 * Transform class for the manipulation of the Rally User Story "violationDate" field as specified in the
 * exercise.
 */
public class ViolationDateXform extends CSVFieldXform {

    /**
     *  Return a string of form mm/dd/yyyy with the violation date from the passed in record
     * and the license number.
     */
    public String xform(CSVRecord src) {
	return src.get("violDate").substring(0,10);
    }

}


