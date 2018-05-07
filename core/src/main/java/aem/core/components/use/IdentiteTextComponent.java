package aem.core.components.use;

import aem.core.model.IdentiteModel;
import aem.core.model.IdentiteModelHttp;
import com.adobe.cq.sightly.WCMUsePojo;

public class IdentiteTextComponent extends WCMUsePojo {
	

	private String messageDisply;

	public String getMessageDisply() {
		return messageDisply;
	}


	private String messageDisplyHttp;

	public String getMessageDisplyHttp() {
		return messageDisplyHttp;
	}


	public void activate() throws Exception {
		this.messageDisply = getResource().adaptTo(IdentiteModel.class).getMessageDisplay();
		this.messageDisplyHttp = getRequest().adaptTo(IdentiteModelHttp.class).getMessageDisplay();
	}

}
