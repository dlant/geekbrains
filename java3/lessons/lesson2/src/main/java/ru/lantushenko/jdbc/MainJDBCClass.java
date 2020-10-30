package ru.lantushenko.jdbc;

import java.sql.*;

public class MainJDBCClass {
    public static void main(String[] args) {
        try {
            connect();
            //deleteAllRecords();
//            dropTable();
//            createTable();
//            updateData();
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
            while(rs.next()){
                System.out.println(rs.getInt(1)+ rs.getString("name")+rs.getInt("score"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    private static void updateData() throws SQLException {
        statement.executeUpdate("INSERT INTO student (name,score) VALUES ('alex4',15)");
        statement.executeUpdate("update student set score=55 where id=1;");
    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS student(\n"+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"+
                "name TEXT,\n"+
                "score INTEGER)");
    }

    private static void dropTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS student");
    }

    private static void deleteAllRecords() throws SQLException {
        statement.executeUpdate("DELETE FROM student");
    }

    private static Connection connection;
    private static Statement statement;
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
