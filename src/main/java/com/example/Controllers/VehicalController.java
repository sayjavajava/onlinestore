package com.example.Controllers;

import com.example.Domain.Vehical;
import com.example.Repositories.VehicalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by waqas on 26/02/2017.
 */
@Controller
public class VehicalController {

    @Autowired
    private VehicalDao vehicalDao;
    @RequestMapping("/vehical/new")
    public String saverecord(Model model){
        model.addAttribute("vehicaldetail",new Vehical());
        return "vehicalform";
    }

    @RequestMapping("/vehicalact")
    public String saverecord(Vehical product)
    {
        try {
            vehicalDao.save(product);
            System.out.println("username :" + ""+product.getId());
        }catch(Exception ex){

            System.out.println("username :" + ""+product.getId());
            System.out.println("the exception"+ex);

        }
        return "redirect:/vehical";
    }

    @RequestMapping(value = "/vehical")
    public String list(Model model){
        model.addAttribute("allvehical",vehicalDao.findAll());
        return "allvehical";
    }

}
