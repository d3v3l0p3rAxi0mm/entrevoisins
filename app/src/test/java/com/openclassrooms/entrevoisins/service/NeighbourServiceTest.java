package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
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

    /**
     * Test getNeighbours() must return DUMMY_NEIGHBOURS
     */
    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.generateNeighbours();
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    /**
     * Test getFavoriteNeighbours() must return one element only from DUMMY_NEIGHBOURS
     */
    @Test
    public void getFavoriteNeighboursWithSuccess() {
        List<Neighbour> favoriteNeighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedFavoriteNeighbours = new ArrayList<>();
        expectedFavoriteNeighbours.add(DummyNeighbourGenerator.generateNeighbours().get(6));
        assertThat(favoriteNeighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));
    }

    /**
     * Test deleteNeighbour() must not have Neighbour deleted in the list
     */
    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = DummyNeighbourGenerator.generateNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    /**
     * Test createNeighbour(), Neighbour created must appear in the list of Neighbour
     */
    @Test
    public void addNeighbourWithSuccess() {
        Neighbour neighbourToCreate = new Neighbour(
                100,
                "Anakin",
                "https://i.pravatar.cc/300",
                "Address",
                "+33 6 13 55 99 11",
                "https://facebook.fr/anakin",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                false);
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }

    /**
     * Test addFavoriteNeighbour(), Neighbour added must have its field isFavorite at True
     */
    @Test
    public void addNeighbourInFavoriteWithSuccess() {
        Neighbour neighbourToPutInFavorite = DummyNeighbourGenerator.generateNeighbours().get(0);
        neighbourToPutInFavorite.setIsFavorite(false);
        service.addFavoriteNeighbour(neighbourToPutInFavorite);
        assertTrue(neighbourToPutInFavorite.getIsFavorite());
    }

    /**
     * Test deleteNeighbourFromFavorite(), Neighbour deleted must have its field isFavorite at False
     */
    @Test
    public void deleteNeighbourFromFavoriteWithSuccess() {
        Neighbour neighbourToDeleteFromFavorite = DummyNeighbourGenerator.generateNeighbours().get(0);
        neighbourToDeleteFromFavorite.setIsFavorite(true);
        service.deleteFavoriteNeighbour(neighbourToDeleteFromFavorite);
        assertFalse(neighbourToDeleteFromFavorite.getIsFavorite());
    }
}
