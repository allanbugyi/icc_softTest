/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author allan
 */
@Entity
@Table(name = "quotes")
public class Quote{
    @Id
    private String stockName;
    
    private float stockQuote;
    
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public float getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(float stockQuote) {
        this.stockQuote = stockQuote;
    }
            
}
