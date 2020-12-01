package io.quarkuscoffeeshop.json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonEvent {

    @JsonProperty(value = "event")
    CoffeeshopEvent coffeeshopEvent;

    public JsonEvent() {
    }

    public JsonEvent(CoffeeshopEvent coffeeshopEvent) {
        this.coffeeshopEvent = coffeeshopEvent;
    }

    public CoffeeshopEvent getCoffeeshopEvent() {
        return coffeeshopEvent;
    }

    public void setCoffeeshopEvent(CoffeeshopEvent coffeeshopEvent) {
        this.coffeeshopEvent = coffeeshopEvent;
    }
}
