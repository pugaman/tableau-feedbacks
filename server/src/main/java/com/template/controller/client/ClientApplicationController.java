package com.template.controller.client;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pavel on 30.03.2017.
 */
@Profile("production")
@Controller
public class ClientApplicationController {

    @RequestMapping("/")
    public String getClientApplication(){
        return "index.html";
    }
}
