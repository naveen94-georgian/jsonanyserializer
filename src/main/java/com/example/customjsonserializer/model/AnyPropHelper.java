package com.example.customjsonserializer.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class AnyPropHelper {
    private Map<String, Object> otherAttributes;

    @JsonAnySetter
    public void setOtherAttributes(final String name, final Object value) {
        if(otherAttributes == null) {
            otherAttributes = new HashMap<>();
        }
        otherAttributes.put(name, value);
    }

    @JsonAnyGetter
    private Map<String, Object> getOtherAttributes() {
        return otherAttributes;
    }
}
