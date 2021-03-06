/*
 * This file is generated by jOOQ.
 */
package com.example.db;


import com.example.db.tables.LateOrders;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index LATE_ORDERS_PKEY = Indexes0.LATE_ORDERS_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index LATE_ORDERS_PKEY = Internal.createIndex("late_orders_pkey", LateOrders.LATE_ORDERS, new OrderField[] { LateOrders.LATE_ORDERS.ID }, true);
    }
}
