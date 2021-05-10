package com.sample.pc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.pc.entity.Main1;

@Repository
@Transactional
public interface Main1Repository extends JpaRepository<Main1,String>{

	
}
