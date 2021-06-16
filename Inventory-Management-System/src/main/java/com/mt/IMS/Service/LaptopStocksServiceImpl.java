package com.mt.IMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.IMS.Entities.LaptopStocks;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Repository.LaptopStocksRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LaptopStocksServiceImpl implements LaptopStocksService 
{
	@Autowired
	private LaptopStocksRepository lapRepo;
	
	@Override
	public List<LaptopStocks> getAllLaptopStocks() 
	{
		return lapRepo.findAll();
	}

	@Override
	public LaptopStocks getLaptopStocksById(long lapId) throws InvalidIdException 
	{
		LaptopStocks laptops = lapRepo.findById(lapId).orElseThrow(()-> new InvalidIdException("Not Found With Name : "+lapId));
		return laptops;
	}

	@Override
	public LaptopStocks addLaptopsInStocks(LaptopStocks lapStocks) 
	{
		log.info("Laptop added Successfully with Id : "+lapStocks.getLaptopId());
		return lapRepo.save(lapStocks);
	}

	@Override
	public LaptopStocks updateLaptopsInStocks(LaptopStocks lapStocks) throws InvalidIdException 
	{
		LaptopStocks laptops = lapRepo.findById(lapStocks.getLaptopId()).orElseThrow(()-> new InvalidIdException("Not Found With Name : "+lapStocks.getLaptopId()));
		laptops.setLaptopBrand(lapStocks.getLaptopBrand());
		laptops.setLaptopName(lapStocks.getLaptopName());
		laptops.setQuantity(lapStocks.getQuantity());
		return lapRepo.save(laptops);
	}

	@Override
	public String deleteLaptopStock(long lapId) throws InvalidIdException 
	{
		LaptopStocks laptop = lapRepo.findById(lapId).orElseThrow(()->new InvalidIdException("Director Not Found With Name : "+lapId+" So nothing to delete"));
		lapRepo.delete(laptop);
		return "The Laptop with Id : "+lapId+" is deleted Successfully";
	}

}
