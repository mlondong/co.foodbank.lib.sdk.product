package co.com.foodbank.product.sdk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import co.com.foodbank.product.sdk.exception.SDKProductNotFoundException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceIllegalArgumentException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceNotAvailableException;
import co.com.foodbank.product.sdk.model.ResponseProductData;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.product.sdk.service
 *         25/06/2021
 */
public interface ISDKProductService {

    /**
     * Method to find a product.
     * 
     * @param id
     * @return {@code ResponseProductData}
     * @throws SDKProductServiceException
     * @throws SDKProductServiceIllegalArgumentException
     * @throws SDKProductServiceNotAvailableException
     */
    ResponseProductData findProductById(String id)
            throws SDKProductServiceException,
            SDKProductServiceIllegalArgumentException,
            SDKProductServiceNotAvailableException, JsonMappingException,
            JsonProcessingException, SDKProductNotFoundException;
}

