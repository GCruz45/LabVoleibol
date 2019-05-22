package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Participant;
import model.Tournament;

import java.io.File;

public class windowController {

    Tournament tournament;
    FileChooser chooser;
    File file;

    public void initialize() {
        tournament = new Tournament();
        chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        chooser.setInitialDirectory(new File("./src/data"));
        file = new File("./");
    }

    @FXML
    private TextField filePathTextBox;

    @FXML
    private Button searchSpectatorButton;

    @FXML
    private TextField spectatorId;

    @FXML
    private Label searchTimeSpectator;

    @FXML
    private Button searchParticipantButton;

    @FXML
    private TextField participantId;

    @FXML
    private Label searchTimeParticipant;

    @FXML
    private ImageView userImage;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label birthLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Button paintParticipantsButton;

    @FXML
    private Button paintSpectatorsButton;

    @FXML
    private void loadFile() {
        tournament.loadSpectators(filePathTextBox.getText());
        tournament.selectParticipants(tournament.getFirstSpectator());
    }

    @FXML
    void searchFile() {
        file = chooser.showOpenDialog(null);
        filePathTextBox.setText(file.toString());
    }

    @FXML
    private void searchParticipant() {
        Participant participant;
        System.out.println(tournament.getFirstParticipant().getName());
        participant = tournament.searchParticipant(Integer.valueOf(participantId.getText()), tournament.getFirstParticipant());

        if (participant == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Participant not found.");
            alert.showAndWait();
        } else {
            idLabel.setText(String.valueOf(participant.getId()));
            nameLabel.setText(participant.getName());
            lastNameLabel.setText(participant.getLastName());
            emailLabel.setText(participant.getEmail());
            genderLabel.setText(participant.getGender());
            countryLabel.setText(participant.getCountry());
            birthLabel.setText(participant.getBirthday());
            System.out.println(participant.getName());
        }
    }

    private void searchSpectator() {
    }

    private void loadData() {

    }
}
