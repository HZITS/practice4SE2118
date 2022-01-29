package data.postgres;

import data.DB;

import java.sql.*;

public class Postgres implements DB {
    private Connection conn;

    public Postgres(){
        String conURl = "jdbc:postgresql://localhost:5432/practice4";

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(conURl, "postgres", "1234");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
