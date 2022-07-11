package rca.ne.client.dtos;

public class webSiteDto {
    String UrlName;

    public webSiteDto(String urlName) {
        UrlName = urlName;
    }

    public String getUrlName() {
        return UrlName;
    }

    public void setUrlName(String urlName) {
        UrlName = urlName;
    }
}

