package com.example.Controllers;

import com.example.Domain.Product;
import com.example.Domain.UserForm;
import com.example.Repositories.UserFormBootstrapDAO;
import com.example.Services.UserFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by waqas on 28/02/2017.
 */
@Controller
public class UserFormController {

    @Autowired
    private UserFormService userFormService;

    @RequestMapping("userform/new")
    public String saverecord(Model model){
        model.addAttribute("UserForm",new UserForm());
        return "userformbootstrap";
    }
    @RequestMapping("/search")
    public String searchAjax(){
        return "search";
    }


    @RequestMapping("/formact")
    public String saverecord(UserForm product){
        List<UserForm> foundlist =userFormService.findByEmail(product.getEmail());

        userFormService.save(product);
                  //userFormService.save(product);
        return "userform/new";
    }


    @RequestMapping(value = "/guests/{surname}", method = RequestMethod.GET)
    public String showGuestList(Model model, @PathVariable("surname") String surname) {
        model.addAttribute("guests",userFormService.findByLastName(surname));

        return "results :: resultsList";
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("guests", userFormService.AllGuests());

        return "results :: resultsList";
    }
}
