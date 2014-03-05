package org.chanthing.csvtool;

import java.io.*;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;

/*
 *   Class to read and transform a csv file according to mapping rules that control field
 *   placement, input validation, and data canonicalization.
 */

public class CSVTrans {

    public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: java CSVParseDemo <csv_file>");
			return;
		}

		CSVParser parser = new CSVParser(new FileReader(args[0]), CSVFormat.RFC4180.withHeader().withDelimiter(','));
		for (CSVRecord record : parser) {
			System.out.println("Record Number: " + record.getRecordNumber() + " has " +
				record.size() + " records, with a tag of " + record.get("tag"));
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

