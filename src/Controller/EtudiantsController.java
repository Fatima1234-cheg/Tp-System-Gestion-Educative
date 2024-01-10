package Controller;
import services.DB;
import lst.tpjava.Main;
import Models.Etudiant;
import Models.Enseignant;
import Models.Filiere;
import services.EnseignantsServices;
import services.EtudiantServices;
import services.FilieresServices;

public class EtudiantsController {

        public static void showMenu() {
                System.out.println("-------------------------[ Étudiants ]--------------------------");
                System.out.println("1: Pour ajouter un étudiant");
                System.out.println("2: Pour afficher les étudiants");
                System.out.println("3: Pour modifier un étudiant");
                System.out.println("4: Pour supprimer un étudiant");
                System.out.println("0: Pour retourner au menu principal");

                int option = Main.getIntInput("Veuillez sélectionner une option : ");
                switch (option) {
                        case 1:
                                createEtudiant();
                                break;
                        case 2:
                                showEtudiants();
                                break;
                        case 3:
                                editEtudiant();
                                break;
                        case 4:
                                destroyEtudiant();
                                break;
                        default:
                                Main.showPrincipalMenu();
                }
        }

        public static void showEtudiants() {
                for (Etudiant etudiant : DB.etudiants) {
                        System.out.print("Id : " + etudiant.getId());
                        System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
                        System.out.print(" | Email : " + etudiant.getEmail());
                        if (etudiant.getFiliere() != null) {
                                System.out.print(" | Filière : " + etudiant.getFiliere().getIntitule());
                        }
                        System.out.println("");
                }
        }

        public static void createEtudiant() {
                String nom = Main.getStringInput("Entrez le nom de l'étudiant :");
                String prenom = Main.getStringInput("Entrez le prénom de l'étudiant :");
                String email = Main.getStringInput("Entrez l'email de l'étudiant :");
                int apogee = Main.getIntInput("Entrez l'apogée de l'étudiant :");

                Filiere fil = FilieresServices.getFiliereById(Integer.parseInt("Entrez le nouvel id de filiere"));
                Enseignant prof = EnseignantsServices.getEnsById(Integer.parseInt("Entrez le nouvel ID du professeur (laissez vide si aucun) :"));


                EtudiantServices.addEtd(nom, prenom, email, apogee, fil);

                showEtudiants();
                showMenu();
        }

        public static void editEtudiant() {
                showEtudiants();
                int id = Main.getIntInput("Sélectionnez un étudiant par ID :");
                String nom = Main.getStringInput("Entrez le nouveau nom :");
                String prenom = Main.getStringInput("Entrez le nouveau prénom :");
                String email = Main.getStringInput("Entrez le nouvel email :");
                int apogee = Main.getIntInput("Entrez le nouvel apogée :");

                Filiere filiere = FilieresServices.getFiliereById(Integer.parseInt("Entrez le nouvel ID de la filière (laissez vide si aucun) :"));


                EtudiantServices.updateEtd(id, nom, prenom, email, apogee, filiere);

                showEtudiants();
                showMenu();
        }

        public static void destroyEtudiant() {
                showEtudiants();
                int id = Main.getIntInput("Sélectionnez un étudiant par ID :");
                EtudiantServices.deleteEtdById(id);
                showEtudiants();
        }
}
