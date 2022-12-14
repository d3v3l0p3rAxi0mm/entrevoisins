package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get Favorite Neighbours
     * @return {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);

    /**
     * add a neighbour in the Favorite List
     * @param neighbour
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);
}
