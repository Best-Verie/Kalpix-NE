package com.kaplix.downloader.server.serviceImpl;

import com.kaplix.downloader.server.models.Link;
import com.kaplix.downloader.server.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkServiceImpl {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private WebsiteServiceImpl websiteService;

    // save list of links to database
    public void saveLinks(List<Link> links) {
        for (Link link : links) {
            linkRepository.save(link);
        }
    }

    // get all
    public List<Link> getAll() {
        return linkRepository.findAll();
    }

    // get links by website
    public List<Link> getLinksByWebsite(UUID websiteId) {
        return linkRepository.findByWebsiteId(websiteId);
    }
}
