package com.rakuten.internship.service;

import com.rakuten.internship.entity.Rescue;
import com.rakuten.internship.repository.RescueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RescueService {
    private final RescueRepository repository;

    public RescueService(final RescueRepository repository) {
        this.repository = repository;
    }

    public List<Rescue> findAllRescues() {
        return repository.findAll();
    }

    public Rescue findRescueById(final long id) {
        return repository.findRescueById(id);
    }

    public void save(final Rescue rescue) {
        repository.save(rescue);
    }
}
