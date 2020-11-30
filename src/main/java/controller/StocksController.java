/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Stock;
import service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import model.Quote;
import service.QuotesService;


/**
 *
 * @author allan
 */
@RestController
@RequestMapping("/stock")
public class StocksController {
    @Autowired
    @PostMapping("")
    public static void createStock(@RequestBody Stock name, List<Quote> listOfquotes){
        StocksService.saveStock(new Stock(name.getName()));
        if(!(listOfquotes.equals(null))){
            QuotesService.saveStockQuotes(listOfquotes);
        }
    }
    
    @PatchMapping("/{stock_name}")
     public static ResponseEntity<?> updateStock(@RequestBody List<Quote> listOfQuotes, @PathVariable String stock_name) {
        try {
            Stock stock = StocksService.getStock(stock_name);
            stock.setName(stock_name);            
            QuotesService.saveStockQuotes(listOfQuotes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ResponseBody
    @GetMapping
    public static List<Stock> readAllStocks() {
        return StocksService.listAllStocks();
    }
    
    @ResponseBody 
    @GetMapping("?name={stock_name}")
    public static String readSpecificStock(@PathVariable String stock_name){
        try {
            Stock stock = StocksService.getStock(stock_name);
            return new String("name: " + stock.getName() + " quotes: " + QuotesService.getStockQuotes(stock.getName()));
        } catch (NoSuchElementException e) {
            return new String("Not found!");
        }
    }
    
    @DeleteMapping("/{stock_name}")
    public static void deleteStock(@PathVariable String stock_name){
        StocksService.deleteStock(stock_name);
    }
    
    @ResponseBody
    public static String defaultResponsePayload(){
        return new String();
    }  
}
