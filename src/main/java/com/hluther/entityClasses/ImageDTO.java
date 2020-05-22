package com.hluther.entityClasses;
/**
 *
 * @author helmuth
 */
public class ImageDTO {
    
    private String id;
    private int duration;

    public ImageDTO(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
