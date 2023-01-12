package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event
 */
public class ProfileNeighbourEvent {

    /**
     * Neighbour
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour Neighbour
     */
    public ProfileNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

}
