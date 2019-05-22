package model;

public class Spectator {

    int id;
    String name;
    String lastName;
    String email;
    String gender;
    String country;
    String photo;
    String birthday;
    Boolean isLeaf;

    Spectator leftSpectator;
    Spectator rightSpectator;

    public Spectator(String id, String name, String lastName, String email, String gender, String country, String photo, String birthday) {
        String fixedId = id.substring(0, 2) + id.substring(3);
        this.id = Integer.valueOf(fixedId);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.country = country;
        this.photo = photo;
        this.birthday = birthday;
    }

    Spectator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setLeaf() {
        isLeaf = leftSpectator == null && rightSpectator == null;
    }

    public Spectator getLeftSpectator() {
        return leftSpectator;
    }

    public void setLeftSpectator(Spectator leftSpectator) {
        this.leftSpectator = leftSpectator;
    }

    public Spectator getRightSpectator() {
        return rightSpectator;
    }

    public void setRightSpectator(Spectator rightSpectator) {
        this.rightSpectator = rightSpectator;
    }
}
