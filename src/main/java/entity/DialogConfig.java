package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.HashMap;

public record DialogConfig(
        @JacksonXmlProperty(localName = "case")
        @JacksonXmlElementWrapper(useWrapping = false)
        Case[] cases
) {
    public record Case(
            @JacksonXmlProperty(isAttribute = true, localName = "choice")
            @JsonProperty(required = true)
            String choice,

            @JacksonXmlProperty(isAttribute = true, localName = "point")
            @JsonProperty(required = true)
            String point
    ) {

    }

    @Override
    public Case[] cases() {
        return cases == null ? new Case[0] : cases.clone();
    }
    public HashMap<String, String> casesAsMap(){
        HashMap<String, String> result = new HashMap<>();

        for(int i = 0; i < cases.length; i++){
            result.put(cases[i].choice(), cases[i].point());
        }

        return result;
    }
}
