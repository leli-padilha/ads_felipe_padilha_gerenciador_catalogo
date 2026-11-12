package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import jakarta.ejb.EJBException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import org.primefaces.PrimeFaces;

public abstract class AbstractCrudController<T> implements Serializable {

    public enum PersistAction {
        CREATE, UPDATE, DELETE
    }

    private List<T> items;
    private T selected;

    protected abstract AbstractFacade<T> getFacade();

    protected abstract List<T> listar();

    protected boolean persist(PersistAction action, String successMessage, T entity) {
        try {
            switch (action) {
                case CREATE -> getFacade().createReturn(entity);
                case UPDATE -> getFacade().edit(entity);
                case DELETE -> getFacade().remove(entity);
            }
            items = null;
            if (action != PersistAction.CREATE) {
                selected = null;
            }
            addSuccessMessage(successMessage);
            PrimeFaces.current().ajax().addCallbackParam("salvo", true);
            return true;
        } catch (EJBException ex) {
            String msg = "";
            Throwable cause = ex.getCause();
            if (cause != null && cause.getLocalizedMessage() != null) {
                msg = cause.getLocalizedMessage();
            }
            addErrorMessage(msg.isBlank() ? "Não foi possível gravar o registro." : msg);
        } catch (Exception ex) {
            addErrorMessage(ex.getLocalizedMessage() == null ? "Não foi possível gravar o registro." : ex.getLocalizedMessage());
        }
        return false;
    }

    protected void addSuccessMessage(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", msg));
    }

    protected void addErrorMessage(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", msg));
    }

    public List<T> getItems() {
        if (items == null) {
            items = listar();
        }
        return items;
    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }
}
