package com.knowledgepioneer.records.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.knowledgepioneer.records.entity.Records;
import com.knowledgepioneer.records.service.RecordsService;


/**
 * RecordsRestController is a request handler class that provides the implemntation
 * for RESTful web services.
 * 
 * */
@RestController
@RequestMapping("/api")
public class RecordsRestController {
	
	private RecordsService  recordsService;
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	public RecordsRestController(RecordsService recordsService) {
		this.recordsService = recordsService;
	}
	
	
	/**
	 * This method is used to populate the database on /populateDB request
	 * 
	 * @return the message which gives the status of addition of data to database
	 * */
	@PostMapping("/populateDB")
	public String addRecords() {
		List<Records> records = recordsService.findALL();
		
		if(!records.isEmpty()) {
			return "Data is already present in the database";
		}
		
		
		recordsService.addRecord();
		return "Data sucessfully added to db";
	}
	
	/**
	 * This method is used to populate the database on /populateDB request
	 * 
	 * @return the message which gives the status of addition of data to database
	 * */
	@GetMapping("/records/{recordsId}")
	public Records getRecord(@PathVariable int recordsId) {
		Records theRecord = recordsService.findById(recordsId);
		
		if(theRecord == null) {
			throw new RuntimeException("Record not found - " + recordsId);
		}
		return theRecord;
	}
	
	/**
	 * This method is used to read all records of the database on /rest request
	 * 
	 * @return the list of records
	 * */
	@GetMapping("/records")
	public List<Records> getAllRecords() {
		return recordsService.findALL();
	}
	
	/**
	 * This method is used to delete records of the database on /rest request
	 * 
	 * @return the message which gives the status of deletion of data from database
	 * */
	@DeleteMapping("/records/{recordsId}")
	public String deleteRecords(@PathVariable int recordsId) {
		
		Records theRecord = recordsService.findById(recordsId);
		
		if(theRecord == null) {
			throw new RuntimeException("Record not found - " + recordsId);
		}
		
		recordsService.deleteById(recordsId);
		
		return "Deleted record with id - " + recordsId;
	}
}
