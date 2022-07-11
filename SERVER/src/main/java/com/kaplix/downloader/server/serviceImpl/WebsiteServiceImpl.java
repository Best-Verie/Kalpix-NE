package com.kaplix.downloader.server.serviceImpl;

import com.kaplix.downloader.server.exceptions.PatientNotFoundException;
import com.kaplix.downloader.server.models.Website;
import com.kaplix.downloader.server.repositories.WebsiteRepository;
import com.kaplix.downloader.server.services.WebsiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WebsiteServiceImpl implements WebsiteServices {

    @Autowired
    private WebsiteRepository websiteRepository;

    @Override
    public List<Website> findAll() {
        return websiteRepository.findAll();
    }

    public Website checkExistence(UUID id) {
        Optional<Website> patientFound = websiteRepository.findById(id);

        if(!patientFound.isPresent()) throw new PatientNotFoundException("Patient with id " + id+ " is not found");

        return patientFound.get();
    }

    // get by websiteName
    public Website findByWebsiteName(String websiteName) {
        return websiteRepository.findByWebsiteName(websiteName);
    }

    @Override
    public Website findById(UUID id) {
        return checkExistence(id);
    }

    @Override
    public Website create(Website website) {
        System.out.println("website: " + website.toString());

        Website websiteToSave = new Website(
                website.getWebsiteName(),
                website.getDownloadStartTime(),
                website.getDownloadEndTime(),
                website.getTotalElapsedTime(),
                website.getTotalDownloadedFilesKilobytes()
        );

        Website websiteSaved = websiteRepository.save(websiteToSave);


        return websiteSaved;
    }

    @Override
    public Website delete(UUID id) {
        return null;
    }


}
