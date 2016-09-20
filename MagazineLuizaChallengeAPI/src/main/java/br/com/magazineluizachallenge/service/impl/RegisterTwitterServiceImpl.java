package br.com.magazineluizachallenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magazineluizachallenge.model.TweetLog;
import br.com.magazineluizachallenge.repository.RegisterTwitterRepository;
import br.com.magazineluizachallenge.service.RegisterTwitterService;

@Service
public class RegisterTwitterServiceImpl implements RegisterTwitterService {

	@Autowired
	private RegisterTwitterRepository registerTwitterRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	/**
	 * Método responsável por percorrer a lista de objetos do Tipo  TweetLog
	 * e salvar os mesmos no bando de dados
	 * 
	 * @param List<TweetLog>
	 */
	@Override
	public void save(final List<TweetLog> tweets) {

		logger.info("Classe RegisterTwitterServiceImpl - Método save: iniciando processo para salvar informações no banco de dados");
		
		try {

			for (TweetLog tweet : tweets) {
           
				this.registerTwitterRepository.save(tweet);

			}
			
		} catch (Throwable ex) {

			logger.error(
					"Erro Classe RegisterTwitterServiceImpl - Método save - erro ao salvar informações das postagens no banco de dados : "
							+ ex.getCause());
		}

	}

}
