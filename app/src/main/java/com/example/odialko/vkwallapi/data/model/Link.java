package com.example.odialko.vkwallapi.data.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Odialko on 02.09.2016.
 */
public class Link {


    /**
     * url : http://urban.vn.ua/archives/4962
     * title : Як виглядає новий подільський дендропарк "Ладижинський гай" (Фото) - Urban
     * caption : urban.vn.ua
     * description : Подільське місто Ладижин стало одним з небагатьох міст України, де на сьогодні практично з нуля будують новий парк. Таким став “Ладижинський гай” – дендрологічний парк у самому центрі міста, першу частину якого відкрили на День Незалежності 24 серпня. Створювати парк почали два роки тому. Попередньо його вартість оцінили у 37 мільйонів гривень, але згодом сума …
     * photo : {"id":430273750,"album_id":-2,"owner_id":13879315,"photo_75":"https://pp.vk.me/...741/62yRvSxjeQM.jpg","photo_130":"https://pp.vk.me/...742/KNvqHpasrac.jpg","photo_604":"https://pp.vk.me/...743/GF2GHv4Fsok.jpg","width":150,"height":93,"text":"","date":1472555672}
     * is_external : 1
     */

    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;
    @SerializedName("caption")
    private String caption;
    @SerializedName("description")
    private String description;
    /**
     * id : 430273750
     * album_id : -2
     * owner_id : 13879315
     * photo_75 : https://pp.vk.me/...741/62yRvSxjeQM.jpg
     * photo_130 : https://pp.vk.me/...742/KNvqHpasrac.jpg
     * photo_604 : https://pp.vk.me/...743/GF2GHv4Fsok.jpg
     * width : 150
     * height : 93
     * text :
     * date : 1472555672
     */

    @SerializedName("photo")
    private PhotoBean photo;
    @SerializedName("is_external")
    private int isExternal;

    public static Link objectFromData(String str) {

        return new Gson().fromJson(str, Link.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhotoBean getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoBean photo) {
        this.photo = photo;
    }

    public int getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(int isExternal) {
        this.isExternal = isExternal;
    }

    public static class PhotoBean {
        @SerializedName("id")
        private int id;
        @SerializedName("album_id")
        private int albumId;
        @SerializedName("owner_id")
        private int ownerId;
        @SerializedName("photo_75")
        private String photo75;
        @SerializedName("photo_130")
        private String photo130;
        @SerializedName("photo_604")
        private String photo604;
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;
        @SerializedName("text")
        private String text;
        @SerializedName("date")
        private int date;

        public static PhotoBean objectFromData(String str) {

            return new Gson().fromJson(str, PhotoBean.class);
        }

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
    }
}
