package sn.isi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CV")
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String email;
    private String telephone;
    private String specialite;
    private String niveauEtude;
    private String experienceProfessionnelle;

    public void delete(CV cv) {
    }
}
