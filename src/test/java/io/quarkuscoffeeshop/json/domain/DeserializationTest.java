package io.quarkuscoffeeshop.json.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkuscoffeeshop.domain.EventType;
import io.quarkuscoffeeshop.domain.Item;
import io.quarkuscoffeeshop.domain.OrderLineItem;
import io.quarkuscoffeeshop.domain.OrderSource;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeserializationTest {

    @Test
    public void testDeserializingPlaceOrderCommandJson() {

        JsonCommand jsonCommand = new JsonCommand(new PlaceOrderCommand(
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
        ));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(jsonCommand));
            JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(jsonCommand));
            JsonNode commandNode = jsonNode.get("command");
            assertNotNull(commandNode);
            JsonNode eventNode = jsonNode.get("event");
            assertNull(eventNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeserializingOrderInEvent() {

        JsonEvent jsonEvent = new JsonEvent(new OrderEvent(
                EventType.BEVERAGE_ORDER_IN,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Minnie",
                Item.ESPRESSO,
                Instant.now()
        ));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(jsonEvent));
            JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(jsonEvent));
            JsonNode commandNode = jsonNode.get("command");
            assertNull(commandNode);
            JsonNode eventNode = jsonNode.get("event");
            assertNotNull(eventNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
