package services;

import Models.Enseignant;
import Models.Filiere;
import Models.Module;

import java.util.ArrayList;

public class ModuleServices {

    public static Module addModule(String intitule, Enseignant chef,  Filiere filiere) {
        return  new Module();
    }

    public static Module updateModule(int id , String intitule, Enseignant chef,  Filiere filiere){
        return  new Module();
    }
    public static ArrayList<java.lang.Module> deleteModuleById(int id){
        return  DB.modules;
    }

    public static Module getModuleById(int id){
        return  new Module();
    }

    public static ArrayList<java.lang.Module> getAllModule(){
        return  DB.modules;
    }
}

