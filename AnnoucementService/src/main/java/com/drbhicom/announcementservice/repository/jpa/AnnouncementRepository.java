/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.drbhicom.announcementservice.repository.jpa;

import com.drbhicom.announcementservice.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author siatping.so
 */
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
