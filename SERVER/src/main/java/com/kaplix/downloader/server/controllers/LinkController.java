package com.kaplix.downloader.server.controllers;

import com.kaplix.downloader.server.dtos.UrlRequest;
import com.kaplix.downloader.server.models.Link;
import com.kaplix.downloader.server.models.Website;
import com.kaplix.downloader.server.serviceImpl.LinkServiceImpl;
import com.kaplix.downloader.server.serviceImpl.WebsiteExtractorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/websites-links")
public class LinkController {

    @Autowired
    private LinkServiceImpl linkService;

    @Autowired
    private WebsiteExtractorServiceImpl websiteExtractorService;

    @GetMapping("/get-all")
    public List<Link> getAll() {
        return linkService.getAll();
    }
    @GetMapping("/{id}")
    public Website findById(@PathVariable UUID id) {
        return null;
    }

    @PostMapping("/save-links")
    public ResponseEntity<?> create(@RequestBody UrlRequest urlRequest) {


        return ResponseEntity.created(null).build();
    }



}
