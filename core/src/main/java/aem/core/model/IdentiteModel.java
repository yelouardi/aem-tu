package aem.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables=Resource.class)
public class IdentiteModel {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(IdentiteModel.class);

    @Self
    private Resource identite;

    public IdentiteModel(Resource resource) {
        this.identite = resource;
    }

    public String  getMessageDisplay (){
    	ValueMap values = identite.adaptTo(ValueMap.class);
    	return String.format("BienVennue : %s %s %s dans la formation AEM", values.get("identite", String.class), values.get("nom", String.class),
				values.get("preNom", String.class));
	}
    	
    

}
