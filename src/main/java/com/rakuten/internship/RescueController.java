package com.rakuten.internship;

import com.rakuten.internship.entity.ChatMessage;
import com.rakuten.internship.entity.Rescue;
import com.rakuten.internship.service.ChatMessageService;
import com.rakuten.internship.service.RescueService;
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
    private final RescueService rescueService;
    private final ChatMessageService chatMessageService;

    public RescueController(final RescueService rescueService, final ChatMessageService chatMessageService) {
        this.rescueService = rescueService;
        this.chatMessageService = chatMessageService;
    }

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
        List<Rescue> rescues = rescueService.findRescuesFilteredByPointSortedByTimeStamp(latitude, longitude);
        model.addAttribute("rescues", rescues);
        return "list";
    }

    @PostMapping("/viewrescue/{rescueId}/sendMessage")
    public String sendMessage(@PathVariable("rescueId") final long rescueId, @ModelAttribute final ChatMessage chatMessage) {
        chatMessage.setRescueId(rescueId);
        chatMessageService.save(chatMessage);

        return "";
    }

    @GetMapping("/viewrescue/{rescueId}/refresh")
    public String refresh(@PathVariable("rescueId") final long rescueId, final Model model) {
        final List<ChatMessage> rescueIdList = chatMessageService.findAllByRescueId(rescueId);
        model.addAttribute("rescueIdList", rescueIdList);

        return "viewrescueChat";
    }
}

