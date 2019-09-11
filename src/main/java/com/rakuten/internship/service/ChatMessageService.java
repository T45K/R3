package com.rakuten.internship.service;

import com.rakuten.internship.entity.ChatMessage;
import com.rakuten.internship.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(final ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessage> findAllByRescueId(final long rescueId) {
        return chatMessageRepository.findAllByRescueId(rescueId);
    }

    public void save(final ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
}
