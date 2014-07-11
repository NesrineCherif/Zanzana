package tn.edu.esprit.cinfo2.tunRecrute.service.dao.interfaces;

import java.util.List;

public interface IGenericDao<O> {
	
	boolean add(O object);

	boolean update(int id , O object);

	boolean remove(int id);

	List<O> findAll();

	O findById(int id);

}
