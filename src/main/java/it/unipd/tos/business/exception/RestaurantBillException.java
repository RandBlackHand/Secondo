////////////////////////////////////////////////////////////////////
// [GIULIO] [PIVA] [1146135]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

@SuppressWarnings("serial")
public class RestaurantBillException extends Throwable 
{
    private String msg;
    public RestaurantBillException(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String getMessage() {
        return msg;
    }
}
