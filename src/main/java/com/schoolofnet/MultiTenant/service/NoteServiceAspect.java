package com.schoolofnet.MultiTenant.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.schoolofnet.MultiTenant.util.TenantContext;

@Component
@Aspect
public class NoteServiceAspect {
	
	@Before("execution(* com.schoolofnet.MultiTenant.service.NoteService.*(..)) && target(noteService) ")
	public void aroundExecution(JoinPoint join, NoteService noteService) throws Throwable {
		Filter filter = noteService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
		filter.setParameter("tenantId", TenantContext.getCurrentTenant());
		filter.validate();
	}
}
