package suiteprueba;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@SelectPackages("suitedardesca")
@IncludeTags("ok")
@RunWith(JUnitPlatform.class)
public class testSuitePorTag {

}
