package br.com.project.bean.geral;

import java.util.HashMap;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructViewMapEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.ViewMapListener;

public class ViewScopeCallbackRegister implements ViewMapListener{

	@Override
	public boolean isListenerForSource(Object source) {
		// TODO Auto-generated method stub
		return source instanceof UIViewRoot;
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if (event instanceof PostConstructViewMapEvent) {
			PostConstructViewMapEvent viewMapEvent = (PostConstructViewMapEvent) event;
			UIViewRoot uiViewRoot = (UIViewRoot) viewMapEvent.getComponent();
			uiViewRoot.getViewMap().put(viewScope.VIEW_SCOPE_CALLBACKS, new HashMap<String, Runnable>());
		}
		
	}

}
