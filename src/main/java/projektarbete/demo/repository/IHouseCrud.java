package projektarbete.demo.repository;
import projektarbete.demo.House;

import java.util.List;

public interface IHouseCrud {
    public List<House> getAllHouses();
    public House updateHouse(House house);
    public House addHouse(House house);
    public House getHouseById(Integer id);
    public House delete(int id);

}// end interface
