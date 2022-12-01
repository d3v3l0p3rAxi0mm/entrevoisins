package com.openclassrooms.entrevoisins.neighbour_list;

        import android.support.test.espresso.contrib.RecyclerViewActions;
        import android.support.test.espresso.contrib.ViewPagerActions;
        import android.support.test.espresso.matcher.ViewMatchers;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;

        import com.openclassrooms.entrevoisins.R;
        import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
        import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;

        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
        import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
        import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
        import static org.hamcrest.CoreMatchers.allOf;
        import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListInstrumentedDeleteTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private static int ITEMS_FAVORITE_COUNT = 1;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

     /**
     * When we delete an item on the list of Neighbours, the item is no more shown
     */
    @Test
    public void NeighboursList_deleteAction_shouldRemoveItem() {
        // verify that list of neighbours has 12 elements
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element must be 11
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When we delete an item on the list of Neighbours, the item is no more shown in the Favorite,
     * but visible in the General List
     */
    @Test
    public void FavoriteNeighboursList_deleteAction_shouldRemoveItemFromFavoriteOnly() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // When perform a click on a delete icon of the first Element "Laeticia"
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        // Then : the number of element is 0
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_FAVORITE_COUNT-1));
        // We swipe the view pager to go to the General list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollLeft(true));
        // Then : the number of element must be ITEMS_COUNT
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT));
    }



}