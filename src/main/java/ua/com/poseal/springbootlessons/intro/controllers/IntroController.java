package ua.com.poseal.springbootlessons.intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("intro")
public class IntroController {

    @GetMapping("index")
    public String index() {
        return "intro/index";
    }
    @GetMapping("about")
    public String about() {
        return "intro/about";
    }
    @ResponseBody
    @GetMapping("users")
    public String users(@RequestParam long id) {
        return String.format("user id = %s", id);
    }
    @ResponseBody
    @GetMapping("user/{id:\\d+}")
    public String userById(@PathVariable("id") long id) {
        return String.format("user id = %s", id);
    }

    @ResponseBody
    @RequestMapping(
            value = {"user", "user/{id:\\d+}/name/{name}"},
            params = {"id", "name"},
            method = RequestMethod.GET)
    public String userByIdAndName(
            @PathVariable long id,
            @PathVariable String name) {
        return String.format("user name = %s, id = %s", name, id);
    }
}
