package com.example.salariati.electra;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Locale;

public class ADeserializer extends JsonDeserializer<Person> {
    @Override public Person deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode node = mapper.readTree(p);
        String value = node.get("functie").get("numeFunctie").asText().toUpperCase(Locale.ROOT);

        ListaFunctii functie = ListaFunctii.valueOf(value);

        switch (functie) {
            case INGINER: return mapper.treeToValue(node, Inginer.class);
            case ELECTRONIST: return mapper.treeToValue(node, Electronist.class);
            case OPERATOR: return mapper.treeToValue(node, Operator.class);
            default: return null;
        }
    }
}
