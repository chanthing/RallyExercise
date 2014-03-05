package org.chanthing.csvtool.xform;

import org.apache.commons.csv.CSVRecord;


/*
 * Class that represents information on how to transform a field in a CSV record to a field in 
 * a record making up the contents of a CSV file in a new format.
 *
 * This should be extended to implement specific transforms. It's an abstract class rather than
 * an interface because it may a good place to implement formatting routines that can be used by 
 * multiple transforms. If this turns out not to be true, it should be refactored to be 
 * an interface.
 *
 */

public abstract class CSVFieldXform {

    public abstract String xform(CSVRecord src); 


}
