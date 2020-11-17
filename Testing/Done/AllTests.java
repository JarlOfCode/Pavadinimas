package Testing.Done;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArmorTest.class, BigBulletFactoryTest.class, BootsTest.class, BulletTest.class,
		CommandInvokerTest.class, FastBulletTest.class, HealthPotionTest.class, SmallBulletFactoryTest.class })
public class AllTests {

}
