package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * @return all my Neighbours {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * @return Favorite Neighbours {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour Neighbour to delete
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour from favorite List
     * @param neighbour neighbour to delete from favorite List
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);

    /**
     * add a neighbour in the Favorite List
     * @param neighbour Neighbour to add in favorite
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour Neighbour to create
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Keep in memory the selected neighbour when click in item of List of Neighbour
     * @param neighbour Neighbour to create
     */
    void setSelectedNeighbour(Neighbour neighbour);

    /**
     * @return the selected Neighbour {@link Neighbour}
     */
    Neighbour getSelectedNeighbour();
}
