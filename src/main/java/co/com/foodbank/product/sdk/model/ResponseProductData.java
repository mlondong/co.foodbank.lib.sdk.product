package co.com.foodbank.product.sdk.model;

import java.util.Date;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.product.sdk.model
 *         8/07/2021
 */
public class ResponseProductData {

    private String id;
    private Date dateExpiraton;
    private String name;
    private String description;
    private String brand;

    private boolean requiredRefrigeration;
    private Long expectedStorageLife;
    private Long storageTemperature;


    public ResponseProductData() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateExpiraton() {
        return dateExpiraton;
    }

    public void setDateExpiraton(Date dateExpiraton) {
        this.dateExpiraton = dateExpiraton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public boolean isRequiredRefrigeration() {
        return requiredRefrigeration;
    }


    public void setRequiredRefrigeration(boolean requiredRefrigeration) {
        this.requiredRefrigeration = requiredRefrigeration;
    }


    public Long getExpectedStorageLife() {
        return expectedStorageLife;
    }


    public void setExpectedStorageLife(Long expectedStorageLife) {
        this.expectedStorageLife = expectedStorageLife;
    }


    public Long getStorageTemperature() {
        return storageTemperature;
    }


    public void setStorageTemperature(Long storageTemperature) {
        this.storageTemperature = storageTemperature;
    }



}
