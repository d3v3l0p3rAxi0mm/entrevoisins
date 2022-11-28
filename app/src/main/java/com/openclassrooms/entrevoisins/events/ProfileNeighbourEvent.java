package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class ProfileNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public ProfileNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

}
