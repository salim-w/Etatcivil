package ma.projet.beans;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "femmes")
public class Femme extends Personne {
    @OneToMany(mappedBy = "femme")
    private List<Mariage> mariages;

    public Femme() {
        super();
    }
    public Femme(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
}
  
