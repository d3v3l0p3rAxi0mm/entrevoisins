package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourInFavoriteWithSuccess() {
        Neighbour neighbourToPutInFavorite = service.getNeighbours().get(0);
        neighbourToPutInFavorite.setIsFavorite(false);
        service.addFavoriteNeighbour(neighbourToPutInFavorite);
        assertTrue(neighbourToPutInFavorite.getIsFavorite());
    }

    @Test
    public void deleteNeighbourFromFavoriteWithSuccess() {
        Neighbour neighbourToDeleteFromFavorite = service.getNeighbours().get(0);
        neighbourToDeleteFromFavorite.setIsFavorite(true);
        service.deleteFavoriteNeighbour(neighbourToDeleteFromFavorite);
        assertFalse(neighbourToDeleteFromFavorite.getIsFavorite());
    }

}
