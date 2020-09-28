package io.quarkuscoffeeshop.domain.json.infrastructure;

import io.quarkuscoffeeshop.domain.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
public class JsonResource {

    @GET
    @Path("/NewOrderEvent")
    public NewOrderEvent createOrderCommand() {
        return mockCreateOrderCommand();
    }

    private NewOrderEvent mockCreateOrderCommand() {

        NewOrderEvent newOrderEvent = new NewOrderEvent();
        newOrderEvent.setOrderSource(OrderSource.DELIVERY);
        newOrderEvent.setBaristaItems(mockBeverages());
        newOrderEvent.setKitchenItems(mockKitchenOrder());
        return newOrderEvent;

    }

    @GET
    @Path("/InQueueUpdate")
    public InQueueUpdate mockInQueueUpdate() {

        return new InQueueUpdate(
                new OrderInEvent(EventType.BEVERAGE_ORDER_IN,
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        "Winnie",
                        Item.CAKEPOP));
    }

    @GET
    @Path("/LineItem")
    public LineItem mockLineItem() {

        return new LineItem(Item.CAKEPOP, "Winnie");
    }

    @GET
    @Path("/OrderInEvent")
    public OrderInEvent mockOrderInEvent() {
        return new OrderInEvent(EventType.BEVERAGE_ORDER_IN,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Winnie",
                Item.CAKEPOP);
    }

    @GET
    @Path("/OrderUpEvent")
    public OrderUpEvent mockOrderUpEvent() {
        return new OrderUpEvent(EventType.BEVERAGE_ORDER_UP,
                UUID.randomUUID().toString(),
                "Winnie",
                Item.CAKEPOP,
                UUID.randomUUID().toString(),
                "Barista Joe");
    }

    @GET
    @Path("/OrderReadyUpdate")
    public OrderReadyUpdate mockOrderReadyUpdate() {
        return new OrderReadyUpdate(new OrderUpEvent(EventType.BEVERAGE_ORDER_UP,
                UUID.randomUUID().toString(),
                "Winnie",
                Item.CAKEPOP,
                UUID.randomUUID().toString(),
                "Barista Joe"));
    }

    private HashMap<String, MenuItem> mockKitchenOrder() {
        return new HashMap<>(){{
            put("Mickey", new MenuItem(Item.CAKEPOP, BigDecimal.valueOf(3.50)));
            put("Miniie", new MenuItem(Item.MUFFIN, BigDecimal.valueOf(3)));
        }};
    }

    private HashMap<String,MenuItem> mockBeverages() {
        return new HashMap<>(){{
            put("Mickey", new MenuItem(Item.COFFEE_BLACK, BigDecimal.valueOf(2.50)));
            put("Miniie", new MenuItem(Item.ESPRESSO, BigDecimal.valueOf(3)));
        }};
    }

}
