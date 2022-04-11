package com.mcs.total.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcs.total.domain.Skintest;

public interface SkinRepository extends JpaRepository<Skintest, Integer>{
	
	@Query(value = "select count(baumann) cnt from skintest group by baumann", nativeQuery = true)
	List<Integer> findSkin();
}
