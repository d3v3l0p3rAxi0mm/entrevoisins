package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    //@Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteNeighbours = new ArrayList<>();
        for (Neighbour neighbour: neighbours) {
            if (neighbour.getIsFavorite()) {
                favoriteNeighbours.add(neighbour);
            }
        }
        return favoriteNeighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        // Create new Neighbour with favorite Status at "false"
        Neighbour updatedNeighbour = neighbour;
        updatedNeighbour.setIsFavorite(false);
        // Update the list of neighbours with this new item
        neighbours.set(neighbours.indexOf(neighbour), updatedNeighbour);
    }

    /**
     * {@inheritDoc}
     */
    public void addFavoriteNeighbour(Neighbour neighbour) {
        // Create new Neighbour with favorite Status at "true"
        Neighbour updatedNeighbour = neighbour;
        updatedNeighbour.setIsFavorite(true);
        // Update the list of neighbours with this new item
        neighbours.set(neighbours.indexOf(neighbour), updatedNeighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
}
