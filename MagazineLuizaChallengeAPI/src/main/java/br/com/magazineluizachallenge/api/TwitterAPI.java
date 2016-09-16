package br.com.magazineluizachallenge.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magazineluizachallenge.service.RegisterTwitterService;

@RestController
@RequestMapping(TwitterAPI.TWITTER_BASE_URI)
public class TwitterAPI {
	
	
	public static final String TWITTER_BASE_URI = "api/twitter";

	@Autowired
	private Twitter twitter;

	@Autowired
	private RegisterTwitterService registerService;
 

	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweets() {
        
		List<Tweet> tweets =  this.twitter.timelineOperations().getUserTimeline("DevittChallenge");
	
		this.registerService.logBDTwitter(tweets);
		
		return tweets;

	}

}
