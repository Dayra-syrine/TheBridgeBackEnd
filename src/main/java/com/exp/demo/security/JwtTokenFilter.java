package com.exp.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exp.demo.customexceptions.CustomException;
import com.exp.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		String token = jwtTokenProvider.resolveToken(httpServletRequest);
		try {
			if (token != null && jwtTokenProvider.validateToken(token)) {
				Authentication auth = jwtTokenProvider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
				//httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
			}
		} catch (CustomException ex) { // this is very important, since it guarantees the user
			// is not authenticated at all SecurityContextHolder.clearContext();
			httpServletResponse.sendError(ex.getHttpStatus().value(), ex.getMessage());
			return;
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	/*
	 * @Autowired private UserService userDetailsService;
	 * 
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(JwtTokenFilter.class);
	 * 
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain filterChain) throws
	 * ServletException, IOException { try {
	 * 
	 * String jwt = getJwt(request); if (jwt != null &&
	 * jwtTokenProvider.validateToken(jwt)) { String username =
	 * jwtTokenProvider.getUsername(jwt);
	 * 
	 * UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	 * UsernamePasswordAuthenticationToken authentication = new
	 * UsernamePasswordAuthenticationToken( userDetails, null,
	 * userDetails.getAuthorities()); authentication.setDetails(new
	 * WebAuthenticationDetailsSource().buildDetails(request));
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication); } }
	 * catch (Exception e) {
	 * logger.error("Can NOT set user authentication -> Message: {}", e); }
	 * 
	 * filterChain.doFilter(request, response); }
	 * 
	 * private String getJwt(HttpServletRequest request) { String authHeader =
	 * request.getHeader("Authorization");
	 * 
	 * if (authHeader != null && authHeader.startsWith("Bearer ")) { return
	 * authHeader.replace("Bearer ", ""); }
	 * 
	 * return null; }
	 */

}
