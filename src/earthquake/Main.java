package earthquake;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
            public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Parser pr = new Parser();
            Db sqlite = new Db("jdbc:sqlite:bdProject.db");
            Db.createTable(pr, sqlite);
            System.out.println("Ответы на задания.");

            FirstTask();
            SecondTaskSQL();
            ThirdTaskSQL();


        }
        public static void FirstTask() throws SQLException {
            //Постройте график по среднему количеству землетрясений для каждого года
            Map<String, Float> countEarthquake = new HashMap<>();
            String req = "SELECT 1.0 * InternetUsers/Population * 100 AS InternetUsers, Subregion " +
                    "FROM Earth " +
                    "GROUP BY Time;";

            ResultSet resSet = earthquake.Db.statement.executeQuery(req);

            while (resSet.next()){
                countEarthquake.put(
                        resSet.getString("Subregion"),
                        Float.parseFloat(resSet.getString("InternetUsers"))
                );
            }

            EventQueue.invokeLater(() -> {
                var pl = new Graphik(countEarthquake);
                pl.setVisible(true);
            });
        }

        public static void SecondTaskSQL() throws SQLException {
            //Выведите в консоль среднюю магнитуду для штата "West Virginia"
            System.out.println("\n Задание 2 \n" +
                    "Выведите в консоль среднюю магнитуду для штата \"West Virginia\"");

            String rez = "Select AVG(Magnitude) from Earth where State  = 'West Virginia'";

            System.out.println(rez);
        }

        public static void ThirdTaskSQL() throws SQLException {
            //Выведите в консоль название штата, в котором произошло самое глубокое землетрясение в 2013 году
            System.out.println("\nЗадание 3. \n" +
                    "Выведите в консоль название штата, в котором произошло самое глубокое землетрясение в 2013");

            String rez = "select MAX(Magnitude) from Earth where Time = '2013' ";

            String answer = Db.statement.executeQuery(rez).getString("State");

            System.out.println(answer);
        }



    }
}