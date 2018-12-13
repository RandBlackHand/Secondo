////////////////////////////////////////////////////////////////////
// [GIULIO] [PIVA] [1146135]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem 
{
    private String Nome;
    private MenuItemType Tipo;
    private double Prezzo;

    public MenuItem(MenuItemType Tipo, String Nome, double Prezzo) {
        this.Tipo = Tipo;
        this.Nome = Nome;
        this.Prezzo = Prezzo;
    }

    public MenuItemType getItemType() {
        return Tipo;
    }

    public double getPrice() {
        return Prezzo;
    }
    
}
