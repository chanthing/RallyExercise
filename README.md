RallyExercise
=============


Steps
-----

The rough steps I took.


Investigated Baltimore City data page. Used filter to limit data to violations that occurred on
July 4, 2012, then saved this as .csv file using Export functionality. Would like to create a 
script to grab the file based on command line args using curl. Will investigate exact URL required
later by either looking at the api_foundry page or setting up a proxy (Apache JMeter?) to capture the
URL passed when I hit the "Export" button.

Found Apache Commons CSV project as a Java Class Library for parsing CSV files. Checked out source code
with svn and built required .jar file with Maven.


