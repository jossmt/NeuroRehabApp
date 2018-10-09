package com.app.neurorehab.controller.model.Request;

public class UpdateProfilePictureRequest {

    private Byte[] image;


    /**
     * Gets image.
     *
     * @return Value of image.
     */
    public Byte[] getImage() {
        return image;
    }

    /**
     * Sets new image.
     *
     * @param image
     *         New value of image.
     */
    public void setImage(Byte[] image) {
        this.image = image;
    }
}
