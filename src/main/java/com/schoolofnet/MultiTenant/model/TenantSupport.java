package com.schoolofnet.MultiTenant.model;

public interface TenantSupport {

	void setTenantId(String tenantId);
	String getTenantId();
}
