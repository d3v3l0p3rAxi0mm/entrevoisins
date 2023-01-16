package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private Neighbour selectedNeighbour;

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
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        Predicate<Neighbour> isFavorite = Neighbour::getIsFavorite;
        return neighbours.stream().filter(isFavorite).collect(Collectors.toList());
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
        int neighbourIndex = neighbours.indexOf(neighbour);
        neighbour.setIsFavorite(false);
        // Update the list of neighbours with this new item
        neighbours.set(neighbourIndex, neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        int neighbourIndex = neighbours.indexOf(neighbour);
        neighbour.setIsFavorite(true);
        // Update the list of neighbours with this new item
        neighbours.set(neighbourIndex, neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void setSelectedNeighbour(Neighbour neighbour) {
        selectedNeighbour = neighbour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Neighbour getSelectedNeighbour() {
        return selectedNeighbour;
    }
}
