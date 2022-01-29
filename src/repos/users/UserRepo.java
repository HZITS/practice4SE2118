package repos.users;

import data.DB;
import data.postgres.Postgres;
import models.User;
import repos.EntityRepo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserRepo implements EntityRepo<User> {
    private final DB db;

    public UserRepo(DB db) {
        this.db = db;
    }

    @Override
    public User get(int id) {
        User user = null;
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        try {
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
