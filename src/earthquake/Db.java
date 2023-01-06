package earthquake;
import org.sqlite.JDBC;
import java.sql.*;
import java.util.*;

public class Db {

        // Константа, в которой хранится адрес подключения
        private static final String CON_STR = "jdbc:sqlite:bdProject.db";

        // Используем шаблон одиночка, чтобы не плодить множество
        // экземпляров класса DbHandler
        private static Db instance = null;

        public static synchronized Db getInstance() throws SQLException {
            if (instance == null)
                instance = new Db();
            return instance;
        }

        // Объект, в котором будет храниться соединение с БД
        private Connection connection;

        private Db() throws SQLException {
            // Регистрируем драйвер, с которым будем работать
            // в нашем случае Sqlite
            DriverManager.registerDriver(new JDBC());
            // Выполняем подключение к базе данных
            this.connection = DriverManager.getConnection(CON_STR);
        }

        public List<Earthquake> getAllEarthquake() {

            // Statement используется для того, чтобы выполнить sql-запрос
            try (Statement statement = this.connection.createStatement()) {
                // В данный список будем загружать наши продукты, полученные из БД
                List<Earthquake> earth = new ArrayList<Earthquake>();
                // В resultSet будет храниться результат нашего запроса,
                // который выполняется командой statement.executeQuery()
                ResultSet resultSet = statement.executeQuery("SELECT Id, Depth, TypeOfMagnitude,Magnitude,State,Time FROM Earth");
                // Проходимся по нашему resultSet и заносим данные в products
                while (resultSet.next()) {
                    earth.add(new Earthquake(resultSet.getString("Id"),
                            resultSet.getInt("Depth"),
                            resultSet.getString("TypeOfMagnitude"),
                            resultSet.getInt("Magnitude"),
                            resultSet.getString("State"),
                            resultSet.getString("Time")
                    ));
                }
                // Возвращаем наш список
                return earth;

            } catch (SQLException e) {
                e.printStackTrace();
                // Если произошла ошибка - возвращаем пустую коллекцию
                return Collections.emptyList();
            }
        }

        // Добавление продукта в БД
        public void addEarthquake (Earthquake earthquake) {
            // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
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
                String res1 = val1[1];

                statement.setObject(6, res1);
                // Выполняем запрос
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Удаление продукта по id
        public void deleteEarthquake (int id) {
            try (PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM Earth WHERE Id = ?")) {
                statement.setObject(1, id);
                // Выполняем запрос
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
