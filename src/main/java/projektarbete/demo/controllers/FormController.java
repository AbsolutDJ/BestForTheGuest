package projektarbete.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projektarbete.demo.service.HouseService;

@Controller
public class FormController {

    @Autowired //Annotation som talar om för container att göra en dependency injection, den letar reda på HouseService.
   private HouseService houseService;


    @RequestMapping("/house/edit/{id}")
    public String editHouse(Model model, @PathVariable(required = false) int id){
        for (int i = 0; i < houseService.getAllHouses().size(); i++){
            if(id == houseService.getAllHouses().get(i).getId()){
                model.addAttribute("houseform",houseService.getAllHouses().get(i));
            }

        }
        return "formview";

    }

}


