/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.drbhicom.announcementservice.controller;

import com.drbhicom.announcementservice.entity.Announcement;
import com.drbhicom.announcementservice.service.AnnouncementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siatping.so
 */
@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @GetMapping
    public List<Announcement> getAll() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    public Announcement getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Announcement create(@RequestBody Announcement a) { return service.save(a); }

    @PutMapping("/{id}")
    public Announcement update(@PathVariable Long id, @RequestBody Announcement a) {
        return service.update(id, a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/search")
    public List<Announcement> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
