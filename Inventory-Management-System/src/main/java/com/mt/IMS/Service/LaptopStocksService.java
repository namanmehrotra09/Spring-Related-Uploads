package com.mt.IMS.Service;

import java.util.List;

import com.mt.IMS.Entities.LaptopStocks;
import com.mt.IMS.Exception.InvalidIdException;

public interface LaptopStocksService 
{

	public List<LaptopStocks> getAllLaptopStocks();

	public LaptopStocks getLaptopStocksById(long lapId) throws InvalidIdException;

	public LaptopStocks addLaptopsInStocks(LaptopStocks lapStocks);

	public LaptopStocks updateLaptopsInStocks(LaptopStocks lapStocks) throws InvalidIdException;

	public String deleteLaptopStock(long lapId) throws InvalidIdException;
	
	
}
