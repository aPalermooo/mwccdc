package com.itccloud.mwccdc.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVFileParser {


    public static void main(String[] args) throws IOException {
//        readCsv();
//        writeCsv();
        return;
    }

    public static List<Person> readCsv() throws FileNotFoundException, IOException {
        // Location of the file

        List<Person> ret = new ArrayList<>();

        String root = "/home/cinnamon/Documents/WebDesign/mwccdc/src/main/java/com/itccloud/mwccdc/data/"; //Using linux
        String filePath = root + "persons2.csv";

        FileReader reader = new FileReader(filePath);
        @SuppressWarnings("deprecation")
		CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.withIgnoreSurroundingSpaces());

        for (CSVRecord record : parser) {

            String[] addressInfo = record.get(3).split(",");
            Address address = new Address(addressInfo[0], addressInfo[1], addressInfo[2], addressInfo[3]);

            Person person = new Person(record.get(0), record.get(1), record.get(2), address);
//            System.out.println(person);
            ret.add(person);
        }

        return ret;
    }

    public static void writeCsv() throws IOException {

        String root = "/home/cinnamon/Documents/WebDesign/";
        String filePath = root + "newPersons2.csv";

        List<Person> persons = readCsv();
        persons.add((new Person("Bob", "Henry", "Male", new Address("#4 that street", "Placeholder", "CA", "88890"))));

        FileWriter fileWriter = new FileWriter(filePath);
        CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

        for (Person person : persons) {
            printer.printRecord(person.getFirstName(), person.getLastName(), person.getGender(), person.getAddress());

        }

        printer.flush();
        printer.close();

    }


}
