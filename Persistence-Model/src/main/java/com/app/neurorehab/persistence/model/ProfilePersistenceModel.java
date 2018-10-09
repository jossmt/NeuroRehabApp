package com.app.neurorehab.persistence.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Profile model as represented by DB.
 */
@Entity
@Table(name = "Profile")
public class ProfilePersistenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "summary")
    private String summary;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "about")
    private String about;

    @Column(name = "profession")
    private String profession;

    @Column(name = "location")
    private String location;

    @Column(name = "picture")
    private byte[] picture;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;

    /**
     * Sets new background.
     *
     * @param background
     *         New value of background.
     */
    public void setSummary(String background) {
        this.summary = background;
    }

    /**
     * Gets background.
     *
     * @return Value of background.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Gets userPersistenceModel.
     *
     * @return Value of userPersistenceModel.
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new userPersistenceModel.
     *
     * @param userPersistenceModel
     *         New value of userPersistenceModel.
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
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
     * Gets location.
     *
     * @return Value of location.
     */
    public String getLocation() {
        return location;
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
     * Sets new profession.
     *
     * @param profession
     *         New value of profession.
     */
    public void setProfession(String profession) {
        this.profession = profession;
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
     * Sets new about.
     *
     * @param about
     *         New value of about.
     */
    public void setAbout(String about) {
        this.about = about;
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
     * Gets picture.
     *
     * @return Value of picture.
     */
    public byte[] getPicture() {
        return picture;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProfilePersistenceModel that = (ProfilePersistenceModel) o;

        return new EqualsBuilder()
                .append(getLocation(), that.getLocation())
                .append(getRating(), that.getRating())
                .append(getProfession(), that.getProfession())
                .append(getAbout(), that.getAbout())
                .append(getUserPersistenceModel(), that.getUserPersistenceModel())
                .append(getSummary(), that.getSummary())
                .append(getPicture(), that.getPicture())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getLocation())
                .append(getAbout())
                .append(getRating())
                .append(getProfession())
                .append(getSummary())
                .append(getPicture())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("location", location)
                .append("about", about)
                .append("rating", rating)
                .append("profession", profession)
                .append("background", summary)
                .append("picture", picture)
                .toString();
    }
}
