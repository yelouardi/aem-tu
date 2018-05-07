package aem.core.components.use;

import aem.core.assertions.IdentiteAssertion;
import aem.core.model.IdentiteModel;
import aem.core.model.IdentiteModelHttp;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import javax.script.Bindings;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IdentiteUseIntegrationTest {

    @Rule
    public AemContext aemContext = new AemContext();

    @Mock
    private Bindings bindings;

    @Mock
    private IdentiteModel identiteModel;
    @Mock
    private IdentiteModelHttp identiteModelHttp;

    @InjectMocks
    @Spy
    private IdentiteTextComponent identiteTextComponent = new IdentiteTextComponent();

    @Mock
    private Resource resource;
    @Mock
    private SlingHttpServletRequest request;

    @Before
    public void activateComponent() throws Exception {
        when(bindings.get("resource")).thenReturn(resource);
        when(identiteTextComponent.get("resource", Resource.class))
                .thenReturn(resource);
        when(resource.adaptTo(IdentiteModel.class)).thenReturn(identiteModel);
        when(request.adaptTo(IdentiteModelHttp.class)).thenReturn(identiteModelHttp);

        when(identiteModel.getMessageDisplay()).thenReturn("BienVennue : TEST AEM TU AEM homme dans la formation AEM");
        when(identiteModelHttp.getMessageDisplay()).thenReturn("BienVennue : toto dans la formation AEM");

        identiteTextComponent.activate();
    }

    @Test
    public void testMessageDisplayResource(){
        IdentiteAssertion.assertThat(identiteTextComponent.getMessageDisply())
                .displayMessageEquals("BienVennue : TEST AEM TU AEM homme dans la formation AEM");    }
    @Test
    public void testMessageDisplayRequest(){
        IdentiteAssertion.assertThat(identiteTextComponent.getMessageDisplyHttp())
                .displayMessageEquals("BienVennue : toto dans la formation AEM");    }
}