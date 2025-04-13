package com.decode.decode.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
public class WeatherResponse {
    private Current current;

    @Getter
    @Setter
    public static class Current {
        private int temperature;
        @JsonProperty("")
        private List<String> weatherDescriptions;
        private int feelslike;
    }
}

