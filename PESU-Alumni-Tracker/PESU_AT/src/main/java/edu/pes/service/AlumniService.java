package edu.pes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pes.repository.AlumniRepository;
import edu.pes.entity.Alumni;
import edu.pes.entity.User;


@Service
public class AlumniService implements AlumniServiceInterface {

	
	private AlumniRepository alumniRepository;


	@Autowired   
	public AlumniService(AlumniRepository obj)
	{
		
		alumniRepository=obj;
	}
	
	
	@Override
	public List<Alumni> findAll() {
	
		return alumniRepository.findAll();
	}

	@Override
	public void save(Alumni alumni) {
	
		alumniRepository.save(alumni);
	}

	@Override
	public Alumni findById(int theId) {
		
		Optional<Alumni> result=alumniRepository.findById(theId);
		
		Alumni alumni=null;
		
		if(result.isPresent())
		{
			alumni=result.get();
		}
		else {
			throw new RuntimeException("Did not find alumni id - " + theId);
		}
		return  alumni;
	}


	@Override
	public void deleteById(int theId) {
		alumniRepository.deleteById(theId);
	}


	@Override
	public List<Alumni> findByYear(String year) {
		
	return alumniRepository.findByYear(year);
	}


	@Override
	public List<Alumni> findByDept(String dept) {
		
		return alumniRepository.findByDept(dept);
	}


	@Override
	public List<Alumni> findByCourse(String course) {
		
		return alumniRepository.findByCourse(course);
	}

	@Override
	public Alumni findBySrn(String srn) {
		
		return alumniRepository.findBySrn(srn);
	}

	@Override
	public void updateUser(User user) {

		Alumni alumni = findBySrn(user.getSrn());
		if (alumni != null) {
			alumni.setUser(user);
			save(alumni);
		}

	}

}
