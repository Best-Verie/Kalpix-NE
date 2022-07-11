package com.kaplix.downloader.server.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table( name = "websites_tbl" )

public class Website {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR(255)")
    private UUID id;

    private String websiteName;

    private Date downloadStartTime;

    private Date downloadEndTime;

    private long totalElapsedTime;

    private long totalDownloadedFilesKilobytes;

    public Website() {
    }

    public Website(String websiteName, Date downloadStartTime, Date downloadEndTime, long totalElapsedTime, long totalDownloadedFilesKilobytes) {
        this.websiteName = websiteName;
        this.downloadStartTime = downloadStartTime;
        this.downloadEndTime = downloadEndTime;
        this.totalElapsedTime = totalElapsedTime;
        this.totalDownloadedFilesKilobytes = totalDownloadedFilesKilobytes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public Date getDownloadStartTime() {
        return downloadStartTime;
    }

    public void setDownloadStartTime(Date downloadStartTime) {
        this.downloadStartTime = downloadStartTime;
    }

    public Date getDownloadEndTime() {
        return downloadEndTime;
    }

    public void setDownloadEndTime(Date downloadEndTime) {
        this.downloadEndTime = downloadEndTime;
    }

    public long getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public void setTotalElapsedTime(long totalElapsedTime) {
        this.totalElapsedTime = totalElapsedTime;
    }

    public long getTotalDownloadedFilesKilobytes() {
        return totalDownloadedFilesKilobytes;
    }

    public void setTotalDownloadedFilesKilobytes(long totalDownloadedFilesKilobytes) {
        this.totalDownloadedFilesKilobytes = totalDownloadedFilesKilobytes;
    }

    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", websiteName='" + websiteName + '\'' +
                ", downloadStartTime=" + downloadStartTime +
                ", downloadEndTime=" + downloadEndTime +
                ", totalElapsedTime=" + totalElapsedTime +
                ", totalDownloadedFilesKilobytes=" + totalDownloadedFilesKilobytes +
                '}';
    }
}
