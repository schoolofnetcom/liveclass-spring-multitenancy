package com.schoolofnet.MultiTenant.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class TenantFilter implements Filter {

	private static final String TENANT_HEADER = "X-Tenant";

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		
		String tHeader = request.getHeader(TENANT_HEADER);
		
		if (tHeader != null && !tHeader.isEmpty()) {
			TenantContext.setCurrentTenant(tHeader);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		chain.doFilter(sRequest, sResponse);
	}
}
