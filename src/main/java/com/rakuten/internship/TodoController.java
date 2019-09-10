package com.rakuten.internship;

import com.rakuten.internship.entity.Request;
import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.entity.TranslateLanguages;
import com.rakuten.internship.service.RequestService;
import com.rakuten.internship.service.TodoService;

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

    private static final String[] ALL_LANGUAGES = {"ja", "en", "zh-CN", "zh-TW", "ko", "es", "ru", "fr", "de"};

    @Autowired
    private RequestService requestService;

    @GetMapping("/")
    public String home(Model model) {
        //model.addAttribute("todos", requestService.findTodos());
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Request request){
        requestService.save(request);
        return "redirect:/viewrequest/"+request.getId();
    }

    @GetMapping("/viewrequest/{id}")
    public String viewrequest(@PathVariable("id") long id, Model model){
        model.addAttribute("req",requestService.findRequestById(id));
        return "tmp";
    }

    @GetMapping("/complete")
    public String complete() {
        return "complete";
    }

    /*
    @PostMapping("/complete")
    public String completeTodo(@ModelAttribute Todo todo) {
        requestService.save(todo);
        translateLanguages.setSourceLanguage(todo.getSourceLanguage());
        translateLanguages.setTargetLanguage(todo.getTargetLanguage());
        return "redirect:/";
    }
    */
}
