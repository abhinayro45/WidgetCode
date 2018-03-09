package com.monsanto.mbt;


import com.monsanto.mbt.model.Customer;
import com.monsanto.mbt.model.Shipment;
import com.monsanto.mbt.model.Widget;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.monsanto.mbt.Common.MbtConstants.MAX_SHIPMENT_HOLD;

public class ShipmentTest {

    /**
     * method to test the shipment sorted by the color
     */
    @Test
    public void testShipment_Sorted_By_Color(){
        List<Widget> widgets = WidgetUtils.getSampleWidgets();
        // sort by color in ascending
        widgets.sort(Comparator.comparing(Widget::getColor, Comparator.nullsFirst(Comparator.naturalOrder())));
        // prepare and print list of shipments
        prepareShipmentList(widgets);
    }

    /**
     * method to test shipments sorted by date
     */
    @Test
    public void testShipment_Sorted_By_Date(){
        List<Widget> widgets = WidgetUtils.getSampleWidgets();
        //sort bt date in ascending order
        widgets.sort(Comparator.comparing(Widget::getProductionDate, Comparator.nullsFirst(Comparator.naturalOrder())));
        // prepare and print list of shipments
        prepareShipmentList(widgets);
    }

    /**
     * prepares shipments list from the list of widgets
     * @param widgets - list of widgets to be shipped
     */
    private void prepareShipmentList(List<Widget> widgets) {
        List<Shipment> shipments = new ArrayList<>();
        int currentPos = 0;
        // loop until all the elements are finished
        while(currentPos < widgets.size()) {
            List<Widget> subList;
            // if the unprocessed widgets are more then the hold count
            if(currentPos + MAX_SHIPMENT_HOLD < widgets.size()) {
                // get the sublist that a shipment hols
                subList = widgets.subList(currentPos, currentPos + MAX_SHIPMENT_HOLD);
            } else {
                // get the remaining list
                subList = widgets.subList(currentPos, widgets.size());
            }
            // create a shipment and add to shipments lists
            Shipment shipment = createShipment(subList);
            currentPos = currentPos + MAX_SHIPMENT_HOLD;
            // check if the shipment is valid
            if(shipment.isValid()) {
                shipments.add(shipment);
            }
        }

        // print the shipments
        System.out.println(shipments);
    }

    /**
     * creates the shipment for the widgets list
     * @param widgets
     * @return
     */
    private Shipment createShipment(List<Widget> widgets) {
        Shipment shipment = new Shipment();
        // secondary validation to check max hold of a shipment
        if(widgets != null && widgets.size() > MAX_SHIPMENT_HOLD) {
            System.out.println("a shipment can not hold more than " + MAX_SHIPMENT_HOLD + " widgets");
        } else {
            shipment.setWidgets(widgets);
        }
        // add dummy shipment and customer details
        shipment.setCustomer(createDummyCustomer());
        shipment.setShipmentId("98765432110");
        shipment.setTrackingNumber("USPS213657847");
        return shipment;
    }

    /**
     * creates a mocked customer
     * @return - mocked customer
     */
    private Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("123456");
        customer.setStreet("11515 Craig Ct");
        customer.setApt("412");
        customer.setFirstName("Abhinay");
        customer.setLastName("Basireddy");
        customer.setState("MO");
        customer.setZip("63146");
        customer.setCity("St. Louis");
        return customer;
    }


}
