////////////////////////////////////////////////////////////////////
// [GIULIO] [PIVA] [1146135]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import java.util.OptionalDouble;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItemType;
import it.unipd.tos.business.exception.RestaurantBillException;

public class RestaurantBillClient implements RestaurantBill 
{
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        if (itemsOrdered.size() > 20) {
            throw new RestaurantBillException("Errore, non si possono ordinare più di 20 piatti");
        }
        double Prezzo = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();
        long NumeroPizze = itemsOrdered.stream()
                .filter(predicate -> predicate.getItemType() == MenuItemType.PIZZA).count();
        if (NumeroPizze >= 10L) {
            OptionalDouble priceToRemove = itemsOrdered.stream()
                    .filter(predicate -> predicate.getItemType() == MenuItemType.PIZZA)
                    .mapToDouble(MenuItem::getPrice).min();
            if (priceToRemove.isPresent()) {
                Prezzo = Prezzo- priceToRemove.getAsDouble();
            }
            
        }
        if (Prezzo >= 100.00) {
            Prezzo = Prezzo - Prezzo * 0.05;
        }
    
        return Prezzo;
    }

}
