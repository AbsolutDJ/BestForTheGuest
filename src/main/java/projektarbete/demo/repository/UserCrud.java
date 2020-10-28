package projektarbete.demo.repository;


import org.springframework.stereotype.Repository;
import projektarbete.demo.House;
import projektarbete.demo.User;

import java.awt.desktop.UserSessionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserCrud implements IUserCrud {
    private Connection con; //Connection till databasen.


    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>(); //Listan som fylls med användare som hämtas ifrån databasen.

        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");
            Statement statement = con.createStatement();
            String sqlgetAllUsers = "SELECT * FROM user";
            ResultSet resultSet = statement.executeQuery(sqlgetAllUsers);
            while (resultSet.next()) {
                User user = new User();
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }// end while
            resultSet.close();
            statement.close();
            con.close();
            return users;
        } // end try
        catch (SQLException ex) {
            Logger.getLogger(UserCrud.class.getName()).log(Level.SEVERE, null, ex);
        }// end users
        return null;
    }



    public User addUser(User user){
        try{
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");
            String sqlInsertUser = "INSERT INTO user (username,password) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sqlInsertUser);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());


            statement.executeUpdate();

            statement.close();
            con.close();
            return user;
        }catch (SQLException ex) {
            Logger.getLogger(UserCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}

