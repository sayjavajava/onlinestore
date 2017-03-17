package com.example.Controllers;

import com.example.Domain.User_Detail;
import com.example.Services.OrderDetailservice;
import com.example.Services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by waqas on 26/02/2017.
 */
@Controller
public class UserDetailController {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    private OrderDetailservice orderDetailservice;
    @RequestMapping("/user/new")
    public String saverecord(Model model){
        model.addAttribute("userdetail",new User_Detail());
        return "userform";
    }
    @RequestMapping("user/edit/{id}")
    public String editecord(@PathVariable int id, Model model){
        model.addAttribute("product",userDetailService.findById(id));
        return "productform";
    }
    @RequestMapping("/useract")
    public String saverecord(User_Detail product)
    {
        try {
            userDetailService.save(product);
            System.out.println("username :" + ""+product.getProductname());
        }catch(Exception ex){

            System.out.println("username :" + ""+product.getProductname());
            System.out.println("the exception"+ex);

        }
            //return "redirect:/users/" +product.getId();
   return "redirect:/users";
    }

    @RequestMapping(value = "/users")
        public String list(Model model){
        model.addAttribute("allusers",userDetailService.findAll());
        return "allusers";
    }

    @RequestMapping(value = "/searchusers/{name}")
    public String FindByName(@PathVariable String name, Model model){
        model.addAttribute("allusers",userDetailService.findByName(name));
        return "allusers";
    }

@RequestMapping("user/delete/{id}")
 public String delete(@PathVariable int id ){
    userDetailService.delete(id);
    return "redirect:/users";
}

    @RequestMapping(value = "UserDetail/Order/testusers", method = RequestMethod.GET)
    public String showGuest(Model model) {
        model.addAttribute("userslist", orderDetailservice.findAllOrdsers());
        return "User/orderresults :: resultsList";
    }
}
