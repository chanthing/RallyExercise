package org.chanthing.csvtool.xform;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.util.State;

/**
 * Transform class for the manipulation of the Rally User Story "licenseExpiration" field as 
 * specified in the exercise.
 */
public class LicenseExpirationXform extends CSVFieldXform {

    private static String getLastDayInMonth(String month, String year) {
	return "28";
    }

    /**
     *  Return a string of form mm/dd/yyyy with the license expiration date from the passed in record
     * and the license number.
     * <p>
     * Needs to be fixed to output the actual last day of the month in question.
     */
    public String xform(CSVRecord src) {
	String   month = src.get("expmm");
	String   year = "20" + src.get("expyy");
	String   day = getLastDayInMonth(month, year);
	return month + "/" + day + "/" + year;
    }

}


