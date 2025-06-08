/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.drbhicom.announcementservice.repository.elasticsearch;

import com.drbhicom.announcementservice.entity.Announcement;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author siatping.so
 */
public interface AnnouncementSearchRepository extends ElasticsearchRepository<Announcement, Long> {
    List<Announcement> findByTitleContainingOrContentContaining(String title, String content);
}
