package br.edu.ifpb.web.jsp;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.service.AlteraNomeDasPessoas;
import br.edu.ifpb.infra.persistence.memory.PessoasEmMemoria;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 10:01:33
 */
//@ManagedBean
@Named
//@RequestScoped
@SessionScoped
public class Controlador implements Serializable {

    private Pessoa pessoa = new Pessoa("");
    private AlteraNomeDasPessoas service = new AlteraNomeDasPessoas();

    private PessoasEmMemoria pessoas = new PessoasEmMemoria();

    public String redirecionar() {
        // executando a lógica de negócio
        service.alteraNome(pessoa);
        pessoa.alterarNome();
        // redirecionando...
//        return null; // fica na página original
        return "home"; // encmainhar a requisição à página 
//        return "home.xhtml?faces-redirect=true"; // nova requisição
    }

    public String adicionar() {
        this.pessoas.nova(pessoa);
        this.pessoa = new Pessoa("");
        return null;
    }

    public List<Pessoa> todasAsPessoas() {
        return this.pessoas.todasAsPessoas();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
