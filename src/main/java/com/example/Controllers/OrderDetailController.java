package com.example.Controllers;

import com.example.Domain.OrderDetail;
import com.example.Repositories.OrderDetailDAO;
import com.example.Services.OrderDetailservice;
import com.example.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by waqas on 16/03/2017.
 */
@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailservice orderDetailservice;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Autowired
    private UserServices userServices;
    @RequestMapping(value = "order/orderlist", method = RequestMethod.GET)
    Page<OrderDetail> orderslist(Pageable pageable) {
        return orderDetailservice.findAll(pageable);
    }

    //@RequestMapping(value = "order/allorders", method = RequestMethod.GET)
    public String showGuestList(Model model) {
        model.addAttribute("orderlist", orderDetailservice.findAllOrdsers());
        return "User/orderresults :: orderlist";
    }

    @RequestMapping(value = "/frag1", method = RequestMethod.GET)
    public String frag1(Model model) {
        model.addAttribute("content", "hello");
        return "User/fragment1 ::content";
    }

    @RequestMapping(value = "order/allorders", method = RequestMethod.GET)
    public String showorders(Model model) {
        // model.addAttribute("userslist", orderDetailservice.findAllOrdsers());
        //return "User/orderresults :: resultsList";    }
        model.addAttribute("userslist", userServices.findAllUsers());
        return "User/orderresults :: resultsList";
    }


}