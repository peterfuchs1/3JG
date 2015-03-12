package test_rooms;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBad.class, TestBalkon.class, TestSchlafzimmer.class,
		TestVerkehrsflaeche.class, testWohnzimmer.class })
public class AllTests {

}
