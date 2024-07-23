package com.cbt.cbtjul24template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController
{
    @Autowired //Dependency Injection
    CredentialRepository credentialRepository;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model)
    {
        Credential credential;
        if(credentialRepository.findById(username).isPresent())
        {
            credential = credentialRepository.findById(username).get();
            if(credential.getPassword().equals(password))
            {
                model.addAttribute("username", username);
                return "dashboard";
            }
            else
            {
             return "loginfail";
            }
        }
        else
        {
            return "loginfail";
        }

    }

    @GetMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Model model)
    {
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        model.addAttribute("username", username);


        return "dashboard";
    }

}
