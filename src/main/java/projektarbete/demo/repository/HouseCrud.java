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
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");
            Statement statement = con.createStatement();
            String sqlSelectAllHouses = "SELECT * FROM house";
            ResultSet resultSet = statement.executeQuery(sqlSelectAllHouses);
            while (resultSet.next()) {
                House house = new House();
                house.setCountry(resultSet.getString("country"));
                house.setCity(resultSet.getString("city"));
                house.setAddress(resultSet.getString("address"));
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


    @Override
    public House updateHouse(House house){
        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");
            String sqlUpdateHouse = "UPDATE house SET country=?, city=?,address=?, amenities=?, picture=?, description=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlUpdateHouse);
            statement.setString(1, house.getCountry());
            statement.setString(2, house.getCity());
            statement.setString(3, house.getAddress());
            statement.setString(4, house.getAmenities());
            statement.setString(5, house.getPicture());
            statement.setString(6, house.getDescription());

            statement.setInt(7,house.getId());
            statement.executeUpdate();

            statement.close();
            con.close();
            return house;
        }
        catch (SQLException ex) {
            Logger.getLogger(HouseCrud.class.getName()).log(Level.SEVERE, null, ex);
        }// end cars

        return null;
    }


    @Override
    public House getHouseById(Integer id) {

        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");

            String sqlSelectHouseById = "SELECT * FROM house WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sqlSelectHouseById);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            House house = new House();
            while (resultSet.next()) {

                house.setCountry(resultSet.getString("country"));
                house.setCity(resultSet.getString("city"));
                house.setAddress(resultSet.getString("address"));
                house.setAmenities(resultSet.getString("amenities"));
                house.setPicture(resultSet.getString("picture"));
                house.setDescription(resultSet.getString("description"));
                house.setId(resultSet.getInt("id"));


            } //end while
            resultSet.close();
            statement.close();
            con.close();
            return house;

        }// end try
        catch (SQLException ex) {
            Logger.getLogger(HouseCrud.class.getName()).log(Level.SEVERE, null, ex);
        }// end cars

        return null;

    }

    public House addHouse(House house){
        try{
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Zv9EODbMNc", "Zv9EODbMNc", "CMmrcBMcCS");
            String sqlInsertHouse = "INSERT INTO house (country, city, address, amenities, picture, description) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sqlInsertHouse);

            statement.setString(1, house.getCountry());
            statement.setString(2, house.getCity());
            statement.setString(3, house.getAddress());
            statement.setString(4, house.getAmenities());
            statement.setString(5, house.getPicture());
            statement.setString(6, house.getDescription());
            statement.executeUpdate();

            statement.close();
            con.close();
            return house;
        }catch (SQLException ex) {
            Logger.getLogger(HouseCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }



}
