package com.openclassrooms.entrevoisins;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.LaunchProfileNeighbourActivityByClickOnAvatar;
import com.openclassrooms.entrevoisins.utils.LaunchProfileNeighbourActivityByClickOnName;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursInstrumentedTest {

    // This is fixed
    private static final int ITEMS_COUNT = 12;
    private static final int ITEMS_FAVORITE_COUNT = 1;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        ListNeighbourActivity mActivity = mActivityRule.getActivity();
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
     * When we delete an item on the list of Neighbours, the item is no more shown
     */
    @Test
    public void NeighboursList_deleteAction_shouldRemoveItem() {
        // verify that list of neighbours has 12 elements
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(11, new DeleteViewAction()));
        // Then : the number of element must be 11
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When we create a new a neighbour, the list must have one item more
     */
    @Test
    public void CreateNeighbour_shouldIncreaseTheNumberOfNeighbourTo1() {
        // click on create neighbour bouton
        onView(allOf(ViewMatchers.withId(R.id.add_neighbour), isDisplayed()))
                .perform(click());
        // Fill the Name
        onView(ViewMatchers.withId(R.id.name))
                .perform(clearText(), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.name))
                .perform(typeText("MyName"), closeSoftKeyboard());
        // Fill the Phone Number
        onView(ViewMatchers.withId(R.id.phoneNumber))
                .perform(clearText(), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.phoneNumber))
                .perform(typeText("07 11 22 33 44"), closeSoftKeyboard());
        // fill the Address
        onView(ViewMatchers.withId(R.id.address))
                .perform(clearText(), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.address))
                .perform(typeText("My Address, MyZipCode MyCity"), closeSoftKeyboard());
        // Fill the Website
        onView(ViewMatchers.withId(R.id.webSite))
                .perform(clearText(), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.webSite))
                .perform(typeText("MyWebsite.com"), closeSoftKeyboard());
        // Fill the About Me
        onView(ViewMatchers.withId(R.id.aboutMe))
                .perform(clearText(), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.aboutMe))
                .perform(typeText("Lorem ipsum dolor sit amet, consectetur adipiscing elit."), closeSoftKeyboard());
        onView(allOf(ViewMatchers.withId(R.id.create), isDisplayed()))
                .perform(click());
        // We swipe the view pager to go to the General list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollLeft(true));
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT+1));
        // When perform a click on a delete icon of the last neighbour just created
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEMS_COUNT, new DeleteViewAction()));

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
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollLeft(true));
        // When perform a click on a the name of the first Element "Laeticia"
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(6, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then we put Laeticia in favorite again
        onView(ViewMatchers.withId(R.id.fav_neighbour))
                .perform(click());
    }

    /**
     * When we add a neighbour in the favorite, the favorite list must have one item more
     */
    @Test
    public void AddNeighbourInFavoriteList_shouldIncreaseTheNumberOfFavoriteTo1() {
        // We swipe the view pager to go to the general list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollLeft(true));
        // When perform a click on a Name of the Element 9
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(9, new LaunchProfileNeighbourActivityByClickOnName()));
        // Then we put neighbour in favorite
        onView(ViewMatchers.withId(R.id.fav_neighbour))
                .perform(click());
        onView(ViewMatchers.withId(R.id.back))
                .perform(click());
        // We swipe the view pager to go to the favorite list
        onView(ViewMatchers.withId(R.id.container))
                .perform(ViewPagerActions.scrollRight(true));
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(ITEMS_FAVORITE_COUNT+1));
        // remove this neighbour from favorite
        // When perform a click on a delete icon of the Element 9
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
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