package az.orient.client.homeworkclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response <T> {

    @JsonProperty(value = "listResponse")
    private T t;
    private ResponseStatus status;

}