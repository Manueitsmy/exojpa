package fr.laposte.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class DossierAdministratif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tuteurNom;
	private String tuteurEmail;

	@OneToOne
	private Apprenant apprenants;
}
