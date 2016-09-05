package com.example.odialko.vkwallapi.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Odialko on 01.09.2016.
 */
public class Photo {

    /**
     * id : 428254374
     * album_id : -7
     * owner_id : -5455896
     * user_id : 100
     * photo_75 : http://cs630121.vk.me/v630121315/4408f/QAQr8Z-_hzI.jpg
     * photo_130 : http://cs630121.vk.me/v630121315/44090/fTv1k03spGk.jpg
     * photo_604 : http://cs630121.vk.me/v630121315/44091/i0XofoqFjbg.jpg
     * photo_807 : http://cs630121.vk.me/v630121315/44092/AMeW-jI6R4E.jpg
     * photo_1280 : http://cs630121.vk.me/v630121315/44093/CmtUX5lSBw0.jpg
     * photo_2560 : http://cs630121.vk.me/v630121315/44094/6BbP84MI3h0.jpg
     * width : 2560
     * height : 1696
     * text :
     * date : 1472672065
     * access_key : 033a33e18925d1df7c
     */

    @SerializedName("id")
    private int id;
    @SerializedName("album_id")
    private int albumId;
    @SerializedName("owner_id")
    private int ownerId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("photo_75")
    private String photo75;
    @SerializedName("photo_130")
    private String photo130;
    @SerializedName("photo_604")
    private String photo604;
    @SerializedName("photo_807")
    private String photo807;
    @SerializedName("photo_1280")
    private String photo1280;
    @SerializedName("photo_2560")
    private String photo2560;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("text")
    private String text;
    @SerializedName("date")
    private int date;
    @SerializedName("access_key")
    private String accessKey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public void setPhoto75(String photo75) {
        this.photo75 = photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public void setPhoto604(String photo604) {
        this.photo604 = photo604;
    }

    public String getPhoto807() {
        return photo807;
    }

    public void setPhoto807(String photo807) {
        this.photo807 = photo807;
    }

    public String getPhoto1280() {
        return photo1280;
    }

    public void setPhoto1280(String photo1280) {
        this.photo1280 = photo1280;
    }

    public String getPhoto2560() {
        return photo2560;
    }

    public void setPhoto2560(String photo2560) {
        this.photo2560 = photo2560;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
