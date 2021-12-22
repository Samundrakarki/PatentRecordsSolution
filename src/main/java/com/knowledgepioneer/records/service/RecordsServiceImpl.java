package com.knowledgepioneer.records.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knowledgepioneer.records.dao.RecordsDAO;
import com.knowledgepioneer.records.entity.Records;

@Service
public class RecordsServiceImpl implements  RecordsService{

	private RecordsDAO recordsDAO;
	
	public RecordsServiceImpl(RecordsDAO recordsDAO) {
		this.recordsDAO = recordsDAO;
	}
	
	@Override
	@Transactional
	public List<Records> findALL() {
		return recordsDAO.findALL();
	
	}
	
	
	@Override
	@Transactional
	public void addRecord() {
		recordsDAO.populateDB();
	
	}
	
	@Override
	@Transactional
	public Records findById(int theId) {
		return recordsDAO.findById(theId);
	
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		recordsDAO.deleteById(theId);
	}

}
