package org.chanthing.csvtool.xform;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.util.State;

/**
 * Transform class for the manipulation of the Rally User Story "Plan Estimate" field as 
 * specified in the exercise.
 */
public class PlanEstimateXform extends CSVFieldXform {

    /**
     *  Return a string with the jjj
     * and the license number.
     * <p>
     * Needs to be fixed to output the actual last day of the month in question.
     */
    public String xform(CSVRecord src) {
	String   fine = src.get("violFine");
	String   decFine = fine.substring(1);
	
	return decFine.substring(0,decFine.length() - 3);
    }

}


