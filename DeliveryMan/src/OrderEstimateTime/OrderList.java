/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderEstimateTime;

/**
 *
 * @author Win-8
 */
public class OrderList {
    private String orderId;
    private String menuName;
    private int quantity;

    public OrderList(String orderId, String menuName, int quantity) {
        this.orderId = orderId;
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
