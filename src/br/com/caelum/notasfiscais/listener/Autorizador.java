package br.com.caelum.notasfiscais.listener;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 2865600386078969427L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		String viewId = context.getViewRoot().getViewId();
		if("/login.xhtml".equals(viewId)) {
			return;
		}
		
		Application application = context.getApplication();
		LoginBean bean = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		if(!bean.isLogado()) {
			NavigationHandler handler = application.getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			
			bean.setToPage(viewId);
			context.renderResponse();
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		//do nothing
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
