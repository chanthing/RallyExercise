package org.chanthing.csvtool;



/*
 * Class that represents information on how to transform a field in a CSV record to a field in 
 * a record making up the contents of a CSV file in a new format.
 *
 * This should be extended to implement specific transforms. It's an abstract class rather than
 * an interface because it is a good place to implement formatting routines that can be used by 
 * multiple transforms.
 *
 */

public abstract class CSVFieldXform {

    /*
     * The default transformation is simply to return the string that was passed in.
     */
    public String xform(String src) {
	return src;
    }


}
