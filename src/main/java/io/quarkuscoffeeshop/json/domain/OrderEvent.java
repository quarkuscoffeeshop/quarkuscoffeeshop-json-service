package io.quarkuscoffeeshop.json.domain;

import io.quarkuscoffeeshop.domain.EventType;
import io.quarkuscoffeeshop.domain.Item;

import java.time.Instant;

public class OrderEvent implements CoffeeshopEvent{

    EventType eventType;
    String orderId;
    String id;
    String name;
    Item item;
    Instant timestamp;

    public OrderEvent() {
    }

    public OrderEvent(EventType eventType, String orderId, String id, String name, Item item, Instant timestamp) {
        this.eventType = eventType;
        this.orderId = orderId;
        this.id = id;
        this.name = name;
        this.item = item;
        this.timestamp = timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
