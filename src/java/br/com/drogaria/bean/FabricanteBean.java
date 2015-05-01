package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FabricanteBean {
    private Fabricante fabricanteCadastro;
    private List<Fabricante> listaFabricantes; 
    private List<Fabricante> listaFabricantesFiltrados;

    public Fabricante getFabricanteCadastro() {
        return fabricanteCadastro;
    }

    public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
        this.fabricanteCadastro = fabricanteCadastro;
    }

    public List<Fabricante> getListaFabricantes() {
        return listaFabricantes;
    }

    public void setListaFabricantes(List<Fabricante> listaFabricantes) {
        this.listaFabricantes = listaFabricantes;
    }

    public List<Fabricante> getListaFabricantesFiltrados() {
        return listaFabricantesFiltrados;
    }

    public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
        this.listaFabricantesFiltrados = listaFabricantesFiltrados;
    }
    
    public void novo(){
        fabricanteCadastro = new Fabricante();
    }
    
    public void salvar(){
        try{
           FabricanteDAO fabricanteDAO = new FabricanteDAO();
           fabricanteDAO.salvar(fabricanteCadastro);
           
           fabricanteCadastro = new Fabricante();
           
           FacesUtil.adicionarMsgInfo("Fabricante salvo com sucesso!");
        }catch(RuntimeException ex){
           FacesUtil.adicionarMsgError("Erro ao tentar incluir um fabricante: "+ex.getMessage());
        }
    }    
    
    public void carregarPesquisa(){
        try{
            FabricanteDAO fabricanteDAO = new FabricanteDAO();
            listaFabricantes = fabricanteDAO.listar();
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar listar os fabricantes: "+ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try{
           String valor = FacesUtil.getParam("fabcod");
        
           if(valor != null){
               Long codigo = Long.parseLong(valor);
               
               FabricanteDAO fabricanteDAO = new FabricanteDAO();
               fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);
           }else{
               fabricanteCadastro = new Fabricante();
           } 
        }catch(RuntimeException ex){
           FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do fabricante: "+ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
           FabricanteDAO fabricanteDAO = new FabricanteDAO();
           fabricanteDAO.excluir(fabricanteCadastro);
           
           FacesUtil.adicionarMsgInfo("Fabricante removido com sucesso!");
        }catch(RuntimeException ex){
           FacesUtil.adicionarMsgError("Erro ao tentar remover o fabricante: "+ex.getMessage());
        }
    }
    
    public void editar(){
        try{
           FabricanteDAO fabricanteDAO = new FabricanteDAO();
           fabricanteDAO.editar(fabricanteCadastro);
           
           FacesUtil.adicionarMsgInfo("Fabricante editado com sucesso!");
        }catch(RuntimeException ex){
           FacesUtil.adicionarMsgError("Erro ao tentar editar o fabricante: "+ex.getMessage());
        }
    }
}
