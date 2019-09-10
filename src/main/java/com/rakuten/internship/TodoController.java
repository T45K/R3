package com.rakuten.internship;

import com.rakuten.internship.entity.Request;
import com.rakuten.internship.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * このクラスは、ウェブアプリケーションの挙動を制御するためのコントローラークラスです。。
 * コントローラーとして使えるように、コードを記入してください。
 */
@Controller
public class TodoController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Request request) {
        requestService.save(request);
        return "redirect:/viewrequest/" + request.getId();
    }

    @GetMapping("/viewrequest/{id}")
    public String viewRequest(@PathVariable("id") long id, Model model) {
        model.addAttribute("request", requestService.findRequestById(id));
        return "viewrequest";
    }
}
