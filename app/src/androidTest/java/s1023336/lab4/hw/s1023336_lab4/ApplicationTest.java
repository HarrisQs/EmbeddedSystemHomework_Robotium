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
        solo.finishOpenedActivities();
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
        boolean AddWrong = solo.searchText("777");
        assertTrue("Add Wrong", AddWrong);
    }
    public void testBasicBSub() throws Exception
    {
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");
        boolean SubWrong = solo.searchText("-1");
        assertTrue("Sub Wrong", SubWrong);
    }
    public void testBasicCMul() throws Exception
    {
        solo.clickOnButton("8");
        solo.clickOnButton("9");
        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("=");
        boolean MulWrong = solo.searchText("5073");
        assertTrue("Mul Wrong", MulWrong);
    }
    public void testBasicDiv() throws Exception
    {
        solo.clickOnButton("7");
        solo.clickOnButton("3");
        solo.clickOnButton("1");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("5");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("=");
        boolean DivWrong = solo.searchText("2.85546875");
        assertTrue("Div Wrong", DivWrong);
    }
    public void testBasicDiv2() throws Exception
    {
        solo.clickOnButton("7");
        solo.clickOnButton("3");
        solo.clickOnButton("1");
        solo.clickOnButton("Space");
        solo.clickOnButton("0");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("=");
        boolean Div2Wrong = solo.searchText("731 0 ");
        assertTrue("Div2 Wrong", Div2Wrong);
    }
    public void testEDul2Oct2Dec() throws Exception
    {
        solo.clickOnRadioButton(1);
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnRadioButton(2);
        boolean Dul2Oct2DecWrong = solo.searchText("12");
        assertTrue("Dul2Oct2Dec Wrong", Dul2Oct2DecWrong);
        solo.clickOnButton("Space");
        solo.clickOnButton("6");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("=");
        Dul2Oct2DecWrong = solo.searchText("1022");
        assertTrue("Dul2Oct2Dec Wrong", Dul2Oct2DecWrong);
        solo.clickOnRadioButton(0);
        Dul2Oct2DecWrong = solo.searchText("530");
        assertTrue("Dul2Oct2Dec Wrong", Dul2Oct2DecWrong);

    }
   public void testFDul2Dec2Oct() throws Exception
   {
       solo.clickOnRadioButton(1);//”101101001111”
       solo.clickOnButton("1");
       solo.clickOnButton("0");
       solo.clickOnButton("1");
       solo.clickOnButton("1");
       solo.clickOnButton("0");
       solo.clickOnButton("1");
       solo.clickOnButton("0");
       solo.clickOnButton("0");
       solo.clickOnButton("1");
       solo.clickOnButton("1");
       solo.clickOnButton("1");
       solo.clickOnButton("1");
       solo.clickOnRadioButton(0);
       boolean Dul2Dec2OctWrong = solo.searchText("2895");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);
       solo.clickOnButton("Space");
       solo.clickOnButton("5");
       solo.clickOnButton("Space");
       solo.clickOnButton("/");
       solo.clickOnButton("=");
       Dul2Dec2OctWrong = solo.searchText("579");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);
       solo.clickOnRadioButton(2);
       Dul2Dec2OctWrong = solo.searchText("1103");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);

   }
   public void testGDul2Dec2Ocit() throws Exception
   {
       solo.clickOnButton("3");
       solo.clickOnButton("4");
       solo.clickOnButton("1");
       solo.clickOnRadioButton(1);
       boolean Dul2Dec2OctWrong = solo.searchText("101010101");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);
       solo.clickOnButton("Space");
       solo.clickOnRadioButton(2);
       solo.clickOnButton("Space");
       solo.clickOnButton("4");
       solo.clickOnButton("7");
       solo.clickOnButton("5");
       solo.clickOnRadioButton(1);
       Dul2Dec2OctWrong = solo.searchText("100111101");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);
       solo.clickOnButton("Space");
       solo.clickOnButton("-");
       solo.clickOnButton("=");
       Dul2Dec2OctWrong = solo.searchText("11000");
       assertTrue("Dul2Dec2Oct Wrong", Dul2Dec2OctWrong);
   }
    public void testHPosfix1() throws Exception
    {
        solo.clickOnButton("4");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("8");
        solo.clickOnButton("Space");
        solo.clickOnButton("+");
        solo.clickOnButton("Space");
        solo.clickOnButton("5");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("Space");
        solo.clickOnButton("4");
        solo.clickOnButton("7");
        solo.clickOnButton("Space");
        solo.clickOnButton("*");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");
        boolean Posfix1Wrong = solo.searchText("-237");
        assertTrue("Posfix1 Wrong", Posfix1Wrong);
    }

   public void testIPosfix2() throws Exception
   {
       solo.clickOnButton("7");
       solo.clickOnButton("2");
       solo.clickOnButton("Space");
       solo.clickOnButton("3");
       solo.clickOnButton("7");
       solo.clickOnButton("Space");
       solo.clickOnButton("6");
       solo.clickOnButton("*");
       solo.clickOnButton("8");
       solo.clickOnButton("3");
       solo.clickOnButton("Space");
       solo.clickOnButton("5");
       solo.clickOnButton("=");
       boolean Posfix2Wrong = solo.searchText("Wrong andwer");
       assertTrue("Posfix2 Wrong", Posfix2Wrong);
   }
   public void testJPoint1() throws Exception
   {
       solo.clickOnButton("4");
       solo.clickOnButton(".");
       solo.clickOnButton("8");
       solo.clickOnButton("Space");
       solo.clickOnButton("5");
       solo.clickOnButton(".");
       solo.clickOnButton("7");
       solo.clickOnButton("Space");
       solo.clickOnButton("+");
       solo.clickOnButton("Space");
       solo.clickOnButton("0");
       solo.clickOnButton(".");
       solo.clickOnButton("5");
       solo.clickOnButton("Space");
       solo.clickOnButton("/");
       solo.clickOnButton("Space");
       solo.clickOnButton("8");
       solo.clickOnButton(".");
       solo.clickOnButton("6");
       solo.clickOnButton("*");
       solo.clickOnButton("Space");
       solo.clickOnButton("1");
       solo.clickOnButton(".");
       solo.clickOnButton("9");
       solo.clickOnButton("Space");
       solo.clickOnButton("-");
       solo.clickOnButton("=");
       boolean Point1Wrong = solo.searchText("178.7");
       assertTrue("Point1 Wrong", Point1Wrong);
   }
   public void testKPoint2() throws Exception
   {
       solo.clickOnButton("0");
       solo.clickOnButton(".");
       solo.clickOnButton(".");
       solo.clickOnButton("2");
       boolean Point2Wrong = solo.searchText("0.2");
       assertTrue("Point2 Wrong", Point2Wrong);
   }
   public void testLScal1() throws Exception
   {
       solo.clickOnButton("1");
       solo.clickOnButton("0");
       solo.clickOnButton("Space");
       solo.clickOnButton("N!");
       solo.clickOnButton("=");
       boolean Scal1Wrong = solo.searchText("3628800");
       assertTrue("Scal1 Wrong", Scal1Wrong);
   }
    public void testMScal2() throws Exception
    {
        solo.clickOnButton("2");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("N!");
        solo.clickOnButton("=");
        boolean Scal1Wrong = solo.searchText("403291461126605635584000000");
        assertTrue("Scal2 Wrong", Scal1Wrong);
    }
   public void testzy2() throws Exception//沒有處理異位的情況
   {
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("9");
       solo.clickOnButton("Space");
       solo.clickOnButton("N!");
       solo.clickOnButton("=");
   }

    public void testNMy1() throws Exception//沒有處理CLean的情況
    {
        solo.clickOnButton("1");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("5");
        solo.clickOnButton("6");
        solo.clickOnButton("Space");
        solo.clickOnButton("/");
        solo.clickOnButton("=");
        solo.clickOnButton("Space");
        solo.clickOnButton("2");
        solo.clickOnButton("Space");
        solo.clickOnButton("-");
        solo.clickOnButton("=");
        solo.clickOnButton("Clean");
        boolean DivWrong = solo.searchText("");
        assertTrue("Div Wrong", DivWrong);
    }
   }