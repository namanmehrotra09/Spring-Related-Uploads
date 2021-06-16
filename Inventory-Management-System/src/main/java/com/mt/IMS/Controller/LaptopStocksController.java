package com.mt.IMS.Controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.IMS.Entities.LaptopStocks;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Service.LaptopStocksService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LaptopStocksController 
{
	@Autowired
	private LaptopStocksService lapService;
	
	@GetMapping("/stocksHome")
	public String home()
	{
		return "This is the Home Page to check the Stocks";
	}
	
	@GetMapping("/stocks")
	public List<LaptopStocks> getAllLaptopStocks()
	{
		return this.lapService.getAllLaptopStocks();
	}
	
	@GetMapping("/stocks/{id}")
	public ResponseEntity<String> getLaptopStocksById(@PathVariable(name = "id") long lapId) throws InvalidIdException
	{
		try 
		{
			log.info("Showing all the details of Directors by their Name"+lapId);
			LaptopStocks lapStocks = lapService.getLaptopStocksById(lapId);
			log.info("Showing all the details for Laptop : "+lapId);
			return ResponseEntity.ok().body("Displaying Details : "+lapStocks);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this Id : "+lapId);
			throw new InvalidIdException("Not found with Id : "+lapId);
		}
	}
	
	@PostMapping("/stocks")
	public ResponseEntity<String> addLaptopsInStocks(@RequestBody LaptopStocks lapStocks)
	{
		LaptopStocks laptops = this.lapService.addLaptopsInStocks(lapStocks);
		return ResponseEntity.ok().body("Laptop Is Added  :  "+laptops);
	}
	
	@PutMapping("/stocks/{id}")
	public ResponseEntity<String> updateLaptopsInStocks(@RequestBody LaptopStocks lapStocks) throws InvalidIdException
	{
		try 
		{
			log.info("Calling update Laptops method for Laptop Id : "+lapStocks.getLaptopId());
			LaptopStocks laptop = this.lapService.updateLaptopsInStocks(lapStocks);
			log.info("Showing all the details");
			return ResponseEntity.ok().body("Updated Successfully : "+laptop);
		} catch (Exception e) 
		{
			e.printStackTrace();
			log.error("Encountered Error, nothing found with this Id : "+lapStocks.getLaptopId());
			throw new InvalidIdException("The laptop with this Id "+lapStocks.getLaptopId()+" is not found");
		}
	}
	
	@DeleteMapping("stocks/{id}")
	public ResponseEntity<HttpStatus> deleteLaptopStock(@PathVariable(value="id") long lapId) throws InvalidIdException 
	{
		log.info("Calling delete Laptop method for Laptop with Id : "+lapId);
		this.lapService.deleteLaptopStock(lapId);
		log.info("Deletion of "+lapId+" is successful");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/stocks/sort")
	public ResponseEntity<List<LaptopStocks>> sortStocks()
	{
		log.info("Sorting all the details of available laptop Stocks by their price and if price is same then by their product type");
		List<LaptopStocks> laptopStocks = this.lapService.getAllLaptopStocks();
		List <LaptopStocks> laptopStocksSortedList = laptopStocks.stream()
				.sorted(Comparator.comparing(LaptopStocks::getPrice).thenComparing(LaptopStocks::getLaptopBrand)).collect(Collectors.toList());//ascending order
		log.info("Showing all the sorted details");
		return ResponseEntity.ok().body(laptopStocksSortedList);
	}
}
