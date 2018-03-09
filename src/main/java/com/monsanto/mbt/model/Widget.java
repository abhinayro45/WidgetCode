package com.monsanto.mbt.model;

import java.util.Date;

/**
 * widget class
 */
public class Widget {
    private int serialNumber;
    private String color;
    private Date productionDate;

    public Widget(int serialNumber, String color, Date productionDate) {
        this.serialNumber = serialNumber;
        this.color = color;
        this.productionDate = productionDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * overriding toString method
     * @return
     */
    public String toString() {
        return "\n\t{\n\t\tserialNumber: " + serialNumber + ",\n\t\tcolor: " + color + ",\n\t\tproductionDate: " + productionDate + "\n\t}";
    }
}
