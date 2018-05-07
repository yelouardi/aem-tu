package aem.core.models;

import aem.core.model.IdentiteModel;
import aem.core.utils.JcrContentTestUtils;
import aem.core.assertions.IdentiteAssertion;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdentiteModelTest {

    @Rule
    public final AemContext context = new AemContext();

    private Resource resource;

    @Before
    public void initModel() {
        resource = JcrContentTestUtils.getResource(context, "/identite-jcr.json", "/identite-jcr");

    }

    @Test
    public void testAdaptToIdentiteModel() {
        IdentiteModel identiteModel = new IdentiteModel(resource);

        IdentiteAssertion.assertThat(identiteModel.getMessageDisplay())
                .displayMessageEquals("BienVennue : homme TEST AEM TU AEM dans la formation AEM");

    }
}


