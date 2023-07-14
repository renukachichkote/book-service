package com.example.bookservice.book;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class BooleanValueDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        log.debug("current boolean attribute : {} ",  jsonParser.getCurrentName());
        return jsonParser.getBooleanValue();
    }
}
