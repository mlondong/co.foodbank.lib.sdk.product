package co.com.foodbank.product.sdk.exception;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.config.exception
 *         8/06/2021
 */
public class SDKProductServiceNotAvailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * @param e
     */
    public SDKProductServiceNotAvailableException(Exception e) {
        super(e);
    }
}
