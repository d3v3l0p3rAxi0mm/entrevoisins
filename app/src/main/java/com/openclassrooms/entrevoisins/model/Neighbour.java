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
    private String avatarUrl;

    /** Adress */
    private String address;

    /** Phone number */
    private String phoneNumber;

    /** WebSite */
    private String webSite;

    /** About me */
    private String aboutMe;

    /** Favorite */
    private boolean isFavorite;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param address
     * @param phoneNumber
     * @param webSite
     * @param aboutMe
     * @param isFavorite
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

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebSite() { return webSite; }

    public void setWebSite(String webSite) { this.webSite = webSite; }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
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
