package s1023336.lab4.hw.s1023336_lab4;

import android.app.Application;
import android.test.ApplicationTestCase;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public ApplicationTest() {
        super(MainActivity.class);
    }
    public void setUp() throws Exception
    {

    }
    @Override
    public void tearDown() throws Exception
    {

    }
    public void testAddNote() throws Exception
    {

    }
    public void testEditNote() throws Exception
    {

    }
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}