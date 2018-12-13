////////////////////////////////////////////////////////////////////
// [GIULIO] [PIVA] [1146135]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.RestaurantBillException;

public interface RestaurantBill {
    double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException;
}
