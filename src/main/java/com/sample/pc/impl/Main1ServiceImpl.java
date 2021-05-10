package com.sample.pc.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.pc.entity.Main1;
import com.sample.pc.repository.Main1Repository;
import com.sample.pc.service.Main1Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class Main1ServiceImpl implements Main1Service{

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Main1ServiceImpl.class);
	
	@Autowired 
	private Main1Repository main1Repository;
	
	public boolean save() {
		ObjectMapper mapper = new ObjectMapper();
		  TypeReference<Main1> typeReference = new TypeReference<Main1>(){}; 
		  InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Bath&Bristol_Sample.json");
		  try { 
			  Main1 main = mapper.readValue(inputStream,typeReference);
			  main1Repository.save(main);	
			  System.out.println("Users Saved!");
			  
			 } catch(IOException e){
				 System.out.println("Unable to save users: " +e.getMessage());
				 log.error(e.getMessage());
			 } 
		  return true;
	}
}
