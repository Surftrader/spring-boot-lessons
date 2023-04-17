package ua.com.poseal.springbootlessons.members.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public String toMembers() {
        return "members/members";
    }

    @GetMapping("new_member")
    public String toAddMember() {
        return "members/new_member";
    }

    @PostMapping("new_member/create")
    public String createMember(@RequestParam String firstName,
                               @RequestParam String lastName) {
        System.out.printf("First name: %s, last name: %s", firstName, lastName);
        return "redirect:/members";
    }
}
