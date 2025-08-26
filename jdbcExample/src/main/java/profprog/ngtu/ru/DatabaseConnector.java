package profprog.ngtu.ru;

import java.sql.*;
import java.util.List;

public class DatabaseConnector {
    private final static DatabaseConnector instance = new DatabaseConnector();
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    private DatabaseConnector() {
        try {
            connection
                    = DriverManager.getConnection(ApplicationProperties.DATABASE_URL,
                    ApplicationProperties.DATABASE_USERNAME,
                    ApplicationProperties.DATABASE_PASSWORD);
            System.out.println("Соединение с базой данных установлено.");
        } catch (SQLException e) {
            System.out.println("Соединение с базой данных не установлено: " + e.getMessage());
            System.exit(1);
        }
    }

    public static DatabaseConnector getInstance() {
        return instance;
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Соединение с базой данных закрыто.");
        } catch (SQLException e) {
            System.out.println("Соединение с базой данных не может быть закрыто: " + e.getMessage());
        }
    }

    public ResultSet getAll() {
        String query = "select * from present";
        try {
            statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных: " + e.getMessage());
            return null;
        }
    }

    public void updateById(int id, String columnName, Object value) {
        String query = " update present set " + columnName + "=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении данных: " + e.getMessage());
        }
    }

    public void insert(List<Object> values) {
        String query = "insert into present(name, price, min_age, max_age, category_id) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setObject(i+1, values.get(i));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении данных: " + e.getMessage());
        }
    }
}
