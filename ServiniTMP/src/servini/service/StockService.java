package servini.service;

import java.util.List;

import servini.bean.Stock;
import servini.dao.Service;

public class StockService extends Service<Stock> {

	public void addStock(Stock o) {
		super.addObjet(o);
	}

	public List<Stock> getAllStock() {
		return super.getAllObjets("Stock");
	}

	public Stock getStockById(int id) {
		return super.getById(Stock.class, id);
	}

	public void deleteStock(Stock o) {
		super.deleteObjet(Stock.class, o.getIdStock());
	}

	public void updateStock(Stock obj) {
		super.updateObjet(obj);
	}
}
