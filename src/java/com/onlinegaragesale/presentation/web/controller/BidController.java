package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.AcceptBidService;
import com.onlinegaragesale.services.GetProductsService;
import com.onlinegaragesale.services.crud.BidCrudService;
import com.onlinegaragesale.services.crud.ProductCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * File Name: BidController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 25 Oct 2012
 * Edited: 25 Oct 2012
 */
@Controller
public class BidController
{

    private final Facade facade = new Facade();

    @RequestMapping(value = "viewmybids.html", method = RequestMethod.GET)
    public ModelAndView getViewMyBids(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); //get logged in username

        GetProductsService productsService = facade.getGetProductsService();
        List<Product> products = productsService.usersBids(email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("viewmybids");
        return modelAndView;
    }

    @RequestMapping(value = "acceptbid.html", method = RequestMethod.GET)
    public ModelAndView acceptBid(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); //get logged in username

        GetProductsService productsService = facade.getGetProductsService();
        List<Product> products = productsService.userProductsForSale(email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("acceptbid");
        return modelAndView;
    }

    @RequestMapping(value = "processacceptbid.html", method = RequestMethod.GET)
    public ModelAndView processAcceptBid(@RequestParam("id") String bidId, Model model)
    {        
        BidCrudService bidCrudService = facade.getBidCrudService();
        AcceptBidService acceptBidService = facade.getAcceptBidService();
        Bid bid = bidCrudService.findById(new BigDecimal(bidId));
        acceptBidService.acceptBid(bid);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bid", bid);
        modelAndView.setViewName("bidprocessed");
        return modelAndView;
    }
}
