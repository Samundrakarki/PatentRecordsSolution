package com.knowledgepioneer.records.service;

import java.util.List;

import com.knowledgepioneer.records.entity.Records;
/**
 * RecordsService is a interface that calls the data access object to populate  
 * database, read all the objects of the database, delete the object of the database.
 * 
 */
public interface RecordsService {
	
	/**
	 * Read the information about the all patent stored in the database
	 * 
	 * @return List of the patents information present in the database
	 * */	
	public List<Records> findALL();
	
	/**
	 * Read the information of the patent of a specific element stored in database
	 * 
	 * @param theId id of a patent record in the database
	 * 
	 * */
	public Records findById(int theId);
	
	/**
	 * Delete the patent record from database
	 * 
	 * @param theId id of the patent record in the database
	 * */
	public void deleteById(int theId);

	/**
	 * Add a patent record to database 
	 * */
	public void addRecord();
}
