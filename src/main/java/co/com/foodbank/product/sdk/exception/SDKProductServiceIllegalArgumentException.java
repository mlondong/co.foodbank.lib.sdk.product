package co.com.foodbank.product.sdk.exception;


/**
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.config.exception
 *         8/06/2021
 */
public class SDKProductServiceIllegalArgumentException extends Exception {
    private static final long serialVersionUID = 1L;

    public SDKProductServiceIllegalArgumentException(Exception e) {
        super(e);
    }
}
