package org.hua.dit.dsproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class TemplateController {
    //Here we map each of the locations of the site, to their corresponding html file.


    @GetMapping(path = "modifyPet")
    public String getmodifyView() {
        return "modifyPet";
    }

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("vet")
    public String getVetView() {
        return "vet";
    }

    @GetMapping("citizen")
    public String getCitizenView() {
        return "citizen";
    }


    @GetMapping("employee")
    public String getEmployeeView() {
        return "employee";
    }


    @GetMapping("admin")
    public String getAdminView() {
        return "admin";
    }

    @GetMapping("register")
    public String getRegisterView() {
        return "register";
    }

    @GetMapping("newpet")
    public String getNewPetView() {
        return "newpet";
    }

    @GetMapping("modify")
    public String getModifyView() {
        return "modify";
    }

    @GetMapping("delete")
    public String getDeleteView() {
        return "delete";
    }

    //A template where we redirect based on the role
    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {

        String role = authResult.getAuthorities().toString();

        if (role.contains("ROLE_ADMIN")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin"));
        } else if (role.contains("ROLE_CITIZEN")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/citizen"));
        } else if (role.contains("ROLE_VET")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/vet"));
        } else if (role.contains("ROLE_EMPLOYEE")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/employee"));
        }

    }
}
