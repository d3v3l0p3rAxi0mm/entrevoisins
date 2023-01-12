package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour from the favorite List
 */
public class DeleteFavoriteNeighbourEvent {

    /**
     * Neighbour to delete from favorite
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour Neighbour to ask for delete from favorite List
     */
    public DeleteFavoriteNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
