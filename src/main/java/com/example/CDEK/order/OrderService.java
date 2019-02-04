package com.example.CDEK.order;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.db.tables.LateOrders.*;

@Transactional
@Service
public class OrderService {

    @Autowired
    DSLContext create;

    public void addLateOrder(int orderNumber) {
        create.insertInto(LATE_ORDERS)
                .set(LATE_ORDERS.ID, orderNumber)
                .set(LATE_ORDERS.TIME, DSL.currentTimestamp())
                .execute();
    }

    public List<Order> getAllLateOrders() {
        Result<Record> orders = create.select()
                .from(LATE_ORDERS)
                .fetch();
        List<Order> result = new ArrayList<>();
        orders.forEach(dbOrder -> {
            result.add(new Order((int)dbOrder.get("id"), dbOrder.get("time").toString().split("[.]")[0]));
        });
        return result;
    }
}
