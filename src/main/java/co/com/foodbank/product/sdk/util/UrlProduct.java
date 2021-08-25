package co.com.foodbank.product.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Class to handle Url for sdk vault.
 * 
 * @author mauricio.londono@gmail.com co.com.foodbank.vault.sdk.util 25/08/2021
 */
@Component
@Validated
public class UrlProduct {

    @Value("${sdk.service.product.scheme}")
    private String urlScheme;

    @Value("${sdk.service.product.url}")
    private String urlBase;


    public String tofindProductId(String idProduct) {
        return UriComponentsBuilder.newInstance().scheme(urlScheme)
                .host(urlBase)
                .path(SDKProductParameters.PATH_FIND_PRODUCT + idProduct)
                .buildAndExpand(encode(idProduct)).toString();
    }



    /**
     * Method for encode
     * 
     * @param value url
     * @return utf8 encoded url
     */
    private String encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
