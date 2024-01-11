import Models.Enseignant;
import services.DB;

import java.sql.*;

    public class Fatima {
        public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3306/mbd";
            String user = "root";
            String pwd = "";
            try {
                Connection cx = DriverManager.getConnection(url, user, pwd);
                System.out.println("Good Connection");
                String req1 = "CREATE TABLE IF NOT EXISTS Enseignants (\n" +
                        "idEns INT AUTO_INCREMENT PRIMARY KEY, \n" +
                        "nom VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                        "prenom VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                        "email VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                        "grade VARCHAR(50) CHARACTER SET utf8 NULL)";
                        ;

                try (Statement smt = cx.createStatement()) {
                    smt.executeUpdate(req1);
                    System.out.println("Un nouveau tableau 'Enseignants' a été créé avec succès.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Bad Connection");
                e.printStackTrace();
            }
        }


        public static void insertEnseigants(Enseignant enseignant, Connection cx) throws SQLException {
            String query = "INSERT INTO Enseignants (idens,nom,prenom,email,grade) values (?,'Fatima',?,?,?,?)";

            PreparedStatement ps = cx.prepareStatement(query);

            ps.setInt(1, DB.getEnsId());
            ps.setString(2, enseignant.getNom());
            ps.setString(3, enseignant.getPrenom());
            ps.setString(4, enseignant.getEmail());;
            ps.setString(5, enseignant.getGrade());

        }


        public static void deleteEnseignants(int id, Connection cx) throws SQLException {
            String query = "DELETE  from Enseignant where id = ?";
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();


        }

        public static void updateEnseignants(int idEns, String Nom, String prenom,String email,String grade, Connection cx) throws SQLException {
            String query = "UPDATE Enseignant SET Nom = ?, Prenom = ?,email=?,grade=? WHERE idEns = ?";
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, idEns);
            ps.setString(2,Nom);
            ps.setString(3, prenom);
            ps.setString(4,email);
            ps.setString(5,grade);

            ps.executeUpdate();
        }

    }







