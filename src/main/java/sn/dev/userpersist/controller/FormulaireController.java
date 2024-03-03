package sn.dev.userpersist.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sn.dev.userpersist.entities.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FormulaireController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    EntityTransaction ets = em.getTransaction();
    @FXML
    private Button genererButton;
    @FXML
    private TextField login;

    @FXML
    private TextField nom;

    @FXML
    private PasswordField password;

    @FXML
    private TextField prenom;

    @FXML
    void clear(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void initialize() {
        // Ajoutez un gestionnaire d'événements pour le bouton "Generer"
        genererButton.setOnAction(this::generer);
    }

    @FXML
    void save(ActionEvent event) {
        try{
            ets.begin();
            UserEntity user = new UserEntity();
            user.setNomUser(nom.getText());
            user.setPrenomUser(prenom.getText());
            user.setLoginUser(login.getText());
            user.setPasswordUser(password.getText());
            em.persist(user);
            ets.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        em.close();
        emf.close();
    }

    @FXML
    void update(ActionEvent event) {

    }
    @FXML
    void generer(ActionEvent event) {
        String nomText = nom.getText();
        String prenomText = prenom.getText();

        if(!nomText.isEmpty() && !prenomText.isEmpty())
        {
            String premierLettreNom = nomText.substring(0, 1);
            String last = prenomText.substring(prenomText.length() - 1);
            String log = "jpa#" + premierLettreNom +last + "@fx";
            login.setText(log);
        }
    }
}
