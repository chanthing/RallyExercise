package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;


/*
 * Transform class whose xform method simply returns a static string. It might be best to make the
 * fieldValue instance variable final, for now, it is enough to make it private with no setter.
 */
public class StringEchoXform extends CSVFieldXform {

    private String fieldVal;

    public StringEchoXform(String val) {
        fieldVal = val;
    }

    /*
     * The src record is ignored.
     */
    public String xform(CSVRecord src) {
        return fieldVal;
    }

    public String getFieldVal() {
        return fieldVal;
    }


}


