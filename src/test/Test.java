package test;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.service.FemmetService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
public class Test {
    private static Object hs;

    public static void main(String[] args) {
        FemmetService femmeService = new FemmetService();
        HommeService hommeService = new HommeService();
        MariageService mariageService = new MariageService();

        // 1. Créer 10 femmes et 5 hommes
        for (int i = 1; i <= 10; i++) {
            Femme femme = new Femme("Femme" + i, "PrenomF" + i);
            femmeService.create(femme);
        }

        for (int i = 1; i <= 5; i++) {
            Homme homme = new Homme("Homme" + i, "PrenomH" + i);
            hommeService.create(homme);
        }
    }
}
      




    
