/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Stock;
import repository.StocksRepository;
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
public class StocksService {
    @Autowired
    static private StocksRepository stocksRepository;
    public static List<Stock> listAllStocks() {
        return stocksRepository.findAll();
    }

    public static void saveStock(Stock stock) {
        stocksRepository.save(stock);
    }

    public static Stock getStock(String name) {
        return stocksRepository.findById(name).get();
    }

    public static void deleteStock(String name) {
        stocksRepository.deleteById(name);
    }
}
