package br.com.magazineluizachallenge.service;

import java.util.List;

import org.springframework.social.twitter.api.Tweet;

public interface RegisterTwitterService {

	
	abstract public void logBDTwitter(final List<Tweet> tweets); 
}
