package model;

import java.util.Date;

public class Participant extends Spectator {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String country;
    private String photo;
    private String birthday;

    Participant previousParticipant;
    Participant nextParticipant;

    public Participant(Spectator spectator) {
        this.id = spectator.id;
        this.name = spectator.name;
        this.lastName = spectator.lastName;
        this.email = spectator.email;
        this.gender = spectator.gender;
        this.country = spectator.country;
        this.photo = spectator.photo;
        this.birthday = spectator.birthday;
    }


}
