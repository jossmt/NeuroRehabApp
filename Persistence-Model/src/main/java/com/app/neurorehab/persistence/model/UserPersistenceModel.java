package com.app.neurorehab.persistence.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User Model as represented in DB.
 */
@Entity
@Table(name = "User")
public class UserPersistenceModel {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    @Column(name = "user_reference", nullable = false)
    private String userReference;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "userPersistenceModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProfilePersistenceModel profilePersistenceModel;

    @OneToMany(mappedBy = "userPersistenceModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TrainingResultsPersistenceModel> trainingResultsPersistenceModels;

    @OneToMany(mappedBy = "userPersistenceModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval =
            true)
    private Set<ContributionPersistenceModel> contributionPersistenceModels;

    /** User role privileges. */
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name
            = "role_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RolePersistenceModel> rolePersistenceModels;

    /**
     * Gets trainingResultsPersistenceModels.
     *
     * @return Value of trainingResultsPersistenceModels.
     */
    public Set<TrainingResultsPersistenceModel> getTrainingResultsPersistenceModels() {
        return trainingResultsPersistenceModels;
    }

    /**
     * Gets profilePersistenceModel.
     *
     * @return Value of profilePersistenceModel.
     */
    public ProfilePersistenceModel getProfilePersistenceModel() {
        return profilePersistenceModel;
    }

    /**
     * Sets new profilePersistenceModel.
     *
     * @param profilePersistenceModel
     *         New value of profilePersistenceModel.
     */
    public void setProfilePersistenceModel(ProfilePersistenceModel profilePersistenceModel) {
        this.profilePersistenceModel = profilePersistenceModel;
    }

    /**
     * Gets contributionPersistenceModels.
     *
     * @return Value of contributionPersistenceModels.
     */
    public Set<ContributionPersistenceModel> getContributionPersistenceModels() {
        return contributionPersistenceModels;
    }

    /**
     * Sets new contributionPersistenceModels.
     *
     * @param contributionPersistenceModels
     *         New value of contributionPersistenceModels.
     */
    public void setContributionPersistenceModels(Set<ContributionPersistenceModel> contributionPersistenceModels) {
        this.contributionPersistenceModels = contributionPersistenceModels;
    }

    /**
     * Sets new trainingResultsPersistenceModels.
     *
     * @param trainingResultsPersistenceModels
     *         New value of trainingResultsPersistenceModels.
     */
    public void setTrainingResultsPersistenceModels(Set<TrainingResultsPersistenceModel>
                                                            trainingResultsPersistenceModels) {
        this.trainingResultsPersistenceModels = trainingResultsPersistenceModels;
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
     * Sets new uname.
     *
     * @param uname
     *         New value of uname.
     */
    public void setEmail(String uname) {
        this.email = uname;
    }

    /**
     * Gets uname.
     *
     * @return Value of uname.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new password.
     *
     * @param password
     *         New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets User role privileges..
     *
     * @return Value of User role privileges..
     */
    public List<RolePersistenceModel> getRolePersistenceModels() {
        return rolePersistenceModels;
    }

    /**
     * Sets new User role privileges..
     *
     * @param rolePersistenceModels
     *         New value of User role privileges..
     */
    public void setRolePersistenceModels(List<RolePersistenceModel> rolePersistenceModels) {
        this.rolePersistenceModels = rolePersistenceModels;
    }

    /**
     * Gets userReference.
     *
     * @return Value of userReference.
     */
    public String getUserReference() {
        return userReference;
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

    public boolean hasProfilePersistenceModel() {
        return profilePersistenceModel != null;
    }

    public void addContributionPersistenceModel(final ContributionPersistenceModel contributionPersistenceModel) {
        if (contributionPersistenceModels == null) {
            contributionPersistenceModels = new HashSet<>();
        }
        contributionPersistenceModels.add(contributionPersistenceModel);
        contributionPersistenceModel.setUserPersistenceModel(this);

        if (contributionPersistenceModel.getTrainingPersistenceModel() != null) {
            contributionPersistenceModel.getTrainingPersistenceModel().setContributionPersistenceModel
                    (contributionPersistenceModel);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserPersistenceModel that = (UserPersistenceModel) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getFname(), that.getFname())
                .append(getLname(), that.getLname())
                .append(getEmail(), that.getEmail())
                .append(getUserReference(), that.getUserReference())
                .append(getContributionPersistenceModels(), that.getContributionPersistenceModels())
                .append(getProfilePersistenceModel(), that.getProfilePersistenceModel())
                .append(getTrainingResultsPersistenceModels(), that.getTrainingResultsPersistenceModels())
                .append(getRolePersistenceModels(), that.getRolePersistenceModels())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFname())
                .append(getLname())
                .append(getEmail())
                .append(getUserReference())
                .append(getContributionPersistenceModels())
                .append(getProfilePersistenceModel())
                .append(getTrainingResultsPersistenceModels())
                .append(getRolePersistenceModels())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fname", fname)
                .append("lname", lname)
                .append("reference", userReference)
                .append("email", email)
                .toString();
    }
}
