/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Win-8
 */
public class DeliveryManAttendance implements Serializable{

    DeliveryMan deliveryMan;
    Date clockIn;
    Date clockOut;

    public DeliveryManAttendance(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
  
    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClockOut(Date clockOut) {
        this.clockOut = clockOut;
    }
}
