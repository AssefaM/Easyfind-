package com.example.asse.sweapp;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;

import java.util.List;
import java.util.Vector;

/**
 * Created by user on 5/23/2016.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
    private static List<Product> catalog;
    private static List<Product> cart;


    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Shrimp Pizza", res
                            .getDrawable(R.drawable.shrimp_pizza),
                    "Fresh shrimp and potatoes and bulgogi a spicy" +
                            " dish cooked in Saint-Germain and fresh pizza", 29.99));
            catalog.add(new Product("Pizza a live Buddha", res
                    .getDrawable(R.drawable.pizzaalivingbuddha),
                    "Meat alive, flesh is baked in the oven immediately order " +
                            "not be rough draft type real vital Gwangyang Bulgogi", 24.99));
            catalog.add(new Product("Hawaiian Shrimp Pizza", res
                    .getDrawable(R.drawable.hawaiianshrimpizza),
                    "Sweet fresh shrimp and mix as a sweet chili sauce " +
                            "Exquisite harmony of sweet pineapple!", 14.99));
            catalog.add(new Product("Derry Pizza", res
                    .getDrawable(R.drawable.derrypizza),
                    "Teriyaki sauce, fresh sour cream sauce and strong hint, " +
                            "garnish chicken breasts a container" +
                            "A taste is excellent, squash, accompanied by his " +
                            "fine young and anyone could enjoy pizza", 9.99));
            catalog.add(new Product("Tender Chicken Pizza", res
                    .getDrawable(R.drawable.tenderchickenpizza),
                    "Sweet potato mousse and cheddar cheese, sweet and hot" +
                    "Play them with the tender chicken strips and pizza", 9.99));
            catalog.add(new Product("Italian Cheese Pizza", res
                    .getDrawable(R.drawable.italiancheesepizza),
                    "Stick to more soft and savory cheese into a whole" +
                            " load of pizza", 9.99));

        }

        return catalog;
    }
    public static List<Product> getCart() {
        if(cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }
}
