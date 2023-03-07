package lt.ku.homeworks4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeworks4Controller {

    @GetMapping("/")
    public String home(Model model){
        return "skaiciuokle";
    }

    @PostMapping("/")
    public String apskaiciuoti(
            @RequestParam("kaina") Integer kaina,
            @RequestParam("kiekis") Integer kiekis,
            Model model
    ){
        double BePVM = kaina / 1.21;
        model.addAttribute("BePVM", BePVM);

        double PVM = kaina - BePVM;
        model.addAttribute("PVM", PVM);

        double VisobePVM = BePVM * kiekis;
        model.addAttribute("VisobePVM", VisobePVM);

        double VisiMok = PVM * kiekis;
        model.addAttribute("VisiMok", VisiMok);

        double VisaKaina = kaina * kiekis;
        model.addAttribute("VisaKaina", VisaKaina);

        return "isvedimas";
    }


}
