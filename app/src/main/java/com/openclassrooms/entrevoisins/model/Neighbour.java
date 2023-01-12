package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private long id;

    /** Full name */
    private String name;

    /** Avatar */
    private final String avatarUrl;

    /** Adress */
    private final String address;

    /** Phone number */
    private final String phoneNumber;

    /** WebSite */
    private final String webSite;

    /** About me */
    private final String aboutMe;

    /** Favorite */
    private boolean isFavorite;

    /**
     * Constructor
     * @param id id of Neighbour
     * @param name name of Neighbour
     * @param avatarUrl URL of Avatar Neighbour
     * @param address Postal Address of Neighbour
     * @param phoneNumber Phone Number of Neighbour
     * @param webSite of Neighbour
     * @param aboutMe Text which presents neighbour's History
     * @param isFavorite Boolean which place the Neighbour as Favorite or not
     */
    public Neighbour(long id, String name, String avatarUrl, String address,
                     String phoneNumber, String webSite, String aboutMe, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.webSite = webSite;
        this.aboutMe = aboutMe;
        this.isFavorite = isFavorite;
    }

    // Constructeur de recopie
    public Neighbour(Neighbour neighbour) {
        this.id = neighbour.getId();
        this.name = neighbour.getName();
        this.avatarUrl = neighbour.getAvatarUrl();
        this.address = neighbour.getAddress();
        this.phoneNumber = neighbour.getPhoneNumber();
        this.webSite = neighbour.getWebSite();
        this.aboutMe = neighbour.getAboutMe();
        this.isFavorite = neighbour.getIsFavorite();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebSite() { return webSite; }

    public String getAboutMe() {
        return aboutMe;
    }

    public boolean getIsFavorite() { return isFavorite; }

    public void setIsFavorite(boolean isFavorite) { this.isFavorite = isFavorite; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
