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
@Table(name = "stocks")
public class Stock {
    @Id
    private String name;
    
    public Stock(){
    }
    
    public Stock(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
