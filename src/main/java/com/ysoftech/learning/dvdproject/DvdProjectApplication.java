package com.ysoftech.learning.dvdproject;

import com.ysoftech.learning.dvdproject.entity.Actor;
import com.ysoftech.learning.dvdproject.entity.Film;
import com.ysoftech.learning.dvdproject.repository.ActorSpringDataJpaRepository;
import com.ysoftech.learning.dvdproject.repository.FilmSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdProjectApplication implements CommandLineRunner {

	@Autowired
	private FilmSpringDataJpaRepository filmSpringDataJpaRepository;

	@Autowired
	private ActorSpringDataJpaRepository actorSpringDataJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DvdProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Film baahubali = new Film("Baahubali", 2018, (short) 300, Film.MPAA_RATING.NC_17);
		Actor prabhas = new Actor("Prabhas", "Raju");
		Actor anushka = new Actor("Anushka", "Shetty");
		actorSpringDataJpaRepository.save(prabhas);
		actorSpringDataJpaRepository.save(anushka);
		baahubali.addActors(prabhas);
		baahubali.addActors(anushka);
		filmSpringDataJpaRepository.save(baahubali);
	}
}