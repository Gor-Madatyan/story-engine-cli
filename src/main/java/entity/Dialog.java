package entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public record Dialog(
        @JsonAlias("desc")
        @JsonProperty(value = "description", required = true)
        String description,
        @JsonProperty(value = "choices", required = true)
        String[] choices
) {

        @Override
        public String[] choices() {
                return choices.clone();
        }

        @Override
        public String toString() {
                return description + "\n" + Arrays.toString(choices);
        }
}
