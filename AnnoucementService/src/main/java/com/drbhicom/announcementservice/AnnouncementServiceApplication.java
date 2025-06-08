/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.drbhicom.announcementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 *
 * @author siatping.so
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.drbhicom.announcementservice.repository.elasticsearch")
@EnableJpaRepositories(basePackages = "com.drbhicom.announcementservice.repository.jpa")

public class AnnouncementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnouncementServiceApplication.class, args);
    }
}
