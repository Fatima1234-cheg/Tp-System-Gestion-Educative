package Models;

import java.util.ArrayList;

public class Departement {

    private int id;
    private String intitule;
    private Enseignant chef;

    ArrayList<Filiere> filieres = new ArrayList<Filiere>();


    public Departement() {
    }

    public Departement(String intitule, Enseignant chef) {
        this.intitule = intitule;
        this.chef = chef;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getChef() {
        return chef.getId();
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }
// les filiéres asssocies a ce département;
    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


