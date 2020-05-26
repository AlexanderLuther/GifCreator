package com.hluther.entityClasses;
/**
 *
 * @author helmuth
 */
public class TemporalData {
   
    String id;
    String idValue;
    int idRow;
    int idColumn;
    int type;

    public TemporalData(String id, String idValue, int idRow, int idColumn, int type) {
        this.id = id;
        this.idValue = idValue;
        this.idRow = idRow;
        this.idColumn = idColumn;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public int getIdRow() {
        return idRow;
    }

    public void setIdRow(int idRow) {
        this.idRow = idRow;
    }

    public int getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(int idColumn) {
        this.idColumn = idColumn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    } 
}
