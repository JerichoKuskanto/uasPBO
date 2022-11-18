package uaspbo.Controller;

import uaspbo.Model.*;
import java.util.ArrayList;
import java.sql.*;

public class SQLController {

    static DatabaseHandler conn = new DatabaseHandler();

    public String cekLogin(String name, String password) {
        conn.connect();
        String query = "SELECT userName FROM user where userName = '" + name + "' AND userPassword ='" + password + "';";
        String userName = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                userName = rs.getString("userName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userName;
    }

    public User getDataUser(String userName) {
        conn.connect();
        String query = "SELECT * FROM user where userName ='" + userName + "';";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setUserGender(rs.getString("userGender"));
                user.setUserFollowers(rs.getInt("userFollowers"));
                user.setUserCategory(getCategory(rs.getInt("userCategory")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public CategoryUser getCategory(int idCategory) {
        conn.connect();
        String query = "SELECT * FROM categoryuser where Categoryid ='" + idCategory + "';";
        CategoryUser category = new CategoryUser();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                category.setCategoryId(rs.getInt("Categoryid"));
                category.setCategoryName(rs.getString("CategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public CategoryUser getCategoryName(String nameCategory) {
        conn.connect();
        String query = "SELECT * FROM categoryUser where categoryName ='" + nameCategory + "';";
        CategoryUser category = new CategoryUser();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                category.setCategoryId(rs.getInt("Categoryid"));
                category.setCategoryName(rs.getString("CategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public ArrayList<CategoryUser> getAllCategory() {
        conn.connect();
        String query = "SELECT * FROM categoryuser;";
        ArrayList<CategoryUser> listCategory = new ArrayList();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setCategoryId(rs.getInt("Categoryid"));
                category.setCategoryName(rs.getString("CategoryName"));
                listCategory.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCategory;
    }
}
