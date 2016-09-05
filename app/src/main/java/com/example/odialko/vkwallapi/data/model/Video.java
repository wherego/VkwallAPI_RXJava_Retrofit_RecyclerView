
package com.example.odialko.vkwallapi.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Video {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("owner_id")
    @Expose
    private int ownerId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private int date;
    @SerializedName("views")
    @Expose
    private int views;
    @SerializedName("comments")
    @Expose
    private int comments;
    @SerializedName("photo_130")
    @Expose
    private String photo130;
    @SerializedName("photo_320")
    @Expose
    private String photo320;
    @SerializedName("photo_640")
    @Expose
    private String photo640;
    @SerializedName("access_key")
    @Expose
    private String accessKey;
    @SerializedName("can_add")
    @Expose
    private int canAdd;

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * 
     * @param ownerId
     *     The owner_id
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The date
     */
    public int getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The views
     */
    public int getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(int views) {
        this.views = views;
    }

    /**
     * 
     * @return
     *     The comments
     */
    public int getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(int comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The photo130
     */
    public String getPhoto130() {
        return photo130;
    }

    /**
     * 
     * @param photo130
     *     The photo_130
     */
    public void setPhoto130(String photo130) {
        this.photo130 = photo130;
    }

    /**
     * 
     * @return
     *     The photo320
     */
    public String getPhoto320() {
        return photo320;
    }

    /**
     * 
     * @param photo320
     *     The photo_320
     */
    public void setPhoto320(String photo320) {
        this.photo320 = photo320;
    }

    /**
     * 
     * @return
     *     The photo640
     */
    public String getPhoto640() {
        return photo640;
    }

    /**
     * 
     * @param photo640
     *     The photo_640
     */
    public void setPhoto640(String photo640) {
        this.photo640 = photo640;
    }

    /**
     * 
     * @return
     *     The accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 
     * @param accessKey
     *     The access_key
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * 
     * @return
     *     The canAdd
     */
    public int getCanAdd() {
        return canAdd;
    }

    /**
     * 
     * @param canAdd
     *     The can_add
     */
    public void setCanAdd(int canAdd) {
        this.canAdd = canAdd;
    }

}
