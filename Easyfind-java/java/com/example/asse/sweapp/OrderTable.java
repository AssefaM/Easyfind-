package com.example.asse.sweapp;

import android.provider.BaseColumns;

/**
 * Created by user on 6/2/2016.
 */
public class OrderTable {

    public OrderTable() {

    }

    public static abstract class Orderinfo implements BaseColumns {

        public static final String ORDER_NAME = "order_name";
        public static final String ITEM_PRICE = "item_price";
        public static final String DATABASE_NAME = "orders_info";
        public static final String TABLE_NAME =  "place_order";

    }
}
