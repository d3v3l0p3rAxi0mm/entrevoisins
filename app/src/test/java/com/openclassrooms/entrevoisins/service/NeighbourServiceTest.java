package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import android.util.Log;

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
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    /**
     * Test getNeighbours() must return DUMMY_NEIGHBOURS
     */
    @Test
    public void getFavoriteNeighboursWithSuccess() {
        service = DI.getNewInstanceApiService();
        Neighbour laetitia = new Neighbour(
                7,
                "Laetitia",
                "https://i.pravatar.cc/300?u=a042581f4e29026703d",
                "33200 Bordeaux",
                "+33 6 52 52 50 70",
                "https://facebook.fr/laeticia",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices.",
                true);
        List<Neighbour> favoriteNeighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedFavoriteNeighbours = new ArrayList<>();
        expectedFavoriteNeighbours.add(laetitia);
        assertThat(favoriteNeighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));
    }

}
