 package com.example.Domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.*;


 /**
 * Created by waqas on 11/03/2017.
 */

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS, value = WebApplicationContext.SCOPE_SESSION)
public class Cart {

     private final Logger logger = LoggerFactory.getLogger(this.getClass());

     private Map<Product ,Integer> contents = new HashMap<Product,Integer>();

     public Map<Product, Integer> getContents() {
         return contents;
     }
     public Set<Product> getProduct(){
      return contents.keySet();
}
     public void addProduct(Product product){
         if(contents.containsKey(product)){
             contents.put(product,contents.get(product)+1);
             logger.info("i am from existing");
       }else {
             logger.info("i am new one ");
             contents.put(product,1);
             }

       //contents.computeIfPresent(product,(k,v)->v+1);
     }


    public  void remove(Product p ){
         /*for(Product key:contents.keySet()){
         System.err.println("key"+key.getId());
             if(key.getId().equals(id)){
                 contents.remove(key.getId());
                 logger.info("exist"+key.getId());
             }
         }*/
        for(Iterator<Map.Entry<Product,Integer>>it=contents.entrySet().iterator();it.hasNext();){
            Map.Entry<Product, Integer> entry = it.next();
            if (entry.getKey().getName().equals(p.getName()) ) {
                it.remove();
            }
        }
    }

    public void clearall(){contents.clear();}
    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + contents +
                '}';
    }
    public double getTotalCost() {
        double grandtotal = 0;
        for (Product product : contents.keySet()) {
            grandtotal += product.getPrice().doubleValue();
        }
        return grandtotal;
    }

     public int getCartSize(){

         int sizelist = 0;
         sizelist = contents.size();
       //  System.err.println("list-size"+sizelist);
         return sizelist;
     }
}
