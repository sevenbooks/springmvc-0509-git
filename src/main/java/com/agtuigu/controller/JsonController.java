package com.agtuigu.controller;

import com.agtuigu.entities.Shop;
import com.agtuigu.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JsonController {
    @Autowired
    private ShopsService shopsService;


    @ResponseBody
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Shop getShopJson(@PathVariable(value = "name") String name){

        Shop shop = new Shop();
        shop.setName(name);
        shop.setStuffName(new String[]{"mkyong1", "mkyong2"});
        return shop;
    }



    @ResponseBody
    @RequestMapping(value = "getShopListJson", method = RequestMethod.GET)
    public List<Shop> getShopListJson(){

        return shopsService.getShops();
    }
}
