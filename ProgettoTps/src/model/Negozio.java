package model;

/**
 * @author Oniichan
 * @data 05/10/2021
 * @project ProgettoTps
 */
public class Negozio {
    private int n_Prodotti;
    private int max_Prodotti;
    public Negozio(int max_Prodotti){
        n_Prodotti = 0;
        this.max_Prodotti = max_Prodotti;
    }

    public String chargePro(int qty){
        String response = "";
        if(n_Prodotti + qty <= max_Prodotti){
            response += "Ho caricato " + qty + " prodotti";
            n_Prodotti += qty;
        }
        else if(n_Prodotti + qty > max_Prodotti){
            response += "Ho caricato " +(max_Prodotti - n_Prodotti) + " rimasti " + (n_Prodotti + qty - max_Prodotti);
            n_Prodotti = max_Prodotti;
        }
        else{
            response += "Non ho caricato niente , prodotti full";
        }
        return response;
    }
    public String buyPro(int qty){
        String response = "";
        if(qty <= n_Prodotti){
            response += "Ho acquistato " + qty + " prodotti";
            n_Prodotti -= qty;
        }
        else{
            response += "Volevo acquistare " + qty + " prodotti , ma ne sono rimasti solo " + n_Prodotti;
            n_Prodotti = 0;
        }
        return response;
    }


}
