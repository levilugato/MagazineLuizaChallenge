package br.com.magazineluizachallenge.service;

import java.util.List;

import br.com.magazineluizachallenge.model.TweetLog;

public interface RegisterTwitterService {

	
	abstract public void save(final List<TweetLog> tweets); 
}
