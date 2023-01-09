package earthquake;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Earthquake> earthquakesList = new ArrayList<>();
public Parser() {

    try (CSVReader csvReader = new CSVReader (new FileReader("src\\resources\\Earth.csv"))){
        String [] row;
        while ((row = csvReader.readNext()) != null) {
            Earthquake earthquake = new Earthquake(row[0],row[1],row[2],row[3],row[4],row[5]);
            earthquakesList.add(earthquake);
        }
    } catch (Exception e) {
        e.printStackTrace();
}
}}
