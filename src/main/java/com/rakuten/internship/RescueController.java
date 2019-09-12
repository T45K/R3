package com.rakuten.internship;

import com.rakuten.internship.entity.ChatMessage;
import com.rakuten.internship.entity.Rescue;
import com.rakuten.internship.service.ChatMessageService;
import com.rakuten.internship.service.RescueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                           @RequestParam(value = "latestId", required = false) Long id,
                           Model model) {
        List<Rescue> rescues = rescueService.findRescuesFilteredByPointSortedByTimeStamp(latitude, longitude);
        if (!rescues.isEmpty() && id != null && rescues.get(0).getId() != id) {
            model.addAttribute("newRescueFlag", true);
        }
        model.addAttribute("rescues", rescues);
        return "list";
    }

    @PostMapping("/viewrescue/{rescueId}/{userType}/sendMessage")
    public ResponseEntity sendMessage(@PathVariable("rescueId") final long rescueId,
                                      @PathVariable("userType") final String userType,
                                      @ModelAttribute final ChatMessage chatMessage) {
        if ("rescuee".equals(userType)) {
            chatMessage.setRescuee(true);
        } else if ("rescuer".equals(userType)) {
            chatMessage.setRescuee(false);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        chatMessage.setRescueId(rescueId);
        chatMessageService.save(chatMessage);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/viewrescue/{rescueId}/refresh")
    public String refresh(@PathVariable("rescueId") final long rescueId, final Model model) {
        final List<ChatMessage> chatList = chatMessageService.findAllByRescueId(rescueId);
        model.addAttribute("chatList", chatList);

        return "viewRescueChat";
    }
}

