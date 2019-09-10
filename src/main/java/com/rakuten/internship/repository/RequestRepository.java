package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
