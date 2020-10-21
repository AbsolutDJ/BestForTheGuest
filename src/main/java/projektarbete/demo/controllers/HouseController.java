package projektarbete.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projektarbete.demo.House;
import projektarbete.demo.repository.HouseCrud;
import projektarbete.demo.service.HouseService;

import java.util.Map;

@Controller
public class HouseController {

    @Autowired //Annotation som talar om för container att göra en dependency injection, den letar reda på HouseService.
    private HouseService houseService;




    @RequestMapping("/home")
    public String getHouses(Model model){
        model.addAttribute("houses" , houseService.getAllHouses());
        return "index";

    }


    @RequestMapping("/house/{id}")
    public String getHouse(Model model, @PathVariable(required = false) int id){
        for (int i = 0; i < houseService.getAllHouses().size(); i++){
            if(id == houseService.getAllHouses().get(i).getId()){
                model.addAttribute("house",houseService.getAllHouses().get(i));
            }

        }
        return "privatehouseview";

}

    @RequestMapping("/house/add")
    public String prepAddHouse(){
        return "addhouseview";
    }

    @GetMapping(path = "/house/{id}")
    public String getHouseById(Model model, @PathVariable Integer id){
        model.addAttribute("house", houseService.getHouseById(id));
        return "privatehouseview";
    }

    @GetMapping(path = "/house/edit/{id}")
    public String editHouse(Model model,@PathVariable Integer id){
        model.addAttribute("house", houseService.getHouseById(id));
        return "formview";
    }


    @PostMapping(path = "/house/add/test") //Byt mapping här sen, GLÖM INTE!
     public String addHouse (@ModelAttribute("House") House house, @RequestParam Map<String, String> allFormRequestParams){
       House newHouse = new House();
       newHouse.setCountry(allFormRequestParams.get("country"));
       newHouse.setCity(allFormRequestParams.get("city"));
       newHouse.setAddress(allFormRequestParams.get("address"));
       newHouse.setAmenities(allFormRequestParams.get("amenities"));
       newHouse.setPicture(allFormRequestParams.get("picture"));
       newHouse.setDescription(allFormRequestParams.get("description"));
       houseService.addHouse(house);
       return "redirect:/home";
}

}
