package com.jsp.mock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


import com.jsp.mock.dto.Empyoedto;
@Component
public class Emploedao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public  void insert(Empyoedto empdto){
		
		   entityTransaction.begin();
		   entityManager.persist(empdto);
		   entityTransaction.commit();
		}
	public Empyoedto findbyid(int id){
		Empyoedto empdto=entityManager.find(Empyoedto.class, id);
		return empdto;
	}
	public  void deletedata(Empyoedto empdto){
		entityTransaction.begin();
		entityManager.remove(empdto);
		entityTransaction.commit();
	}
	
	public List<Empyoedto> fetchdata() {
		javax.persistence.Query query=entityManager.createQuery("select data from Empyoedto data");
		List<Empyoedto> empd=query.getResultList();
		return empd;
	}
	
}
