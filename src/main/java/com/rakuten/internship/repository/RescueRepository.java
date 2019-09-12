package com.rakuten.internship.repository;

import com.rakuten.internship.entity.Rescue;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RescueRepository extends JpaRepository<Rescue, Long> {
    Rescue findRescueById(final long id);

    List<Rescue> findByLanguageInAndSolved(final List<String> langList, final boolean isSolved, final Sort sort);
}
