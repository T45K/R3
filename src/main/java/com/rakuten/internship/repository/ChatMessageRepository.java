package com.rakuten.internship.repository;

import com.rakuten.internship.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAllByRescueId(final long rescueId);
}
