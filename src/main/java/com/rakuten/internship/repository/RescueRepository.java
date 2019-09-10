package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Rescue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RescueRepository extends JpaRepository<Rescue, Long> {
    Rescue findRescueById(final long id);
}
