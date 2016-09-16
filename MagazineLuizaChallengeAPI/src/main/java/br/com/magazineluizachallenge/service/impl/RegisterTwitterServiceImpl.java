package br.com.magazineluizachallenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import br.com.magazineluizachallenge.model.RegisterTwitter;
import br.com.magazineluizachallenge.repository.RegisterTwitterRepository;
import br.com.magazineluizachallenge.service.RegisterTwitterService;

@Service
public class RegisterTwitterServiceImpl implements RegisterTwitterService {

	@Autowired
	private RegisterTwitterRepository registerTwitterRepository;

	@Override
	public void logBDTwitter(final List<Tweet> tweets) {

		for (Tweet tweet : tweets) {

			this.registerTwitterRepository.save(setaInformacoesNoObjetoDeLog(tweet));
		}

	}

	private RegisterTwitter setaInformacoesNoObjetoDeLog(Tweet tweet) {

		RegisterTwitter registerTwitter = new RegisterTwitter();

		registerTwitter.setIdPostagem(tweet.getId());
		registerTwitter.setUsuario(tweet.getUser().getName());
		registerTwitter.setScreenName(tweet.getUser().getScreenName());
		registerTwitter.setProfileUrl(tweet.getUser().getProfileUrl());
		registerTwitter.setTextoPostagem(tweet.getText());
		registerTwitter.setHashTags(getHashTag(tweet.getEntities().getHashTags()));
		
		return registerTwitter;
	}

	
	private String getHashTag(List<HashTagEntity> hashTags){
		
		StringBuilder result = new StringBuilder();
		
		if (!hashTags.isEmpty()) {
			
			for (HashTagEntity hashTag : hashTags) {
                 
				result.append(hashTag.getText() + " ");
			}
		}
		
		return result.toString();
	}
}
