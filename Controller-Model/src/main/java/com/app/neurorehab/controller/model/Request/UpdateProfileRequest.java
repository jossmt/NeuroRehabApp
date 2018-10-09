package com.app.neurorehab.controller.model.Request;

import org.springframework.stereotype.Component;

@Component
public class UpdateProfileRequest {

    private String fname;
    private String lname;
    private String profession;
    private String city;
    private String country;
    private String summary;
    private String about;


    /**
     * Sets new lname.
     *
     * @param lname
     *         New value of lname.
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Sets new country.
     *
     * @param country
     *         New value of country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets lname.
     *
     * @return Value of lname.
     */
    public String getLname() {
        return lname;
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
     * Gets fname.
     *
     * @return Value of fname.
     */
    public String getFname() {
        return fname;
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
     * Gets city.
     *
     * @return Value of city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets new fname.
     *
     * @param fname
     *         New value of fname.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Sets new city.
     *
     * @param city
     *         New value of city.
     */
    public void setCity(String city) {
        this.city = city;
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
     * Gets country.
     *
     * @return Value of country.
     */
    public String getCountry() {
        return country;
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
}
