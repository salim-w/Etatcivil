package ma.projet.beans;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "hommes")
public class Homme extends Personne {

    @OneToMany(mappedBy = "homme")
    private List<Mariage> mariages;

    public Homme() {
        super();
    }

    public Homme(String nom, String prenom) {
        super(nom, prenom);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
}


