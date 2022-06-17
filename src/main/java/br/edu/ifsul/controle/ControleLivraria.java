package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LivrariaDAO;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Huriel Lopes
 */
@Named(value = "controleLivraria")
@ViewScoped
public class ControleLivraria implements Serializable {

    @EJB
    private LivrariaDAO<Livraria> dao;
    private Livraria objeto;
    
    private Catalogo catalogo;
    private Boolean novoCatalogo;


    public ControleLivraria(){

    }

    public void novoCatalogo(){
        catalogo = new Catalogo();
        novoCatalogo = true;
    }

    public void alterarCatalogo(int index){
        catalogo = objeto.getCatalogos().get(index);
        novoCatalogo = false;
    }

    public void salvarCatalogo(){
        if (novoCatalogo){
            objeto.adicionarCatalogo(catalogo);
        }
        Util.mensagemInformacao("Catálogo adicionado ou alterado com sucesso!");
    }

    public void removerCatalogo(int index){
        objeto.removerCatalogo(index);
        Util.mensagemInformacao("Catálogo removido com sucesso!");
    }


    public String listar(){
        return "/privado/livraria/listar?faces-redirect=true";
    }

    public void novo(){
        objeto = new Livraria();
    }

    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }

    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public LivrariaDAO<Livraria> getDao() {
        return dao;
    }

    public void setDao(LivrariaDAO<Livraria> dao) {
        this.dao = dao;
    }

    public Livraria getObjeto() {
        return objeto;
    }

    public void setObjeto(Livraria objeto) {
        this.objeto = objeto;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Boolean getNovoCatalogo() {
        return novoCatalogo;
    }

    public void setNovoCatalogo(Boolean novoCatalogo) {
        this.novoCatalogo = novoCatalogo;
    }

}