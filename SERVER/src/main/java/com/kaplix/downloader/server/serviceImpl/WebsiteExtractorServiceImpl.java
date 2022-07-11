package com.kaplix.downloader.server.serviceImpl;

import com.kaplix.downloader.server.Properties.WebsiteExtractor;
import com.kaplix.downloader.server.dtos.UrlRequest;
import com.kaplix.downloader.server.models.Link;
import com.kaplix.downloader.server.models.Website;
import com.kaplix.downloader.server.repositories.LinkRepository;
import com.kaplix.downloader.server.repositories.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class WebsiteExtractorServiceImpl {

    @Autowired
    private LinkServiceImpl linkService;

    @Autowired
    private WebsiteServiceImpl websiteService;

    @Autowired
    private WebsiteRepository websiteRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private WebsiteExtractor extractor;

    public void extractWebsite(UrlRequest urlRequest) {
        // TODO

        // download home page

        try{
            extractor.downloadWebsite(urlRequest.getUrlName());

            WebsiteServiceImpl websiteService = new WebsiteServiceImpl();
            LinkServiceImpl linkService = new LinkServiceImpl();

            extractor.downloadWebsite(urlRequest.getUrlName());

            Long datetime = System.currentTimeMillis();
            Timestamp startTime = new Timestamp(datetime);

            // extract links from home page
            Timestamp endTime = extractor.extractLinks(urlRequest.getUrlName());

            // count total size
            long totalSize =   extractor.countTotalKilobytes("src/main/java/downloadedPages/"+new WebsiteExtractor().extractWebname(urlRequest.getUrlName()));

            // time ellapsed between start time  and end time
            long timeEllapsed = endTime.getTime() - startTime.getTime();

            // save to database

            Website website = new Website();
            website.setWebsiteName(urlRequest.getUrlName());
            website.setDownloadStartTime(Date.valueOf("2022-07-11"));
            website.setDownloadEndTime(Date.valueOf("2022-07-11"));
            website.setTotalDownloadedFilesKilobytes( totalSize);
            website.setTotalElapsedTime(timeEllapsed);
            website.setId(UUID.fromString(UUID.randomUUID().toString()));

            //  save links to database

            Website websiteFound = websiteRepository.save(website);

            List<Link> links = extractor.saveLinks(urlRequest.getUrlName());

            for (Link link : links) {
                link.setWebsite(websiteFound);
                linkRepository.save(link);
            }

            System.out.println("Links: " + links.size());

        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        WebsiteExtractorServiceImpl extractorService = new WebsiteExtractorServiceImpl();
        UrlRequest urlRequest = new UrlRequest();
        urlRequest.setUrlName("https://www.google.com");
        extractorService.extractWebsite(urlRequest);
    }
}
