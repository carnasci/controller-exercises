package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
        public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
        public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="form")
    public String helloForm() {
        return "form";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "world";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        if (l.equals("french")) {
            greeting = "Bonjour";
        }
        if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        if (l.equals("spanish")) {
            greeting = "Hola";
        }
        if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;

    }

}
