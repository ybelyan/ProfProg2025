package profprog.ngtu.ru;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class DatabaseApplication {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = DatabaseConnector.getInstance();
        try {
            ResultSet resultSet = databaseConnector.getAll();
            if (resultSet != null){
                printAll(resultSet);
            }
            databaseConnector.updateById(6, "price", 140);
            resultSet = databaseConnector.getAll();
            if (resultSet != null){
                printAll(resultSet);
            }

            databaseConnector.insert(Arrays.asList("букет цветов", 1500, 2, 99, 4));
            resultSet = databaseConnector.getAll();
            if (resultSet != null){
                printAll(resultSet);
            }
          } finally {
            databaseConnector.close();
        }
    }

    private static void printAll(ResultSet resultSet)  {
        try {
            System.out.printf("%3s | %30s | %5s | %7s | %7s\n", "id", "name", "price", "min_age", "max_age");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int minAge = resultSet.getInt("min_age");
                int maxAge = resultSet.getInt("max_age");
                System.out.printf("%3d | %30s | %5d | %7d | %7d\n", id, name, price, minAge, maxAge);
            }
            System.out.println(System.lineSeparator());
        } catch (SQLException e) {
            System.out.println("Ошибка при распечатывании данных: " + e.getMessage());
        }
    }
}