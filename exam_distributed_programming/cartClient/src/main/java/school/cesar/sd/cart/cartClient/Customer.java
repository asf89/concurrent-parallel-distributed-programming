package school.cesar.sd.cart.cartClient;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private String email;
    private String cep;
    private ArrayList<String> skus;
    private double cost;

    public Customer(@JsonProperty("e-mail") String email
                  , @JsonProperty("CEP") String cep
                  , @JsonProperty("skus") ArrayList<String> skus
                  , @JsonProperty("cost") double cost) {
        
        this.email = email;
        this.cep = cep;
        this.skus = skus;
        this.cost = cost;

    }
    
}