package com.example.olgam.studentportal;

class Portal {

    //fields
    private String mPortalName;
    private String mLink; //give to Webview for loadUrl

     Portal(String mPortalName, String mLink) {
        this.mPortalName = mPortalName;
        this.mLink = mLink;
    }

     String getmPortalName() {
        return mPortalName;
    }

    public void setmPortalName(String mPortalName) {
        this.mPortalName = mPortalName;
    }

    String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    static final String[] PRE_DEFINED_PORTAL_NAMES = {
            "VLO",
            "DCMI",
            "DME",
            "MAD",
            "Resultaten"
    };

    static final String[] PRE_DEFINED_PORTAL_LINKS = {
            "https://vlo.informatica.hva.nl/",
            "https://www.hva.nl/faculteit/fdmci/digitale-media-en-creatieve-industrie.html",
            "https://sites.google.com/view/designingmobileexperiences2018/",
            "https://www.android-development.app/#!/home",
            "https://sis.hva.nl:8011/psc/S2PRD/EMPLOYEE/HRMS/c/SNS_MENU_FLD.SNS_SS_STD_RES_FL.GBL?/"
    };
}

