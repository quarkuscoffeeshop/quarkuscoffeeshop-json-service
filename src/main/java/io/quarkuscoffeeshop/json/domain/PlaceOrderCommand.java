package io.quarkuscoffeeshop.json.domain;

import io.quarkuscoffeeshop.domain.CommandType;
import io.quarkuscoffeeshop.json.domain.*;

import java.math.BigDecimal;
import java.util.List;

public class PlaceOrderCommand implements CoffeeshopCommand{

    private final MessageType messageType = MessageType.COMMAND;
    private final CommandType commandType = CommandType.PLACE_ORDER;
    private String id;
    private String storeId;
    private String rewardsId;
    private OrderSource orderSource;
    List<OrderLineItem> baristaItems;
    List<OrderLineItem> kitchenItems;
    private BigDecimal total;

    public PlaceOrderCommand() {
    }

    public PlaceOrderCommand(String id, String storeId, OrderSource orderSource, String rewardsId, List<OrderLineItem> baristaItems, List<OrderLineItem> kitchenItems, BigDecimal total) {
        this.id = id;
        this.baristaItems = baristaItems;
        this.kitchenItems = kitchenItems;
        this.storeId = storeId;
        this.orderSource = orderSource;
        this.rewardsId = rewardsId;
        this.total = total;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public List<OrderLineItem> getBaristaItems() {
        return baristaItems;
    }

    public void setBaristaItems(List<OrderLineItem> baristaItems) {
        this.baristaItems = baristaItems;
    }

    public List<OrderLineItem> getKitchenItems() {
        return kitchenItems;
    }

    public void setKitchenItems(List<OrderLineItem> kitchenItems) {
        this.kitchenItems = kitchenItems;
    }

    public String getId() {
        return id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public OrderSource getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(OrderSource orderSource) {
        this.orderSource = orderSource;
    }

    public String getRewardsId() {
        return rewardsId;
    }

    public void setRewardsId(String rewardsId) {
        this.rewardsId = rewardsId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
