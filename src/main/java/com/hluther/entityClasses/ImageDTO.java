package com.hluther.entityClasses;

import com.hluther.gui.CanvasPanel;
/**
 *
 * @author helmuth
 */
public class ImageDTO {
    
    private String id;
    private int duration;
    private CanvasPanel canvasPanel;
    
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

    public CanvasPanel getCanvasPanel() {
        return canvasPanel;
    }

    public void setCanvasPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
    }
}
