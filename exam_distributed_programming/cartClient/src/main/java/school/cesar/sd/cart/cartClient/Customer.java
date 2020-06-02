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
    
    public String getSkusToString() {
        
        String result = "";
        int i = 0;
        while (i <= (this.skus.size() - 1)) {

            if (i == (this.skus.size() - 1)) {
                result += this.skus.get(i);                
            } else {
                result += this.skus.get(i) + ", ";
            }
            
            i++;
        }

        return result;
    }
    

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public Customer(String email, String cep, String[] skus, double cost) {
        this.setEmail(email);
        this.setCEP(cep);
        this.setSkus(skus);
        this.setCost(cost);
    }

    @Override
    public String toString() {
        return "{e-mail: " + this.getEmail() + "\n" + "CEP: " + this.getCEP() + "\n" + "Skus: " + this.getSkusToString() + "\n" + "Cost: " + this.getCost() + "}";
    }
    
}