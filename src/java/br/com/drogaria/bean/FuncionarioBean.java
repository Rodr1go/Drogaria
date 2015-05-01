package br.com.drogaria.bean;

import br.com.drogaria.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author stryker
 */

@ManagedBean
@ViewScoped
public class FuncionarioBean {
    public void salvar(){
    FacesUtil.adicionarMsgError("Ocorreu um erro ao tentar salvar o funcionário!");
  }
}
