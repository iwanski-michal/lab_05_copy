package com.pjatk.bank;

import java.util.HashMap;

public class FunWithHashMaps {

    public static void main(String[] ars){

        Product chleb = new Product("001", "Chleb", 2);
        Product szynka  = new Product("002", "Szynka", 5);
        Product skarpety = new Product("003", "Skarpety", 10);

        HashMap<String,Product> productsByCode = new HashMap<>();

        productsByCode.put(chleb.productKey, chleb);
        productsByCode.put(szynka.productKey, szynka);
        productsByCode.put(skarpety.productKey, skarpety);

        Product productWithCode002 = productsByCode.get("002");

        System.out.println("Product z kodem 002 to " + productWithCode002.name);

        System.out.println("\n========== Wszystkie produkty ============\n");
        for (String key : productsByCode.keySet()){
            Product p = productsByCode.get(key);
            System.out.println("Product z kodem " + key + " to " + p.name);
        }

    }



}

class Product {
    String productKey;
    String name;
    double price;

    public Product(String productKey, String name, double price) {
        this.name = name;
        this.price = price;
        this.productKey = productKey;
    }
}

