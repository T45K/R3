package com.rakuten.internship;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.rakuten.internship.entity.Todo;
import com.rakuten.internship.entity.TranslateLanguages;
import com.rakuten.internship.service.TodoService;

import org.apache.http.HttpException;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * このクラスは、ウェブアプリケーションの挙動を制御するためのコントローラークラスです。。
 * コントローラーとして使えるように、コードを記入してください。
 */
@Controller
public class TodoController {

    private static final String[] ALL_LANGUAGES = {"ja", "en", "zh-CN", "zh-TW", "ko", "es", "ru", "fr", "de"};

    @Autowired
    private TodoService todoService;

    @Autowired
    private TranslateLanguages translateLanguages;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todoService.findTodos());
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("languages", ALL_LANGUAGES);
        model.addAttribute("sourceLanguage", translateLanguages.getSourceLanguage());
        model.addAttribute("targetLanguage", translateLanguages.getTargetLanguage());
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Todo todo, RedirectAttributes attrs) throws JsonSyntaxException, ParseException, IOException, HttpException {
        todo.setTranslatedText(todoService.translate2(todo));
        attrs.addFlashAttribute("todo", todo);
        return "redirect:/complete";
    }

    @GetMapping("/complete")
    public String complete() {
        return "complete";
    }

    @PostMapping("/complete")
    public String completeTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        translateLanguages.setSourceLanguage(todo.getSourceLanguage());
        translateLanguages.setTargetLanguage(todo.getTargetLanguage());
        return "redirect:/";
    }
}
