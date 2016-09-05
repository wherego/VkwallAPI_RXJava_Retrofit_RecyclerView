
package com.example.odialko.vkwallapi.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Attachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("video")
    @Expose
    private Video video;

    @SerializedName("photo")
    @Expose
    private Photo photo;

    @SerializedName("link")
    @Expose
    private Link link;
    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * 
     * @param video
     *     The video
     */
    public void setVideo(Video video) {
        this.video = video;
    }

    public Photo getPhoto() {
        return photo;
    }

    public Link getLink() {
        return link;
    }
}
