package com.app.neurorehab.controller.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * Profile model as represented by DB.
 */
@Component
public class ProfileControllerModel {

    private String summary;

    private Integer rating;

    private String about;

    private String profession;

    private String location;

    private byte[] picture;

    /**
     * Sets new summary.
     *
     * @param summary
     *         New value of summary.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets summary.
     *
     * @return Value of summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Gets rating.
     *
     * @return Value of rating.
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Sets new about.
     *
     * @param about
     *         New value of about.
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Gets about.
     *
     * @return Value of about.
     */
    public String getAbout() {
        return about;
    }

    /**
     * Gets profession.
     *
     * @return Value of profession.
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Sets new location.
     *
     * @param location
     *         New value of location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets location.
     *
     * @return Value of location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets new profession.
     *
     * @param profession
     *         New value of profession.
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * Sets new rating.
     *
     * @param rating
     *         New value of rating.
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * Sets new picture.
     *
     * @param picture
     *         New value of picture.
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    /**
     * Gets picture.
     *
     * @return Value of picture.
     */
    public byte[] getPicture() {
        return picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProfileControllerModel that = (ProfileControllerModel) o;

        return new EqualsBuilder()
                .append(getAbout(), that.getAbout())
                .append(getLocation(), that.getLocation())
                .append(getProfession(), that.getProfession())
                .append(getRating(), that.getRating())
                .append(getSummary(), that.getSummary())
                .append(getPicture(), that.getPicture())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAbout())
                .append(getLocation())
                .append(getProfession())
                .append(getRating())
                .append(getSummary())
                .append(getPicture())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("about", about)
                .append("location", location)
                .append("profession", profession)
                .append("rating", rating)
                .append("summary", summary)
                .toString();
    }
}
