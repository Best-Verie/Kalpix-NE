package rca.ne.client.dtos;

import javax.persistence.ManyToOne;

public class link {
    private String id;

    private String linkName;

    @ManyToOne
    private GetWebsite  website;

    private long totalElapsedTime;

    private long totalDownloadedFilesKilobytes;

    public link(String linkName, GetWebsite website, long totalElapsedTime, long totalDownloadedFilesKilobytes) {
        this.linkName = linkName;
        this.website = website;
        this.totalElapsedTime = totalElapsedTime;
        this.totalDownloadedFilesKilobytes = totalDownloadedFilesKilobytes;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public GetWebsite getWebsite() {
        return website;
    }

    public void setWebsite(GetWebsite website) {
        this.website = website;
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
}
