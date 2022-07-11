package com.kaplix.downloader.server.repositories;

import com.kaplix.downloader.server.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<Link, UUID> {
    List<Link> findByWebsiteId(UUID websiteId);
}
