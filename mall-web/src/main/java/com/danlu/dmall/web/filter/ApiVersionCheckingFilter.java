package com.danlu.dmall.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class ApiVersionCheckingFilter extends OncePerRequestFilter {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request,
			final HttpServletResponse response, final FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("X-ApiVersion");
		if (null == header || !header.equals(this.version)) {
			response.sendError(415, "Api version is invalid.");
			return;
		}
		filterChain.doFilter(request, response);
	}
}
