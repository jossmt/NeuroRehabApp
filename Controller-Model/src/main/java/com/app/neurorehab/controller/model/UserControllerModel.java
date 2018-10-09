package com.app.neurorehab.controller.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserControllerModel {

    private String fname;
    private String lname;
    private String email;
    private String userReference;

    private ProfileControllerModel profileControllerModel;

    private Set<TrainingResultsControllerModel> trainingResultsControllerModels;

    private Set<ContributionControllerModel> contributionControllerModels;

    private Set<RoleControllerModel> roleControllerModels;

    public UserControllerModel() {
    }

    public UserControllerModel(final UserControllerModel userControllerModel) {
        this.fname = userControllerModel.getFname();
        this.lname = userControllerModel.getLname();
        this.email = userControllerModel.getEmail();
        this.userReference = userControllerModel.getUserReference();
        this.profileControllerModel = userControllerModel.getProfileControllerModel();
        this.trainingResultsControllerModels = userControllerModel.getTrainingResultsControllerModels();
        this.contributionControllerModels = userControllerModel.getContributionControllerModels();
        this.roleControllerModels = userControllerModel.getRoleControllerModels();
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
     * Sets new lname.
     *
     * @param lname
     *         New value of lname.
     */
    public void setLname(String lname) {
        this.lname = lname;
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
     * Sets new fname.
     *
     * @param fname
     *         New value of fname.
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Sets new email.
     *
     * @param email
     *         New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new contributionControllerModels.
     *
     * @param contributionControllerModels
     *         New value of contributionControllerModels.
     */
    public void setContributionControllerModels(Set<ContributionControllerModel> contributionControllerModels) {
        this.contributionControllerModels = contributionControllerModels;
    }

    /**
     * Gets trainingResultsControllerModels.
     *
     * @return Value of trainingResultsControllerModels.
     */
    public Set<TrainingResultsControllerModel> getTrainingResultsControllerModels() {
        return trainingResultsControllerModels;
    }

    /**
     * Sets new trainingResultsControllerModels.
     *
     * @param trainingResultsControllerModels
     *         New value of trainingResultsControllerModels.
     */
    public void setTrainingResultsControllerModels(Set<TrainingResultsControllerModel>
                                                           trainingResultsControllerModels) {
        this.trainingResultsControllerModels = trainingResultsControllerModels;
    }

    /**
     * Gets contributionControllerModels.
     *
     * @return Value of contributionControllerModels.
     */
    public Set<ContributionControllerModel> getContributionControllerModels() {
        return contributionControllerModels;
    }

    /**
     * Gets profileControllerModel.
     *
     * @return Value of profileControllerModel.
     */
    public ProfileControllerModel getProfileControllerModel() {
        return profileControllerModel;
    }

    /**
     * Sets new profileControllerModel.
     *
     * @param profileControllerModel
     *         New value of profileControllerModel.
     */
    public void setProfileControllerModel(ProfileControllerModel profileControllerModel) {
        this.profileControllerModel = profileControllerModel;
    }

    /**
     * Gets roleControllerModels.
     *
     * @return Value of roleControllerModels.
     */
    public Set<RoleControllerModel> getRoleControllerModels() {
        return roleControllerModels;
    }

    /**
     * Sets new roleControllerModels.
     *
     * @param roleControllerModels
     *         New value of roleControllerModels.
     */
    public void setRoleControllerModels(Set<RoleControllerModel> roleControllerModels) {
        this.roleControllerModels = roleControllerModels;
    }

    /**
     * Sets new userReference.
     *
     * @param userReference
     *         New value of userReference.
     */
    public void setUserReference(String userReference) {
        this.userReference = userReference;
    }

    /**
     * Gets userReference.
     *
     * @return Value of userReference.
     */
    public String getUserReference() {
        return userReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserControllerModel that = (UserControllerModel) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getFname(), that.getFname())
                .append(getLname(), that.getLname())
                .append(getEmail(), that.getEmail())
                .append(getUserReference(), that.getUserReference())
                .append(getProfileControllerModel(), that.getProfileControllerModel())
                .append(getContributionControllerModels(), that.getContributionControllerModels())
                .append(getTrainingResultsControllerModels(), that.getTrainingResultsControllerModels())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFname())
                .append(getLname())
                .append(getEmail())
                .append(getUserReference())
                .append(getProfileControllerModel())
                .append(getContributionControllerModels())
                .append(getTrainingResultsControllerModels())
                .append(getRoleControllerModels())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fname", fname)
                .append("lname", lname)
                .append("email", email)
                .append("userReference", userReference)
                .toString();
    }
}
