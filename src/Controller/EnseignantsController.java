package Controller;

import Models.Enseignant;
import services.DB;
import services.EnseignantsServices;
import lst.tpjava.Main;
import services.DepartementServices;


public class EnseignantsController {

    public static void showMenu(){

    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );

//            if (! Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
            System.out.println("");
        }
    }


    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez le grade :");
        DepartementsController.showDepartements();
        int id = Main.getIntInput("Sélecionnez un departement par id :");
        EnseignantsServices.addEns(nom,prenom,email,grade,DepartementServices.getDeptById(id));
        showEnseignants();
        showMenu();


    }



    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("Entrez l'email :");
        String grade = Main.getStringInput("Entrez le grade :");
        DepartementsController.showDepartements();
        int idd = Main.getIntInput("Sélecionnez un departement par id :");
        EnseignantsServices.updateEns(id, nom,prenom,email,grade,DepartementServices.getDeptById(idd));

        showEnseignants();
        showMenu();
    }

    public static void destroyEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantsServices.getEnsById(id);
        showEnseignants();
    }}


