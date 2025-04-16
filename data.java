// package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class data {
    public List<Product> fetchData(String password) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/demo_db";
        String username = "root"; // 데이터베이스 사용자명
        List<Product> products = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            statement = connection.createStatement();

            // SQL 파일 실행
            executeSqlFile(connection, "C:\\OOP\\KioskProject\\demo_db_products.sql");

            // 데이터 조회 쿼리 실행
            String sql = "SELECT * FROM products";
            resultSet = statement.executeQuery(sql);

            // 결과를 Product 객체로 변환하여 리스트에 추가
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                int price = resultSet.getInt("price"); // price 필드 추가
                products.add(new Product(id, name, quantity, price));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("SQL 파일을 읽을 수 없습니다.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    private void executeSqlFile(Connection connection, String filePath) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement statement = connection.createStatement()) {
            String line;
            StringBuilder sql = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sql.append(line);
                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
            }
        }
    }
}