
package com.openclassrooms.entrevoisins.neighbour_profile;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.LaunchProfileNeighbourActivityByClickOnAvatar;
import com.openclassrooms.entrevoisins.utils.LaunchProfileNeighbourActivityByClickOnName;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static java.lang.Thread.sleep;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighbourProfileInstrumentedTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

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
     * Test in GENERAL List
     * When we click an AVATAR of a neighbour, The ACTIVITY of profile must be LAUNCHED
     */
    @Test
    public void ClickOnAvatarNeighbourInGeneralList_shouldLaunchProfileNeighbourActivity() {
        // Click on the avatar of second element in the list of neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivityByClickOnAvatar()));
        // Then : Layout with Id "frameLayoutNeighbourProfile" of Profile Activity must be displayed
        onView(withId(R.id.frameLayoutNeighbourProfile))
                .check(matches(isDisplayed()));
    }

    /**
     * Test in GENERAL List
     * When we click an NAME of a neighbour, The ACTIVITY of profile must be LAUNCHED
     */
    @Test
    public void ClickOnNameNeighbourInGeneralList_shouldLaunchProfileNeighbourActivity() {
        // Click on the name of second element in the list of neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then : Layout with Id "frameLayoutNeighbourProfile" of Profile Activity must be displayed
        onView(withId(R.id.frameLayoutNeighbourProfile))
                .check(matches(isDisplayed()));
    }

    /**
     * Test in GENERAL List
     * When we click on the AVATAR of a neighbour, his/her NAME must be DISPLAYED
     */
    @Test
    public void ClickOnAvatarOfNeighbourInGeneralList_shouldDisplayProfileNeighbourActivityWithNeighbourName() {
        // Click on the avatar of second element in the list of neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivityByClickOnAvatar()));
        // Then : Name in TextView must be displayed
        onView(withId(R.id.item_profile_name))
                .check(matches(withText("Jack")));
    }

    /*
     * Test in GENERAL List
     * When we click on the NAME of a neighbour, his/her NAME must be DISPLAYED
     */
    @Test
    public void ClickOnNameOfNeighbourInGeneralList_shouldDisplayProfileNeighbourActivityWithNeighbourName() {
        // Click on the avatar of second element in the list of neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then : Name in TextView must be displayed
        onView(withId(R.id.item_profile_name))
                .check(matches(withText("Jack")));
    }



    /**
     * Test in FAVORITE List
     * When we click an AVATAR of a neighbour in Favorite, The ACTIVITY of profile must be LAUNCHED
     */
    @Test
    public void ClickOnAvatarNeighbourInFavoriteList_shouldLaunchProfileNeighbourActivity() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // Click on the only element of the list of Favorite neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new LaunchProfileNeighbourActivityByClickOnAvatar()));
        // Then : Layout with Id "frameLayoutNeighbourProfile" of Profile Activity must be displayed
        onView(withId(R.id.frameLayoutNeighbourProfile))
                .check(matches(isDisplayed()));
    }

    /**
     * Test in FAVORITE List
     * When we click an NAME of a neighbour in Favorite, The ACTIVITY of profile must be LAUNCHED
     */
    @Test
    public void ClickOnNameNeighbourInFavoriteList_shouldLaunchProfileNeighbourActivity() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // Click on the only element of the list of Favorite neighbours
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then : Layout with Id "frameLayoutNeighbourProfile" of Profile Activity must be displayed
        onView(withId(R.id.frameLayoutNeighbourProfile))
                .check(matches(isDisplayed()));
    }

    /**
     * Test in FAVORITE List
     * When we click on AVATAR of a neighbour in the FAVORITE List, his/her NAME must be DISPLAYED
     */
    @Test
    public void ClickOnAvatarNeighbourInFavoriteList_shouldDisplayProfileNeighbourActivityWithNeighbourName() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // click on the first neighbour
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new LaunchProfileNeighbourActivityByClickOnAvatar()));
        // Then : Name "Laetitia" in TextView must be displayed
        onView(withId(R.id.item_profile_name))
                .check(matches(withText("Laetitia")));
    }

    /**
     * Test in FAVORITE List
     * When we click on NAME of a neighbour in the FAVORITE List, his/her NAME must be DISPLAYED
     */
    @Test
    public void ClickOnNameNeighbourInFavoriteList_shouldDisplayProfileNeighbourActivityWithNeighbourName() {
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        // click on the first neighbour
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then : Name "Laetitia" in TextView must be displayed
        onView(withId(R.id.item_profile_name))
                .check(matches(withText("Laetitia")));
    }


}