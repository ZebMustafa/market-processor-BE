package com.marketing.processor.domain.enumeration;

public enum MessageBrokerEnum {
    BROKER_DESTINATION_TOPIC("/topic");

    private String value;

    MessageBrokerEnum(String mb) {
        this.value = mb;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }
}
