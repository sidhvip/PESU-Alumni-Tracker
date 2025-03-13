package edu.pes.service;

import java.util.List;
import edu.pes.entity.Alumni;
import edu.pes.entity.User;


public interface AlumniServiceInterface {

	public List<Alumni> findAll();

	public void save(Alumni alumni);

	public Alumni findById(int theId); 

	public void deleteById(int theId);
	
	public List<Alumni> findByYear(String year);

	public List<Alumni> findByDept(String dept);
	
	public List<Alumni> findByCourse(String course);
	
	public Alumni findBySrn(String srn);
	
	public void updateUser(User user);
}
