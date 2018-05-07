package aem.core.models;

import aem.core.assertions.IdentiteAssertion;
import aem.core.model.IdentiteModel;
import aem.core.model.IdentiteModelHttp;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.testing.mock.sling.MockSling;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdentiteModelHttpTest {

    @Rule
    public final AemContext context = new AemContext();

    private MockSlingHttpServletRequest request;

    @Before
    public void initModel() {
        // prepare sling request
        ResourceResolver resourceResolver = MockSling.newResourceResolver();
        request = new MockSlingHttpServletRequest(resourceResolver);
        // simulate query string
        request.setQueryString("toto=AEM");

    }

    @Test
    public void testAdaptToIdentiteModel() {
        IdentiteModelHttp identiteModelHttp= new IdentiteModelHttp(request);

        IdentiteAssertion.assertThat(identiteModelHttp.getMessageDisplay())
                .displayMessageEquals("BienVennue : AEM  dans la formation AEM");

    }
}


