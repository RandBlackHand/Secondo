package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItemType;
import it.unipd.tos.business.exception.RestaurantBillException;

public class RestaurantBillClientTes {
	@Test 
    public void getOrderPrice_ItemsSum() {
        RestaurantBillClient mi = new RestaurantBillClient();
        List<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Spaghetti carbonara",9.00));
        try {
            assertEquals(Double.toString(mi.getOrderPrice(menu)),"14.0");
        }
        catch(RestaurantBillException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void getOrderPrice_MoreThan20Items_RestaurantBillException() {
        RestaurantBillClient mi = new RestaurantBillClient();
        try {
            List<MenuItem> menu = new ArrayList<MenuItem>(21);
            for(int i = 0; i < 22; i++) {
                menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
            }
            mi.getOrderPrice(menu);
            fail("Doveva lanciare un'eccezione");
        } catch (RestaurantBillException e) {
            assertEquals(e.getMessage(), "Errore, non si possono ordinare più di 20 piatti");
        }

    }

    @Test
    public void getOrderPrice_MoreThan10Pizzas_BillDiscount() {
        List<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        menu.add(new MenuItem(MenuItemType.PIZZA,"Pizza margherita",5.00));
        RestaurantBill rb = new RestaurantBillClient();
        try {
            assertEquals(Double.toString(rb.getOrderPrice(menu)), "50.0");
        } catch (RestaurantBillException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void getOrderPrice_MoreThan100Price_BillDiscount() {
        List<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem(MenuItemType.PRIMO,"Catalana di pesce", 55.0));
        menu.add(new MenuItem(MenuItemType.PRIMO,"Caviale",180.0));
        RestaurantBill rb = new RestaurantBillClient();
        try {
            assertEquals(Double.toString(rb.getOrderPrice(menu)), "223.25");
        } catch (RestaurantBillException e) {
            fail(e.getMessage());
        }
    }
}
