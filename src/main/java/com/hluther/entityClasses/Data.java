package com.hluther.entityClasses;
/**
 *
 * @author helmuth
 */
public class Data {
    
    String stringValue;
    String id;
    int integerValue;
    int type;
    boolean booleanValue;
    boolean empty;

    public Data(String id, String stringValue, int type, boolean empty) {
        this.id = id;
        this.stringValue = stringValue;
        this.type = type;
        this.empty = empty;
    }
    
    public Data(String id, int integerValue, int type, boolean empty) {
        this.id = id;
        this.integerValue = integerValue;
        this.type = type;
        this.empty = empty;
    }
    
    public Data(String id, boolean booleanValue, int type, boolean empty) {
        this.id = id;
        this.type = type;
        this.booleanValue = booleanValue;
        this.empty = empty;
    }
    
    public Data(String id, int type, boolean empty) {
        this.id = id;
        this.type = type;
        this.empty = empty;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }   
}
