
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListInstrumentedTest {

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
     * In General List
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void NeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * In Favorite List
     * When we go on favorite List, list must display only favorite Neighbour
     */
    @Test
    public void FavoriteNeighboursList_shouldDisplayOnlyFavoriteNeighbour() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // verify that list of favorite neighbours has only 1 element
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_FAVORITE_COUNT));
    }



}