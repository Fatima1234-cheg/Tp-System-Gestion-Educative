package Controller;
import lst.tpjava.Main;
import services.DepartementServices;
import services.EnseignantsServices;
import services.FilieresServices;
import Models.Departement;
import Models.Enseignant;
import Models.Filiere;
import services.DB;
public class FilieresController {

    public static void showMenu() {
        System.out.println("-------------------------[ Filières ]---------------------------");
        System.out.println("1: Pour ajouter une filière");
        System.out.println("2: Pour afficher les filières");
        System.out.println("3: Pour modifier une filière");
        System.out.println("4: Pour supprimer une filière");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showFilieres() {
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Nom : " + filiere.getIntitule());
            if (filiere.getResponsable() != null) {
                System.out.print(" | Chef : " + filiere.getResponsable().getNom() + " " + filiere.getResponsable().getPrenom());
            }
            if (filiere.getDept() != null) {
                System.out.print(" | Département : " + filiere.getDept().getIntitule());
            }
            System.out.println("");
        }
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez le nom de la filière :");
        Enseignant chef = EnseignantsServices.getEnsById(Integer.parseInt("Entrez l'ID du chef de département (laissez vide si aucun) :"));
        Departement dept = DepartementServices.getDeptById(Integer.parseInt("Entrez l'ID du département (laissez vide si aucun) :"));

        FilieresServices.addFiliere(intitule, chef, dept);

        showFilieres();
        showMenu();
    }

    public static void editFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par id :");
        String intitule = Main.getStringInput("Entrez le nouveau nom :");
        Enseignant chef = EnseignantsServices.getEnsById(Integer.parseInt("Entrez le nouvel ID du chef de département (laissez vide si aucun) :"));
        Departement dept = DepartementServices.getDeptById(Integer.parseInt("Entrez le nouvel ID du département (laissez vide si aucun) :"));

        FilieresServices.updateFiliere(id, intitule, chef, dept);

        showFilieres();
        showMenu();
    }

    public static void destroyFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filière par id :");
        FilieresServices.deleteFiliereById(id);
        showFilieres();
    }}