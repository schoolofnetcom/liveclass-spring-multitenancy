package com.schoolofnet.MultiTenant.util;

public class TenantContext {

	private static ThreadLocal<String> currentTenant = new ThreadLocal<String>();
	
	public static String getCurrentTenant() {
		return currentTenant.get();
	}
	
	public static void setCurrentTenant(String tenant) {
		currentTenant.set(tenant);
	}
	
	public static void clear() {
		currentTenant.set(null);
	}
}
