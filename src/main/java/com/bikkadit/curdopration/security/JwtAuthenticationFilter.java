package com.bikkadit.curdopration.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bikkadit.curdopration.helper.AppConstant;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// get Token

		String requestToken = request.getHeader(AppConstant.KEY);

		// token exists in form of :Bearer 245436jjdwl

		String username = null;
		String token = null;

		if (requestToken != null && requestToken.startsWith(AppConstant.START_WITH)) {

			token = requestToken.substring(7);

			try {
				username = this.jwtTokenHelper.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println(AppConstant.UNABLE);
			} catch (ExpiredJwtException j) {
				System.out.println(AppConstant.EXPIRED);
			} catch (MalformedJwtException m) {
				System.out.println(AppConstant.INVALID_JWT);
			}
		} else {
			System.out.println(AppConstant.TOKEN_START);
		}

		// once we get the token ,now we will perform validation

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (this.jwtTokenHelper.validateToken(token, userDetails)) {

				// perfectly working
				// now next step :Authentication

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println(AppConstant.INVALID_JWT);
			}

		} else {
			System.out.println(AppConstant.IS_NULL);
		}
		filterChain.doFilter(request, response);
	}

}
