package com.rakuten.internship.service;

import com.rakuten.internship.entity.Rescue;
import com.rakuten.internship.repository.RescueRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Rescue> findFilteredRescue(final double latitude, final double longitude, final int distance) {
        return repository.findAll(new Sort(Sort.Direction.DESC, "timeStamp")).stream()
                .filter(rescue -> rescue.getDistance(latitude, longitude) < distance)
                .collect(Collectors.toList());
    }

    public List<Rescue> findFilteredRescues(final double latitude, final double longitude, final List<String> langList, final int distance) {
        return repository.findByLanguageInAndSolved(langList, false, new Sort(Sort.Direction.DESC, "timeStamp")).stream()
                .filter(rescue -> rescue.getDistance(latitude, longitude) < distance)
                .collect(Collectors.toList());
    }
}
