package com.monsanto.mbt.model;

import com.monsanto.mbt.Common.MbtConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * represent shipment class
 */
public class Shipment {

    private String shipmentId;
    private String trackingNumber;
    private Customer customer;
    private List<Widget> widgets;

    public Shipment() {
        widgets = new ArrayList<>();
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    /**
     * checks of the widgets size is acceptable or not before set
     * @param widgets
     */
    public void setWidgets(List<Widget> widgets) {
        if(widgets != null && widgets.size() <= MbtConstants.MAX_SHIPMENT_HOLD) {
            this.widgets = widgets;
        }
        else {
            System.out.println("invalid widgets");
        }
    }

    /**
     * checks if the shipment is valid or not
     * @return
     */
    public boolean isValid() {
        if(widgets == null || widgets.size() == 0) {
            return false;
        }
        if(customer == null || !customer.isValid()) {
            return false;
        }
        if(trackingNumber == null) {
            return false;
        }
        return true;
    }

    /**
     * overriding toString method
     * @return
     */
    public String toString() {
        return "{\n\ttrackingNumber : " + trackingNumber + ",\n\tcustomer: " + customer.getFirstName()+ ",\n\twidgets: " + widgets + "\n}";
    }

}
