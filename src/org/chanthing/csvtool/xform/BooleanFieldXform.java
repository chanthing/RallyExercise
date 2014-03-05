package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;


/**
 * Transform class whose xform method returns a string representing a boolean value.
 */
public class BooleanFieldXform extends CSVFieldXform {

    private boolean value;

    public BooleanFieldXform(boolean val) {
        this.value = val;
    }

    /**
     * The src record is ignored.
	 * 
	 * @param  src  The CSVRecord to be transformed, ignored in this case.
	 * @return      A string "True" or "False", based on the boolean value set at construction time.
     */
    public String xform(CSVRecord src) {
        return (value) ? "True" : "False";
    }

    public boolean getFieldVal() {
        return value;
    }


}


