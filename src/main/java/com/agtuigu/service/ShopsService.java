package com.agtuigu.service;

import java.util.ArrayList;
import java.util.List;
import com.agtuigu.entities.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopsService {

    public List<Shop> getShops(){
        Shop shop = new Shop();
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();

        shop.setName("李爱秋");
        shop.setStuffName(new String[]{"haha", "hehe"});

        shop1.setName("xiaomaoxi");
        shop1.setStuffName(new String[]{"heihei", "lala"});

        shop2.setName("qinaide");
        shop2.setStuffName(new String[]{"xixi", "wuwu"});
        List<Shop> list = new ArrayList<>();
        list.add(shop);
        list.add(shop1);
        list.add(shop2);
        return list;

    }
}
