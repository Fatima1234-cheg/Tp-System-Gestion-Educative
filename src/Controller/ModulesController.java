package Controller;

import Models.Enseignant;
import Models.Filiere;
import lst.tpjava.Main;
import services.EnseignantsServices;
import services.FilieresServices;
import services.ModuleServices;

public class ModulesController {
    public static void showModule() {
        System.out.println("-------------------------[ Modules ]---------------------------");
        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }



 void editModule() {

        int id = Main.getIntInput("Sélectionnez un module par ID :");
        String nom = Main.getStringInput("Entrez le nouveau nom :");

        Enseignant prof = EnseignantsServices.getEnsById(Integer.parseInt("Entrez le nouvel ID de l'enseignant (laissez vide si aucun) :"));
        Filiere filiere = FilieresServices.getFiliereById(Integer.parseInt("Entrez le nouvel ID de la filière (laissez vide si aucun) :"));




        showModule();
    }
    public static void createModule(){

        String intitule = Main.getStringInput("Entrez l'intitulé :");
        FilieresController.showFilieres();
        int id = Main.getIntInput("Sélecionnez une filiere  par id :");
        EnseignantsController.showEnseignants();
        int idid = Main.getIntInput("Sélecionnez un professeur par id :");
        ModuleServices.addModule(intitule,EnseignantsServices.getEnsById(idid),FilieresServices.getFiliereById(id));

        showModule();


    }


    public static void destroyModule() {

        int id = Main.getIntInput("Sélectionnez un module par ID :");
        ModuleServices.deleteModuleById(id);

    }
}

