package com.example.olgam.studentportal;

public class Portal {

    //fields
    private String mPortalName;
    private String mLink; //give to Webview for loadurl

    public Portal(String mPortalName, String mLink) {
        this.mPortalName = mPortalName;
        this.mLink = mLink;
    }

    public String getmPortalName() {
        return mPortalName;
    }

    public void setmPortalName(String mPortalName) {
        this.mPortalName = mPortalName;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public static final String[] PRE_DEFINED_PORTAL_NAMES = {
            "VLO",
            "DCMI",
            "Roosters",
            "Resultaten",
            "Nieuws"
    };

    public static final String[] PRE_DEFINED_PORTAL_LINKS = {
            "https://vlo.informatica.hva.nl/",
            "https://www.hva.nl/faculteit/fdmci/digitale-media-en-creatieve-industrie.html",
            "https://adfs20.hva.nl/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fidp1.hva.nl%2fadfs%2fservices%2ftrust&wctx=3d3fd32b-4200-4c91-8c58-643ac16fd9fe&wfresh=0&whr=http%3a%2f%2fadfs20.hva.nl%2fadfs%2fservices%2ftrust",
            "https://rooster.hva.nl/",
            "https://www.nu.nl"
    };
}

