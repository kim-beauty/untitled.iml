package earthquake;
import org.sqlite.JDBC;
import java.sql.*;
import java.util.*;
import java.util.List;


public class Db {
        private static Connection connection;
        protected static Statement statement;

        public Db(String p) throws SQLException {

            final String CON_STR = "jdbc:sqlite:bdProject";
            connection = DriverManager.getConnection(CON_STR);
            statement = connection.createStatement();
        }

        public void addEarthquake (Earthquake earthquake) {
            try (PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO Earth (`Id`, `Depth`, `TypeOfMagnitude`,`Magnitude`,`State`,`Time`) " +
                            "VALUES(?, ?, ?,?,?,?)")) {
                statement.setObject(1, earthquake.Id());
                statement.setObject(2, earthquake.Depth());
                statement.setObject(3, earthquake.TypeOfMagnitude());
                statement.setObject(4, earthquake.Magnitude());
                statement.setObject(5, earthquake.State());
                String var1 = earthquake.Time();
                String[] val1 = var1.split("-");
                String res1 = val1[0];
                statement.setObject(6, res1);
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void CreateT(Parser p, Db e) throws SQLException{

            String request = "CREATE TABLE IF NOT EXISTS Earth (Id TEXT, Depth TEXT, TypeOfMagnitude TEXT, Magnitude TEXT, State TEXT, Time TEXT) ";
            statement.execute(request);
            ResultSet resultSet = statement.executeQuery("Select count(*) FROM Earth");
            if (resultSet.getInt(1) < 10){
                p.earthquakesList.forEach(e::addEarthquake);
            }

        }
    }
