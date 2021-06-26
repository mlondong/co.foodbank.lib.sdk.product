package co.com.foodbank.product.sdk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

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


    @Value("${urlSdkProduct}")
    private String urlSdkProduct;


}
