package fr.laposte.jpa;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.jpa.model.Apprenant;
import fr.laposte.jpa.model.Competence;
import fr.laposte.jpa.model.DossierAdministratif;
import fr.laposte.jpa.model.SessionFormation;
import fr.laposte.jpa.repository.ApprenantRepository;
import fr.laposte.jpa.repository.CompetenceRepository;
import fr.laposte.jpa.repository.DossierAdministratifRepository;
import fr.laposte.jpa.repository.SessionFormationRepository;

@SpringBootTest
class JpaExoApplicationTests {
	@Autowired
	
	private ApprenantRepository apprenants;

	@Autowired
	private CompetenceRepository competences;

	@Autowired
	private SessionFormationRepository sessions;

	@Autowired
	private DossierAdministratifRepository dossiers;

	@BeforeEach
	void clean() {

		apprenants.deleteAll();
		dossiers.deleteAll();
		competences.deleteAll();
		sessions.deleteAll();
	}

	@Test
	void contextLoads() {

		SessionFormation cda = new SessionFormation();
		cda.setLibelle("cda 2023");
		sessions.save(cda);

		Competence informatique = new Competence();
		informatique.setLibelle("Python");
		competences.save(informatique);
		
		Apprenant sev = new Apprenant();
		sev.setNom("sev");
		sev.setPrenom("zap");
		sev.setSessions(cda);
		
		Set<Competence> competencesSev= new HashSet<>();
		competencesSev.add(informatique);
		sev.setCompetences(competencesSev);;
		apprenants.save(sev);

        DossierAdministratif dossier = new DossierAdministratif();
        dossier.setTuteurNom("Dupont");
        dossier.setTuteurEmail("dupont.j@free.fr");
        dossiers.save(dossier);
        apprenants.save(sev);
		
	}

}
