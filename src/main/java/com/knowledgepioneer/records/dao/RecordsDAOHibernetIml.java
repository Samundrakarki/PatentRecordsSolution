package com.knowledgepioneer.records.dao;

import java.io.File;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.knowledgepioneer.records.entity.Records;
import com.knowledgepioneer.records.parsexml.ParseXML;

/**
 * Implementation of the RecordsDAO implemntation
 * 
 * */

@Repository
public class RecordsDAOHibernetIml implements RecordsDAO {

	private EntityManager entityManager;
	
	@Autowired
	public RecordsDAOHibernetIml(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Override
	public List<Records> findALL() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Records> theQuery = 
						currentSession.createQuery("from Records", Records.class);
		
		List<Records> records = theQuery.getResultList();
		
		return records;
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession
				.createQuery("delete from Records r where r.id=:recordsId");
		
		theQuery.setParameter("recordsId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public Records findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Records record = currentSession.get(Records.class, theId);
				
		return record;
	}


	@Override
	public void populateDB(){
		File folder = new File("input");
		ParseXML parsexml = new ParseXML();
		Records record;
		Session currentSession = entityManager.unwrap(Session.class);
		
		//read the xml file and parse it
		for(File file:folder.listFiles()) {
			record = new Records();
			if(file.getName().endsWith(".xml")) {
				parsexml.parseXMLFiles(file, record);
				currentSession.saveOrUpdate(record);		
			}
		}
		
	}

}
