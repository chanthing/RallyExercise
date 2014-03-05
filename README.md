RallyExercise
=============


Steps
-----

The rough steps I took:


Investigated Baltimore City data page. Used filter to limit data to violations that occurred on
July 4, 2012, then saved this as .csv file using Export functionality. Would like to create a 
script to grab the file based on command line args using curl. Will investigate exact URL required
later by either looking at the api_foundry page or setting up a proxy (Apache JMeter?) to capture the
URL passed when I hit the "Export" button.

Found Apache Commons CSV project as a Java Class Library for parsing CSV files. Checked out source code
with svn and built required .jar file with Maven.

Git URL for cloning is https://github.com/chanthing/RallyExercise.git

Iteratively wrote and tested my solution, which used the following procedure for transforming the file.


Technique
---------
I decided on an approach where the new CSV file would be created a field at a time by successively
calling transformation methods (implemented by subclasses of the 
abstract class org.chanthing.csvtool.xform.CSVFieldXform that are written to handle each possible
transformation specified in the problem description). The transformation methods take a single 
argument, the CVSRecord that is being transformed.

I had some problems with the way Apache Commons CSV does quoting, and in fact ended up turning off
the package's quoting and writing my own routine to handle quoting (further work is required to
correctly implement quoting such that a double quote character is properly escaped). When adding this
generic functionality to org.chanthing.cvstool.xform.CVSFieldXform was changed from an interface to
an abstract class.


I wrote the simple shell script, xformfile.sh, as a shortcut for running the program. To transform
a file containing the Baltimore City data, execute

        # xformfile.sh <in-csv-file> <out-csv-file>

The sample input data I've provided (based on the problem definition) is in the file 
Parking_Citations_07042012.csv. My sample output produced by my program is in 
RallyUserStoriesIn_07042012.csv.

TODOs
-----

The following tasks remain:

- Add JUnit unit testing. Yes, this should've been done as I wrote the code.

- Add code to make sure that PlanEstimateXform.xform returns an integer

- Implement retrieve.sh script to go grab data from the Baltimore city database, based on command line
arguments specifying the desired date range (and eventually other filter parameters).

- Improve error handling. At the least I should be catching FileNotFoundException in the case where
the specified input file doesn't exist.

- Finish adding Javadoc tags.






