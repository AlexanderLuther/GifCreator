package com.hluther.entityClasses;
import java.util.LinkedList;

/**
 *
 * @author helmuth
 */
public class Time {
    
    private String canvasId;
    private String startId;
    private String endId;
    private LinkedList<ImageDTO> images;

    public Time(String startId, String endId, LinkedList<ImageDTO> images) {
        this.startId = startId;
        this.endId = endId;
        this.images = images;
    }

    public String getCanvasId() {
        return canvasId;
    }

    public void setCanvasId(String canvasId) {
        this.canvasId = canvasId;
    }

    public String getStartId() {
        return startId;
    }

    public void setStartId(String startId) {
        this.startId = startId;
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
    }

    public LinkedList<ImageDTO> getImages() {
        return images;
    }

    public void setImages(LinkedList<ImageDTO> images) {
        this.images = images;
    }
    
    public int getIdIndex(String id){
        for(int i = 0; i < images.size(); i++){
            if(images.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    
}
