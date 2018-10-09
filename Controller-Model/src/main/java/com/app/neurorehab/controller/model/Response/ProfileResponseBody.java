package com.app.neurorehab.controller.model.Response;


import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.controller.model.ProfileControllerModel;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanResponseBody;

import java.util.Set;

public class ProfileResponseBody {

    private String fname;

    private String lname;

    private boolean isOwner;

    private ProfileControllerModel profileControllerModel;

    private KanbanResponseBody kanbanResponseBody;

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
     * Sets new fname.
     *
     * @param fname
     *         New value of fname.
     */
    public void setFname(String fname) {
        this.fname = fname;
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
     * Sets new lname.
     *
     * @param lname
     *         New value of lname.
     */
    public void setLname(String lname) {
        this.lname = lname;
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
     * Sets new kanbanResponseBody.
     *
     * @param kanbanResponseBody
     *         New value of kanbanResponseBody.
     */
    public void setKanbanResponseBody(KanbanResponseBody kanbanResponseBody) {
        this.kanbanResponseBody = kanbanResponseBody;
    }

    /**
     * Gets kanbanResponseBody.
     *
     * @return Value of kanbanResponseBody.
     */
    public KanbanResponseBody getKanbanResponseBody() {
        return kanbanResponseBody;
    }

    /**
     * Gets isOwner.
     *
     * @return Value of isOwner.
     */
    public boolean isIsOwner() {
        return isOwner;
    }

    /**
     * Sets new isOwner.
     *
     * @param isOwner
     *         New value of isOwner.
     */
    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }
}
