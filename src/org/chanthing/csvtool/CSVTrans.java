package org.chanthing.csvtool;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.Quote;

import org.chanthing.csvtool.xform.*;
import org.chanthing.csvtool.xform.CSVFieldXform;

/*
 *   Class to read and transform a csv file according to mapping rules that control field
 *   placement, input validation, and data canonicalization.
 */

public class CSVTrans {

    /* 
     *   These are instance variables specific to the particular transformation specified.
     * To implement a different transformation, modify the values of these instance variables,
     */
    private static ArrayList<String>    destHeaders;
    static {
	destHeaders = new ArrayList<String>(20);
	destHeaders.add("\"Display Color\"");
	destHeaders.add("Ready");
	destHeaders.add("Name");
	destHeaders.add("Description");
	destHeaders.add("Notes");
	destHeaders.add("Owner");
	destHeaders.add("\"Schedule State\"");
	destHeaders.add("\"Plan Estimate\"");
	destHeaders.add("\"Blocked\"");
	destHeaders.add("\"Code Review\"");
	destHeaders.add("\"Code Review Link\"");
	destHeaders.add("\"External Link\"");
	destHeaders.add("Risk");
	destHeaders.add("ServicesKanbanState");
	destHeaders.add("T-Shirt");
	destHeaders.add("Urgent");
	destHeaders.add("violationDate");
	destHeaders.add("LicenseExpiration");
    }

    private static CSVFieldXform xforms[];
    static {
	xforms = new CSVFieldXform[destHeaders.size()];
	xforms[0] = new StringEchoXform("Sample Display Color");
	xforms[1] = new BooleanFieldXform(true);
	xforms[2] = new NameFieldXform();
	xforms[3] = new DescriptionFieldXform();
	xforms[4] = new NotesFieldXform();
	xforms[5] = new UserFieldXform(); 
	xforms[6] = new StringEchoXform("Idea"); 
	xforms[7] = new PlanEstimateXform();
	xforms[8] = new BooleanFieldXform(false);
	xforms[9] = new BooleanFieldXform(true);
	xforms[10] = new BooleanFieldXform(true);
	xforms[11] = new StringEchoXform("Sample External Link");
	xforms[12] = new StringEchoXform("Medium");
	xforms[13] = new StringEchoXform("Release");
	xforms[14] = new StringEchoXform("S");
	xforms[15] = new BooleanFieldXform(false);
	xforms[16] = new ViolationDateXform(); 
	xforms[17] = new LicenseExpirationXform();
    }

    /*
     * In this case, the src and destination formats are the same.
     */
    private static CSVFormat srcFormat = CSVFormat.EXCEL.withHeader().withDelimiter(',');
    private static CSVFormat destFormat = CSVFormat.EXCEL.withHeader().withDelimiter(',').withQuotePolicy(Quote.NONE).withEscape('\\');

    public static void main(String[] args) throws IOException {
	CSVParser    reader = null;
	CSVPrinter   writer = null;
	CSVXform     xFormer = null;

	if (args.length < 2) {
		System.out.println("Usage: java CSVTrans <src_csv_file> <dest_csv_file>");
		return;
	}

	try {
	    reader = new CSVParser(new FileReader(args[0]), srcFormat);
	    writer = new CSVPrinter(new FileWriter(args[1]), destFormat);
	    xFormer = new CSVXform(destHeaders.size(), xforms);

	    writer.printRecord(destHeaders);    // Write out headers to destination file

	    /*
	     *  For each record in the input file
	     */
	    for (CSVRecord record : reader) {
		List<String> destRecord = xFormer.xform(record);
		writer.printRecord(destRecord);
	    }

	} finally {
	    if (reader != null) {
		reader.close();
	    } 
	    if (writer != null) {
		writer.close();
	    }
	}
    }

    private static void printValues(int lineNumber, String[] as) {
		System.out.println("Line " + lineNumber + " has " + as.length + " values:");
		for (String s: as) {
			System.out.println("\t|" + s + "|");
		}
		System.out.println();
    }
}

