package s1023336.lab4.hw.s1023336_lab4;

import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    public ApplicationTest()
    {
        super(MainActivity.class);
    }
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    @Override
    public void tearDown() throws Exception {
        //solo.finishOpenedActivities();
    }
    public void testBasicAdd() throws Exception
    {
        solo.clickOnButton("4");
        solo.clickOnButton("9");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("8");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("+");
        solo.clickOnButton("=");
        boolean notesFound = solo.searchText("777");
        assertTrue("Note 1 and/or Note 2 are not found", notesFound);

    }
}