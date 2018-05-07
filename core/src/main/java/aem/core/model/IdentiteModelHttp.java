package aem.core.model;



import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Model(adaptables = { SlingHttpServletRequest.class, Resource.class })
@Model(adaptables=SlingHttpServletRequest.class)
public class IdentiteModelHttp {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdentiteModel.class);

    @Self
    private SlingHttpServletRequest request;

    public IdentiteModelHttp(SlingHttpServletRequest request) {
        this.request = request;
    }

    public String  getMessageDisplay (){
    
    Map<String, String[]> mapParam = request.getParameterMap();
    	LOGGER.debug("{} , IDENTITE ",mapParam.get("toto"));
		return String.format("BienVennue : %s  dans la formation AEM", mapParam.get("toto"));
	}
    

}
