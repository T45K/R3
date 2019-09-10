package com.rakuten.internship.service;

import com.rakuten.internship.entity.Request;
import com.rakuten.internship.repository.RequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestService {
    private final RequestRepository repository;

    public RequestService(final RequestRepository repository) {
        this.repository = repository;
    }

    public List<Request> findAllRequests() {
        return repository.findAll();
    }

    public Request findRequestById(final long id) {
        return repository.findRequestById(id);
    }

    public void save(final Request request) {
        repository.save(request);
    }
}
