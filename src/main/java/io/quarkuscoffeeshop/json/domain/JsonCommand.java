package io.quarkuscoffeeshop.json.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCommand {

    @JsonProperty(value = "command")
    CoffeeshopCommand coffeeshopCommand;

    public JsonCommand() {
    }

    public JsonCommand(CoffeeshopCommand coffeeshopCommand) {
        this.coffeeshopCommand = coffeeshopCommand;
    }

    public CoffeeshopCommand getCoffeeshopCommand() {
        return coffeeshopCommand;
    }

    public void setCoffeeshopCommand(CoffeeshopCommand coffeeshopCommand) {
        this.coffeeshopCommand = coffeeshopCommand;
    }
}
