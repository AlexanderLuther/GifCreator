package com.hluther.entityClasses;
/**
 *
 * @author helmuth
 */
public class SizeDTO {
    
    private int pixelsAmount;
    private int rows;
    private int columns;

    public SizeDTO(int pixelsAmount, int rows, int columns) {
        this.pixelsAmount = pixelsAmount;
        this.rows = rows;
        this.columns = columns;
    }

    public int getPixelsAmount() {
        return pixelsAmount;
    }

    public void setPixelsAmount(int pixelsAmount) {
        this.pixelsAmount = pixelsAmount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
}
