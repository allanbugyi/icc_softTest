/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Quote;
import repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author allan
 */
@Service
@Transactional
public class QuotesService {

    @Autowired
    private static QuotesRepository quotesRepository;
    /*public List<Quote> listAllStocks() {
        return quotesRepository.findAll();
    }*/

    public static void saveStockQuotes(List<Quote> quotes) {  
        for(Quote quote : quotes){
            quotesRepository.save(quote);
        }
    }

    public static Quote getStockQuotes(String stock_name) {
        return quotesRepository.findById(stock_name).get();
    }

    /*
    public void deleteStock(String name) {
        quotesRepository.deleteById(name);
    }*/
}
