/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AutorDAO;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author hurie
 */
@Named(value = "controleAutor")
@ViewScoped
public class ControleAutor implements Serializable {
    @EJB
    private AutorDAO<Autor> dao;
    private Autor objeto;
    
    public ControleAutor() {
        
    }
    
    public String listar() {
        return "/privado/autor/listar?faces-redirect-true";
    }
    
    public void novo() {
        objeto = new Autor();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
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
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
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

    public AutorDAO<Autor> getDao() {
        return dao;
    }

    public void setDao(AutorDAO<Autor> dao) {
        this.dao = dao;
    }

    public Autor getObjeto() {
        return objeto;
    }

    public void setObjeto(Autor objeto) {
        this.objeto = objeto;
    }
    
    
}
