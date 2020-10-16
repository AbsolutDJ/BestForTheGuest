package projektarbete.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projektarbete.demo.service.HouseService;

@Controller
public class HouseController {

    @Autowired //Annotation som talar om för container att göra en dependency injection, den letar reda på HouseService.
    private HouseService houseService;




    @RequestMapping("/home")
    public String getHouses(Model model){
        model.addAttribute("houses" , houseService.getAllHouses());
        return "index";

    }

}
