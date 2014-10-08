package com.produto.mb;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import org.primefaces.component.paginator.NextPageLinkRenderer;

@SessionScoped
public class GerenciadorDeAutenticacao implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
		
		
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();


		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		String contextURL = request.getRequestURL().toString().replace(request.getRequestURI().substring(0), "") + request.getContextPath();
		contextURL.toUpperCase();
	
		boolean isLoginPage = (currentPage.lastIndexOf("UsuarioLogin.xhtml") > -1);
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		
		
	
		
		boolean isRegPage = (currentPage.lastIndexOf("UsuarioRegistrar.xhtml") > -1);
		if(isRegPage){
			return;
		}
		

		if (session == null) {
			NavigationHandler nh = facesContext.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage");
		}

		else {
			Object currentUser = session.getAttribute("username");

			if (!isLoginPage && (currentUser == null || currentUser == "")) {
				NavigationHandler nh = facesContext.getApplication()
						.getNavigationHandler();
				nh.handleNavigation(facesContext, null, "loginPage");
			}
		}
	}

	public void beforePhase(PhaseEvent event) {

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}