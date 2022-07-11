package rca.ne.client.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public class GetWebsite {
    private String id;

    private String websiteName;

    private Timestamp downloadStartTime;

    private Timestamp downloadEndTime;

    private long totalElapsedTime;

    private long totalDownloadedFilesKilobytes;

    public GetWebsite() {
    }

    public GetWebsite(String id, String websiteName, Timestamp downloadStartTime, Timestamp downloadEndTime, long totalElapsedTime, long totalDownloadedFilesKilobytes) {
        this.id = id;
        this.websiteName = websiteName;
        this.downloadStartTime = downloadStartTime;
        this.downloadEndTime = downloadEndTime;
        this.totalElapsedTime = totalElapsedTime;
        this.totalDownloadedFilesKilobytes = totalDownloadedFilesKilobytes;
    }

    public GetWebsite(String websiteName, Timestamp downloadStartTime, Timestamp downloadEndTime, long totalElapsedTime, long totalDownloadedFilesKilobytes) {
        this.websiteName = websiteName;
        this.downloadStartTime = downloadStartTime;
        this.downloadEndTime = downloadEndTime;
        this.totalElapsedTime = totalElapsedTime;
        this.totalDownloadedFilesKilobytes = totalDownloadedFilesKilobytes;
    }


    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public Timestamp getDownloadStartTime() {
        return downloadStartTime;
    }

    public void setDownloadStartTime(Timestamp downloadStartTime) {
        this.downloadStartTime = downloadStartTime;
    }

    public Timestamp getDownloadEndTime() {
        return downloadEndTime;
    }

    public void setDownloadEndTime(Timestamp downloadEndTime) {
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
}
