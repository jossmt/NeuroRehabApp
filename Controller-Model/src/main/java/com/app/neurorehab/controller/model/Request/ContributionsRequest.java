package com.app.neurorehab.controller.model.Request;

import org.springframework.stereotype.Component;


@Component
public class ContributionsRequest {

    private Boolean accepted;

    /**
     * Gets accepted.
     *
     * @return Value of accepted.
     */
    public Boolean isAccepted() {
        return accepted;
    }

    /**
     * Sets new accepted.
     *
     * @param accepted
     *         New value of accepted.
     */
    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
