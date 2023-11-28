package az.orient.client.homeworkclient.service.impl;

import az.orient.client.homeworkclient.request.UserRequest;
import az.orient.client.homeworkclient.response.Response;
import az.orient.client.homeworkclient.response.UserResponse;
import az.orient.client.homeworkclient.service.UserService;
import az.orient.client.homeworkclient.util.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Utility utility;

    private final ObjectMapper objectMapper;

    @Override
    public Response<List<UserResponse>> getUserList() throws Exception {
        String result = utility.sendGet("http://localhost:9090/homework/application/" + "user/listAll");
        Response<List<UserResponse>> response = objectMapper.readValue(result, new TypeReference<>() {});
        return response;
    }

    @Override
    public Response saveUser(UserRequest userRequest) throws Exception{
        String userRequestJson = objectMapper.writeValueAsString(userRequest);
        String result = utility.sendPost("http://localhost:9090/homework/application/" + "user/save", userRequestJson);
        Response response = objectMapper.readValue(result, new TypeReference<Response>() {});
        return response;
    }

    @Override
    public Response confirmUser(String token) throws Exception{
        System.out.println(token + " in service");
        String result = utility.sendPostString("http://localhost:9090/homework/application/" + "confirm", "token", token);
        Response response = objectMapper.readValue(result, new TypeReference<Response>() {});
        return response;
    }
}
