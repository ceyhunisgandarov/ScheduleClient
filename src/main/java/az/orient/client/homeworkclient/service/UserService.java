package az.orient.client.homeworkclient.service;

import az.orient.client.homeworkclient.request.UserRequest;
import az.orient.client.homeworkclient.response.Response;
import az.orient.client.homeworkclient.response.UserResponse;

import java.util.List;

public interface UserService {

    Response<List<UserResponse>> getUserList() throws Exception;

    Response saveUser(UserRequest userRequest) throws Exception;

    Response confirmUser(String token) throws Exception;
}
