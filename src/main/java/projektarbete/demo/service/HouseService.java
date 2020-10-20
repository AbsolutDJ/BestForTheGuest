package projektarbete.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import projektarbete.demo.House;
import projektarbete.demo.repository.IHouseCrud;


import java.util.List;

@Service // Holds the business logic and call methods in the repository layer.
public class HouseService {


    @Autowired
    private IHouseCrud crud;

    public List<House> getAllHouses() {
        return crud.getAllHouses();
    }

    

}