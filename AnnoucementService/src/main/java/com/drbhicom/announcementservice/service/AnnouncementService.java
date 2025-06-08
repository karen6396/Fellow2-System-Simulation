/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.drbhicom.announcementservice.service;

import com.drbhicom.announcementservice.entity.Announcement;
import com.drbhicom.announcementservice.repository.jpa.AnnouncementRepository;
import com.drbhicom.announcementservice.repository.elasticsearch.AnnouncementSearchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siatping.so
 */
@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository repository;
    @Autowired
    private AnnouncementSearchRepository searchRepository;

    public List<Announcement> getAll() { return repository.findAll(); }
    public Announcement getById(Long id) { return repository.findById(id).orElse(null); }
    public Announcement save(Announcement a) {
        Announcement saved = repository.save(a);
        searchRepository.save(saved);
        return saved;
    }
    public Announcement update(Long id, Announcement a) {
        a.setId(id);
        Announcement updated = repository.save(a);
        searchRepository.save(updated);
        return updated;
    }
    public void delete(Long id) {
        repository.deleteById(id);
        searchRepository.deleteById(id);
    }
    public List<Announcement> search(String keyword) {
        return searchRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}