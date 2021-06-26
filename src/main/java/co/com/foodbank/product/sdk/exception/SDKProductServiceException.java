package co.com.foodbank.product.sdk.exception;


/**
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.service
 *         4/06/2021
 */
public class SDKProductServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public SDKProductServiceException(Exception e) {
        super(e);
    }

}
