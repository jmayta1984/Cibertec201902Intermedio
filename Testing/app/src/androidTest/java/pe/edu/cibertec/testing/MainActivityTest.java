package pe.edu.cibertec.testing;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {
    MainActivity mainActivity;

    Instrumentation.ActivityMonitor monitor = getInstrumentation()
            .addMonitor(FizzBuzzActivity.class.getName(),null,false);

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view = mainActivity.findViewById(R.id.btFizzBuzz);
        assertNotNull(view);
    }

    @Test
    public void testFizzBuzzActivity() throws Exception{
        assertNotNull(mainActivity.findViewById(R.id.btFizzBuzz));

        onView(withId(R.id.btFizzBuzz)).perform(click());

        Activity fizzBuzzActivity =
                getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(fizzBuzzActivity);

        fizzBuzzActivity.finish();

    }




    @After
    public void tearDown() throws Exception{
        mainActivity = null;
    }
}
