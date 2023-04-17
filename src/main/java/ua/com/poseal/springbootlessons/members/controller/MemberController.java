package ua.com.poseal.springbootlessons.members.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.poseal.springbootlessons.members.models.Member;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
    private static final List<Member> members = new ArrayList<>();

    @GetMapping
    public String toMembers(Model model) {
        model.addAttribute("members", members);
        return "members/members";
    }

    @GetMapping("new_member")
    public String toAddMember() {
        return "members/new_member";
    }

    @PostMapping("new_member/create")
    public String createMember(@RequestParam String firstName,
                               @RequestParam String lastName,
                               Model model) {
//        System.out.printf("First name: %s, last name: %s \n", firstName, lastName);
        members.add(new Member(firstName, lastName));
        return "redirect:/members";
    }
}
