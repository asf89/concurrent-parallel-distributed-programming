package school.cesar.sd.cart.cartClient;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer implements Serializable {

    private String email;
    private String cep;
    private ArrayList<String> skus;
    private double cost;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCEP() {
        return this.cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    public ArrayList<String> getSkus() {
        return this.skus;
    }

    public void setSkus(String[] skus) {
        this.skus = new ArrayList<String>();
        for (String skusValue : skus) {
            this.skus.add(skusValue);
        }
    }
    /*
    public String getSkusToString() {
        String result = "";
        for (String skusValue: this.skus) {
            result += skusValue;
        }
        return result;
    }
    */

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    /*
    public Customer(@JsonProperty("e-mail") String email
                  , @JsonProperty("CEP") String cep
                  , @JsonProperty("skus") ArrayList<String> skus
                  , @JsonProperty("cost") double cost) {
        
        this.email = email;
        this.cep = cep;
        this.skus = skus;
        this.cost = cost;

    }
    */

    public Customer(String email, String cep, String[] skus, double cost) {
        this.setEmail(email);
        this.setCEP(cep);
        this.setSkus(skus);
        this.setCost(cost);
    }

    @Override
    public String toString() {
        return "{e-mail: " + this.getEmail() + "\n" + "CEP: " + this.getCEP() + "\n" + "Skus: " + this.skus.toString() + "\n" + "Cost: " + this.getCost() + "}";
    }
    
}