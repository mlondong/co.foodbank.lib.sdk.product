package co.com.foodbank.product.sdk.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.foodbank.product.sdk.exception.SDKProductNotFoundException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceIllegalArgumentException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceNotAvailableException;
import co.com.foodbank.product.sdk.model.ResponseProductData;
import co.com.foodbank.product.sdk.util.UrlProduct;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.product.sdk.service
 *         25/06/2021
 */
@Service
@Validated
public class SDKProductService implements ISDKProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UrlProduct urlProduct;


    /**
     * Find a Product.
     * 
     * @throws SDKProductNotFoundException
     */
    @Override
    public ResponseProductData findProductById(String idProduct)
            throws SDKProductServiceException,
            SDKProductServiceIllegalArgumentException,
            SDKProductServiceNotAvailableException, JsonMappingException,
            JsonProcessingException, SDKProductNotFoundException {

        try {
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

            String response =
                    restTemplate
                            .exchange(urlProduct.tofindProductId(idProduct),
                                    HttpMethod.GET, entity, String.class)
                            .getBody();


            return objectMapper.readValue(response,
                    new TypeReference<ResponseProductData>() {});

        } catch (HttpClientErrorException i) {

            if (i.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new SDKProductServiceIllegalArgumentException(i);
            }
            if (i.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new SDKProductNotFoundException(idProduct,
                        i.getResponseBodyAsString());
            }
            throw new SDKProductServiceException(i);
        } catch (ResourceAccessException i) {
            throw new SDKProductServiceNotAvailableException(i);
        } catch (Exception i) {
            throw new SDKProductServiceException(i);
        }

    }



}
