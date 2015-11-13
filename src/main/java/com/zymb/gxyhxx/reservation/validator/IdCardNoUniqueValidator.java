package com.zymb.gxyhxx.reservation.validator;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zymb.gxyhxx.reservation.annotation.IdCardNoUnique;
import com.zymb.gxyhxx.reservation.model.Reservation;

public  class IdCardNoUniqueValidator implements ConstraintValidator<IdCardNoUnique,String>{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void initialize(IdCardNoUnique unique) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public boolean isValid(String idCardNo, ConstraintValidatorContext constraintContext) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT DISTINCT reservation FROM Reservation reservation  WHERE reservation.idCardNo=:idCardNo");
        query.setParameter("idCardNo", idCardNo);
        Collection<Reservation> results=query.getResultList();
        if (results.isEmpty())return false;
        else return true;
		
	}

}
