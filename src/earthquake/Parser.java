package earthquake;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Earthquake> earthquakesList = new ArrayList<>();
public Parser() {
    String csvFilename = "C:\\Users\\USER\\Desktop\\ТП\\Землетрясение.csv";
    try (CSVReader csvReader = new CSVReader (new FileReader(csvFilename))){
        String [] row;
        while ((row = csvReader.readNext()) != null) {
            Earthquake earthquake = new Earthquake(row[0],Integer.parseInt(row[1]),row[2],Integer.parseInt(row[3]),row[4],row[5]);
            earthquakesList.add(earthquake);
        }
    } catch (Exception e) {
        e.printStackTrace();
}
}}
