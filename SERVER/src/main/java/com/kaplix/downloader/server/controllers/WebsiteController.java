package com.kaplix.downloader.server.controllers;

import com.kaplix.downloader.server.dtos.UrlRequest;
import com.kaplix.downloader.server.models.Website;
import com.kaplix.downloader.server.serviceImpl.WebsiteExtractorServiceImpl;
import com.kaplix.downloader.server.serviceImpl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/websites")
public class WebsiteController {

    @Autowired
    private WebsiteServiceImpl patientService;

    @Autowired
    private WebsiteExtractorServiceImpl websiteExtractorService;

    @GetMapping("/get-all")
    public List<Website> getAll() {
        return patientService.findAll();
    }
    @GetMapping("/{id}")
    public Website findById(@PathVariable UUID id) {
        return patientService.findById(id);
    }

    @PostMapping("/url")
    public ResponseEntity<?> create(@RequestBody UrlRequest urlRequest) {

        websiteExtractorService.extractWebsite(urlRequest);

        return ResponseEntity.ok("Website saved");
    }

    //SAVE
    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody Website website) {
        patientService.create(website);
        return ResponseEntity.ok("Website saved");
    }



}
