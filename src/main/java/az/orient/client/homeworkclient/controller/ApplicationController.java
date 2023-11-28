package az.orient.client.homeworkclient.controller;

import az.orient.client.homeworkclient.request.UserRequest;
import az.orient.client.homeworkclient.response.Response;
import az.orient.client.homeworkclient.response.UserResponse;
import az.orient.client.homeworkclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ApplicationController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @GetMapping("/listUsers")
    public ModelAndView listUsers() {
        ModelAndView model = new ModelAndView("listUser");
        try {
            Response<List<UserResponse>> response = userService.getUserList();
            if (response.getStatus().getCode() == 1) {
                model.addObject("users", response.getT());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    @GetMapping("/addUser")
    public ModelAndView addUser(@RequestParam(value = "msg", required = false) String msg) {
        ModelAndView model = new ModelAndView("addUser");
        model.addObject("msg", msg);
        return model;
    }

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView saveUser(UserRequest userRequest) {
        RedirectView redirectView = null;
        try {
            Response response = userService.saveUser(userRequest);
            if (response.getStatus().getCode() == 1) {
                redirectView = new RedirectView("/homework/application/client/listUsers");
            } else {
                redirectView = new RedirectView("/homework/application/client/addUser");
                if (response.getStatus().getCode()==104) {
                    redirectView.addStaticAttribute("msg", "Email already in use");
                } else {
                    redirectView.addStaticAttribute("msg", "invalid add process");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return redirectView;
    }

    @GetMapping("/confirm-user-email/{token}")
    public ModelAndView confirmUserPage (@PathVariable("token") String token) {

        ModelAndView model = new ModelAndView("confirmUserPage");

        model.addObject("token", token);

        return model;
    }


    @PostMapping(value = "/confirmUser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView confirmUser (String token) {
        RedirectView redirectView = null;
        System.out.println(token);
        try {
            Response response = userService.confirmUser(token);
            if (response.getStatus().getCode() == 1) {
                System.out.println(response.getStatus().getCode());
                redirectView = new RedirectView("/homework/application/client/confirmedPage");
                redirectView.addStaticAttribute("msg", "Email confirmed successfully");
            } else {
                redirectView = new RedirectView("/homework/application/client/confirmedPage");
                redirectView.addStaticAttribute("msg", "Invalid confirmed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return redirectView;
    }

    @GetMapping("/confirmedPage")
    public ModelAndView confirmedPage (@RequestParam(value = "msg", required = false) String msg) {

        ModelAndView model = new ModelAndView("confirmedPage");

        model.addObject("msg", msg);

        return model;
    }

}
