package com.example.odialko.vkwallapi.data.model;

import java.util.ArrayList;

/**
 * Created by Odialko on 06.09.2016.
 */
public class MyCard {

    private String mainText;
//    private String title;
    private ArrayList<String> url;
    private String url2;

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }

    public String getMainText() {
        return mainText;
    }

    public ArrayList<String> getUrl() {
        return url;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
