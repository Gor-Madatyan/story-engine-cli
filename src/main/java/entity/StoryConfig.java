package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StoryConfig(
        @JsonProperty(value = "entry_point", required = true)
        String entryPoint
) {
}
