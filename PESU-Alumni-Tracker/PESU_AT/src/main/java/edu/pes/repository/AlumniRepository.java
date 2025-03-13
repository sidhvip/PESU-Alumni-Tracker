package edu.pes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pes.entity.Alumni;


@Repository("alumniRepository")
public interface AlumniRepository extends JpaRepository<Alumni, Integer> {

	List<Alumni> findByYear(String div);

	List<Alumni> findByDept(String div);
	
	List<Alumni> findByCourse(String div);
	
	Alumni findBySrn(String div);
}