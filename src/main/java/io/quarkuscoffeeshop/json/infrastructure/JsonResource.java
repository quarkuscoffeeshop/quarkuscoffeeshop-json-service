package io.quarkuscoffeeshop.json.infrastructure;

import io.quarkuscoffeeshop.domain.EventType;
import io.quarkuscoffeeshop.domain.Item;
import io.quarkuscoffeeshop.domain.OrderLineItem;
import io.quarkuscoffeeshop.domain.OrderSource;
import io.quarkuscoffeeshop.json.domain.JsonCommand;
import io.quarkuscoffeeshop.json.domain.JsonEvent;
import io.quarkuscoffeeshop.json.domain.OrderEvent;
import io.quarkuscoffeeshop.json.domain.OrderUpEvent;
import io.quarkuscoffeeshop.json.domain.PlaceOrderCommand;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
/**
 * PlaceOrderCommand
 * OrderInEvent
 * OrderUpEvent
 */
public class JsonResource {

    @GET
    @Path("/OrderUpEvent")
    public JsonEvent orderUpEvent() {
        return new JsonEvent(
                new OrderUpEvent(
                    EventType.BEVERAGE_ORDER_UP,
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    "Mickey",
                    Item.CAPPUCCINO,
                    Instant.now(),
                    "Barista Goofy"));
    }

    @GET
    @Path("/OrderInEvent")
    public JsonEvent orderInEvent() {
        return new JsonEvent(
                new OrderEvent(
                EventType.BEVERAGE_ORDER_IN,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Mickey",
                Item.CAPPUCCINO,
                Instant.now()));
    }


    @GET
    @Path("/PlaceOrderCommand")
    public PlaceOrderCommand placeOrderCommand() {
        return new PlaceOrderCommand(
                UUID.randomUUID().toString(),
                "ATLANTA",
                OrderSource.COUNTER,
                "CoughingCamel",
                new ArrayList<OrderLineItem>(){{
                    add(new OrderLineItem(Item.ESPRESSO, BigDecimal.valueOf(3.50), "Pluto"));
                }},
                new ArrayList<OrderLineItem>(){{
                    add(new OrderLineItem(Item.CAKEPOP, BigDecimal.valueOf(3.75), "Pluto"));
                }},
                BigDecimal.valueOf(7.25)
        );
    }
    /*
    @GET
    @Path("/PlaceOrderCommand")
    public PlaceOrderCommand createOrderCommand() {
        return mockCreateOrderCommand();
    }

    private PlaceOrderCommand mockCreateOrderCommand() {

        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand();
        placeOrderCommand.setOrderSource(OrderSource.DELIVERY);
        placeOrderCommand.setBaristaItems(mockBeverages());
        placeOrderCommand.setKitchenItems(mockKitchenOrder());
        return placeOrderCommand;

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

*/
}
