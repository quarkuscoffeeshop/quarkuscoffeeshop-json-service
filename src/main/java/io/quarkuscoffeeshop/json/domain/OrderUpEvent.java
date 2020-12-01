package io.quarkuscoffeeshop.json.domain;

import io.quarkuscoffeeshop.domain.EventType;
import io.quarkuscoffeeshop.domain.Item;

import java.time.Instant;

public class OrderUpEvent extends OrderEvent{

    String madeBy;

    public OrderUpEvent() {
    }

    public OrderUpEvent(EventType eventType, String orderId, String id, String name, Item item, Instant timestamp, String madeBy) {
        super(eventType, orderId, id, name, item, timestamp);
        this.madeBy = madeBy;
    }
}
