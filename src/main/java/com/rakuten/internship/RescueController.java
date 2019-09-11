package com.rakuten.internship;

import com.rakuten.internship.entity.Rescue;
import com.rakuten.internship.service.RescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * このクラスは、ウェブアプリケーションの挙動を制御するためのコントローラークラスです。。
 * コントローラーとして使えるように、コードを記入してください。
 */
@Controller
public class RescueController {
    @Autowired
    private RescueService rescueService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Rescue rescue) {
        rescueService.save(rescue);
        return "redirect:/viewrescue/" + rescue.getId();
    }

    @GetMapping("/viewrescue/{id}")
    public String viewRescue(@PathVariable("id") long id, Model model) {
        model.addAttribute("rescue", rescueService.findRescueById(id));
        return "viewrescue";
    }

    @GetMapping("/list/{latitude}/{longitude}")
    public String viewList(@PathVariable("latitude") float latitude,
                           @PathVariable("longitude") float longitude,
                           Model model) {
        List<Rescue> rescues = rescueService.findAllRescuesFilteredByPoint(latitude, longitude);
        model.addAttribute("rescues", rescues);
        return "list";
    }
}
