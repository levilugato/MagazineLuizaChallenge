package br.com.magazineluizachallenge.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.magazineluizachallenge.model.TweetLog;
import br.com.magazineluizachallenge.service.RegisterTwitterService;


@RestController
@RequestMapping(TwitterAPI.TWITTER_BASE_URI)
public class TwitterAPI {
	
	
	public static final String TWITTER_BASE_URI = "/api/twitter";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Twitter twitter;

	@Autowired
	private RegisterTwitterService registerService;
 
	
	/**
	 * Método responsável por pesquisar e retornar
	 * postagens da timeline de um usuário do Twitter por meio 
	 * da operação timelineOperations().getUserTimeline do objeto Twitter (org.springframework.social.twitter.api.Twitter)
	 * 
	 * @param username
	 * @return List<Tweet>
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public List<Tweet> getTweets(@PathVariable("username") final String username) {
        
		List<Tweet> tweets = new ArrayList<>();
		
		try{	
		
		logger.info("Iniciando busca por postagens no Twitter do usuário: " + username);
		
		tweets =  this.twitter.timelineOperations().getUserTimeline(username);
	 
		logger.info("Classe TwitterAPI - Método: getTweets - Retornando postagens  do Twitter do usuário: : " + username);
				
		}catch(ResourceNotFoundException ex){
			
			logger.error("Erro - Classe TwitterAPI - Método: getTweets - Nome de usuário : " + username + " Inválido");
		}
		
		return tweets;
	}
	
	/**
	 * Método responsável por chamar rotina que loga informações dos tweets no banco de dados
	 * 
	 * @param TweetLog
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void logarTweetsNoBancoDeDados(@RequestBody List<TweetLog> tweets){
		
		if(!tweets.isEmpty()){
			
			logger.info("Classe TwitterAPI - Método: logarInformacoesPostagensNoBancoDeDados - Iniciando processo de log no banco de dados" );
			
			this.registerService.save(tweets);
		}else{
			logger.error("Erro - Classe TwitterAPI - Método: logarTweetsNoBancoDeDados - Não existe Informações para logar!");
		}
		
		
		
	}

}
