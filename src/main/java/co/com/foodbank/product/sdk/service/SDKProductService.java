package co.com.foodbank.product.sdk.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.foodbank.product.sdk.exception.SDKProductServiceException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceIllegalArgumentException;
import co.com.foodbank.product.sdk.exception.SDKProductServiceNotAvailableException;
import co.com.foodbank.product.sdk.model.ResponseProductData;

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

    @Value("${urlSdkFindProduct}")
    private String urlSdkFindProduct;



    /**
     * Find a Product.
     */
    @Override
    public ResponseProductData findProductBid(String id)
            throws SDKProductServiceException,
            SDKProductServiceIllegalArgumentException,
            SDKProductServiceNotAvailableException, JsonMappingException,
            JsonProcessingException {

        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

        String response = restTemplate.exchange(urlSdkFindProduct + id,
                HttpMethod.GET, entity, String.class).getBody();


        return objectMapper.readValue(response,
                new TypeReference<ResponseProductData>() {});
    }



}
