package rca.ne.client.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import rca.ne.client.dtos.GetWebsite;
import rca.ne.client.dtos.webSiteDto;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/website")
public class WebSiteController {

    @GetMapping
    public String index() {
        return "ViewAllWebsites";
    }


    @GetMapping("view-all-websites")
    public String viewAllUsers(Model model, HttpServletRequest request) {
        //get all users
        RestTemplate restTemplate = new RestTemplate();
        String URL = "http://localhost:8000/api/v1/websites/get-all";
        GetWebsite[] websites = restTemplate.getForObject(URL, GetWebsite[].class);
        model.addAttribute("websites", websites);

        return "ViewAllWebsites";
    }

    @GetMapping("/register")
    public String register() {
        return "RegisterWebpage";
    }

    //post mapping on register new webpage
    @PostMapping("/registerWebpage")
    public String register(String urlName){
        System.out.println(urlName);
        webSiteDto dto = new webSiteDto(urlName);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> responseEntity = restTemplate.postForEntity("http://localhost:8000/api/v1/websites/url",dto,GetWebsite.class);
        return "redirect:/view-all-websites";
    }


}


