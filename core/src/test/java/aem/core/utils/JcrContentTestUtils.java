
package aem.core.utils;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class JcrContentTestUtils {

    private JcrContentTestUtils() { }

    public static Resource getResource(AemContext aemContext, String resourceInJson, String componentPath) {
        return aemContext.load().json(resourceInJson, componentPath);
    }

    public static List<Resource> createResource(AemContext aemContext, String resourceInJson, String componentPath, String nameIteams) {
        List<Resource> items = new ArrayList<>();
        if (aemContext != null) {

            for (int i = 1; i < 3; i++) {
                String path = componentPath + nameIteams + i;
                Resource resource = getResource(aemContext,resourceInJson,path);
                items.add(resource);
            }
        }
        return items;
    }
}
