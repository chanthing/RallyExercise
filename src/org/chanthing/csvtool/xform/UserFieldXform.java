package org.chanthing.csvtool.xform;

import java.util.*;

import org.apache.commons.csv.CSVRecord;

import org.chanthing.util.State;

/**
 * Transform class for fields that need to hold a Rally user name
 * exercise.
 */
public class UserFieldXform extends CSVFieldXform {

    /**
     *  Return a valid Rally user to be used in fields like Owner.
     *
     * @param    src   CSVRecord (is ignored)
     * return          A Rally user name
     */
    public String xform(CSVRecord src) {
	return "curmudgeon@rallydev.com";
    }

}


