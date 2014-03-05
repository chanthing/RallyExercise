package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;


/*
 * Transform class whose xform method returns a string representing a boolean value.
 */
public class BooleanFieldXform extends CSVFieldXform {

    private boolean value;

    public BooleanFieldXform(boolean val) {
        this.value = val;
    }

    /*
     * The src record is ignored.
     */
    public String xform(CSVRecord src) {
        return (value) ? "True" : "False";
    }

    public boolean getFieldVal() {
        return value;
    }


}


