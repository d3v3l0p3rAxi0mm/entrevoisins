package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "https://i.pravatar.cc/300?u=a042581f4e29026704d", "75000 Paris",
                    "+33 6 15 59 89 10", "https://facebook.fr/caroline", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti.", false),
            new Neighbour(2, "Jack", "https://i.pravatar.cc/300?u=a042581f4e29026704e", "33000 Bordeaux",
                    "+33 6 86 56 48 59", "https://facebook.fr/jack", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti. Ut hendrerit sagittis porttitor.", false),
            new Neighbour(3, "Chloé", "https://i.pravatar.cc/300?u=a042581f4e29026704f", "33500 Libourne",
                    "+33 6 36 57 90 37", "https://facebook.fr/chloe", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices.", false),
            new Neighbour(4, "Vincent", "https://i.pravatar.cc/300?u=a042581f4e29026704a", "33113 Saint-Symphorien",
                    "+33 6 26 23 50 48", "https://facebook.fr/vincent", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti. Ut hendrerit sagittis porttitor. Sed tempor quam sit amet condimentum consequat.", false),
            new Neighbour(5, "Elodie", "https://i.pravatar.cc/300?u=a042581f4e29026704b", "18000 Bourges",
                    "+33 6 48 10 40 20", "https://facebook.fr/elodie", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat.", false),
            new Neighbour(6, "Sylvain", "https://i.pravatar.cc/300?u=a042581f4e29026704c", "18170 Maisonnais",
                    "+33 6 13 55 99 11", "https://facebook.fr/sylvain", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti. Ut hendrerit sagittis porttitor. Sed tempor quam sit amet condimentum consequat. Maecenas bibendum lorem eget arcu aliquam gravida.", false),
            new Neighbour(7, "Laetitia", "https://i.pravatar.cc/300?u=a042581f4e29026703d", "33200 Bordeaux",
                    "+33 6 52 52 50 70", "https://facebook.fr/laeticia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices.", true),
            new Neighbour(8, "Dan", "https://i.pravatar.cc/300?u=a042581f4e29026703b", "75056 Paris",
                    "+33 6 23 29 27 59", "https://facebook.fr/dan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet.", false),
            new Neighbour(9, "Catherine", "https://i.pravatar.cc/300?u=a041581f4e23026c067", "33010 Bordeaux",
                    "+33 7 18 73 33 73", "https://facebook.fr/catherine", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices.", false),
            new Neighbour(11, "Emma", "https://i.pravatar.cc/300?u=a042581f4e29026706d", "33133 Galgon",
                    "+33 7 38 56 52 23", "https://facebook.fr/emma", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices.", false),
            new Neighbour(12, "Patrick", "https://i.pravatar.cc/300?u=a042581f4e29026702d", "44000 Nantes",
                    "+33 6 45 22 47 55", "https://facebook.fr/patrick", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti. Ut hendrerit sagittis porttitor.", false),
            new Neighbour(13, "Ludovic", "https://i.pravatar.cc/300?u=a042581f3e39026702d", "37000 Tours",
                    "+33 6 19 23 54 27", "https://facebook.fr/ludovic", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla scelerisque leo vitae suscipit volutpat. Quisque pretium eget dui quis volutpat. Cras consectetur iaculis sapien vitae ultrices. Nullam sollicitudin enim ante, id pharetra metus gravida nec. Nunc at libero nec nulla pellentesque aliquet. Suspendisse potenti. Ut hendrerit sagittis porttitor.", false)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }


}
