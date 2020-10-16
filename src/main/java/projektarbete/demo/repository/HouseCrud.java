package projektarbete.demo.repository;

import org.springframework.stereotype.Repository;
import projektarbete.demo.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class HouseCrud implements IHouseCrud {
    private Connection con; //Connection obj till databasen.

    @Override
    public List<House> getAllHouses() {
        List<House> houses = new ArrayList<>(); //Listan som fylls med datan ifrån databasen.
        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "fRfTcsCxVf");
            Statement statement = con.createStatement();
            String sqlSelectAllHouses = "SELECT * FROM house";
            ResultSet resultSet = statement.executeQuery(sqlSelectAllHouses);
            while (resultSet.next()) {
                House house = new House();
                house.setCountry(resultSet.getString("country"));
                house.setCity(resultSet.getString("city"));
                house.setSize(resultSet.getString("size"));
                house.setNoOfBeds(resultSet.getInt("noOfBeds"));
                house.setAmenities(resultSet.getString("amenities"));
                house.setPicture(resultSet.getString("picture"));
                house.setDescription(resultSet.getString("description"));
                house.setId(resultSet.getInt("id"));
                houses.add(house);

            } //end while
            resultSet.close();
            statement.close();
            con.close();
            return houses;
        }// end try
        catch (SQLException ex) {
            Logger.getLogger(HouseCrud.class.getName()).log(Level.SEVERE, null, ex);
        }// end cars

        return null;

    } //end getAllHouses

}
