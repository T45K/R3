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

import java.util.Collections;
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

    @GetMapping("/viewrescue/{id}/{userType}")
    public String viewRescue(@PathVariable("id") long id,
                             @PathVariable("userType") final String userType,
                             final Model model) {
        if (!("rescuer".equals(userType) || "rescuee".equals(userType))) {
            return "error";
        }

        model.addAttribute("rescue", rescueService.findRescueById(id));
        model.addAttribute("userType", userType);
        return "viewrescue";
    }

    @GetMapping("/list/{latitude}/{longitude}")
    public String viewList(@PathVariable("latitude") float latitude,
                           @PathVariable("longitude") float longitude,
                           @RequestParam(value = "latestId", required = false) Long id,
                           @RequestParam(value = "lang", required = false) List<String> langList,
                           @RequestParam(value = "distance", required = false, defaultValue = "10") int distance,
                           Model model) {
        if (langList == null) {
            langList = Collections.emptyList();
        }

        List<Rescue> rescues = rescueService.findFilteredRescues(latitude, longitude, langList, distance);
        if (!rescues.isEmpty() && id != null && rescues.get(0).getId() != id) {
            model.addAttribute("newRescueFlag", true);
        }
        model.addAttribute("rescues", rescues);
        model.addAttribute("langList", langList);
        return "list";
    }

    @PostMapping("/viewrescue/{rescueId}/sendMessage/{userType}")
    public ResponseEntity sendMessage(@PathVariable("rescueId") final long rescueId,
                                      @PathVariable("userType") final String userType,
                                      @ModelAttribute final ChatMessage chatMessage) {
        if ("rescuee".equals(userType)) {
            chatMessage.setRescuer(true);
        } else if ("rescuer".equals(userType)) {
            chatMessage.setRescuer(false);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        chatMessage.setRescueId(rescueId);
        chatMessageService.save(chatMessage);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/viewrescue/{rescueId}/refresh/{userType}")
    public String refresh(@PathVariable("rescueId") final long rescueId,
                          @PathVariable("userType") final String userType,
                          final Model model) {
        if (!("rescuer".equals(userType) || "rescuee".equals(userType))) {
            return "error";
        }

        final List<ChatMessage> chatList = chatMessageService.findAllByRescueId(rescueId);
        model.addAttribute("chatList", chatList);
        model.addAttribute("rescuerFlag", "rescuer".equals(userType));

        return "viewRescueChat";
    }
}

