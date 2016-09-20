package br.com.magazineluizachallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magazineluizachallenge.model.TweetLog;

public interface RegisterTwitterRepository extends JpaRepository<TweetLog, Long>{

}
