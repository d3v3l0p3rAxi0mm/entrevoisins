
package com.openclassrooms.entrevoisins.neighbour_profile;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.LaunchProfileNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
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
public class NeighbourProfileTest {

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
     * When we click an avatar of a neighbour, The Activity of profile must be launched
     */
    @Test
    public void myClickOnANeighbourInTheList_shouldLaunchProfileNeighbourActivity() throws InterruptedException {
        sleep(100);
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivity()));
        sleep(100);
        // Then : Layout of Profile Activity must be displayed
        onView(withId(R.id.frameLayoutNeighbourProfile)).check(matches(isDisplayed()));
    }

    /**
     * When we click on avatar of a neighbour, his/her page must be displayed
     */
    @Test
    public void myClickOnAnAvatarNeighbourInTheList_shouldDisplayProfileNeighbourActivityWithHisName() throws InterruptedException {
        sleep(100);
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(1, new LaunchProfileNeighbourActivity()));
        sleep(100);
        // Then : Name in TextView must be displayed
        onView(withId(R.id.item_profile_name)).check(matches(withText("Jack")));
    }


}