package org.hua.dit.dsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
    //Here we map each of the locations of the site, to their corresponding html file.
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
}
