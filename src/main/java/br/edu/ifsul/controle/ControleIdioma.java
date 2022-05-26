/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.IdiomaDAO;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author hurie
 */
@Named(value = "controleIdioma")
@ViewScoped
public class ControleIdioma implements Serializable {
    @EJB
    private IdiomaDAO<Idioma> dao;
    private Idioma objeto;
    
    public ControleIdioma() {
        
    }
    
    public String listar() {
        return "/privado/idioma/listar?faces-redirect-true";
    }
    
    public void novo() {
        objeto = new Idioma();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch(Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        } 
    }
    
    public void excluir(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch(Exception e) {
            Util.mensagemErro("Erro ao remover objetos: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar() {
        try {
            if(objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch(Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public IdiomaDAO<Idioma> getDao() {
        return dao;
    }

    public void setDao(IdiomaDAO<Idioma> dao) {
        this.dao = dao;
    }

    public Idioma getObjeto() {
        return objeto;
    }

    public void setObjeto(Idioma objeto) {
        this.objeto = objeto;
    }
}
