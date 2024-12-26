package Automation;

import com.google.gson.JsonObject;


import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
public class CollectionTest {
    public static JsonObject getDefaultTestCapability() {
        JsonObject capabilities1 = new JsonObject();
        JsonObject ltOptions1 = new JsonObject();

        String user = "vaibhav.sadashiv-shinde";
        String accessKey = "7xy4UedcWI0z4EjsTqPbDRM0qdQC656gvSOjIu2WEdPWPPpMuy";

        capabilities1.addProperty("browserName", "Chrome"); // Browsers allowed: `Chrome`, `MicrosoftEdge`, `pw-chromium`, `pw-firefox` and `pw-webkit`
        capabilities1.addProperty("browserVersion", "latest");
        ltOptions1.addProperty("platform", "Windows 10");
        ltOptions1.addProperty("name", "Playwright Test");
        ltOptions1.addProperty("build", "Playwright POM Parallel demo");
        ltOptions1.addProperty("user", user);
        ltOptions1.addProperty("accessKey", accessKey);
        capabilities1.add("LT:Options", ltOptions1);
        ltOptions1.addProperty("geoLocation", "IN");
        ltOptions1.addProperty("visual", true);
        ltOptions1.addProperty("video", true);
        ltOptions1.addProperty("network", true);
        ltOptions1.addProperty("timezone", "Kolkata");
        ltOptions1.addProperty("console", true);
        ltOptions1.addProperty("w3c", true);

        return capabilities1;
    }
}
