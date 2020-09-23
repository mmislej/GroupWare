package testSuite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@SelectPackages("testSuite")
@IncludeTags("run")
@RunWith(JUnitPlatform.class)
public class PlayTestSuite {

}


