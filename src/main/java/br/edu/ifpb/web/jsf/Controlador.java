package br.edu.ifpb.web.jsf;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Pessoas;
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
    private Dependente dependente = new Dependente();

    private AlteraNomeDasPessoas service = new AlteraNomeDasPessoas();

    private Pessoas pessoas = new PessoasEmMemoria();

    public String redirecionar() {
        // executando a lógica de negócio
        service.alteraNome(pessoa);
        pessoa.alterarNome();
        // redirecionando...
        return null; // fica na página original
//        return "home"; // encmainhar a requisição à página 
//        return "home.xhtml?faces-redirect=true"; // nova requisição
    }

    public String adicionar() {
        // deveríamos ter um objeto responsável por encapsular essa regra de negócio
        Pessoa retorno = this.pessoas.localizarPessoaComId(
                this.pessoa.getId()
        );
        if(Pessoa.fake().equals(retorno)){
            this.pessoas.nova(this.pessoa);
        }else{
            this.pessoas.atualizar(this.pessoa);
        }
        this.pessoa = new Pessoa("");
        return null;
    }
    public String excluir(Pessoa pessoa){
        this.pessoas.excluir(pessoa);
        return null;
    }
    public String editar(Pessoa pessoa){
        this.pessoa = pessoa;
        return "edit";
    }

    public String adicionarDependente() {
        this.pessoas.novo(dependente);
        this.dependente = new Dependente();
        return null;
    }


    public List<Dependente> todosOsDependentes(){
        return this.pessoas.todosOsDepentendes();
    }
    public List<Pessoa> todasAsPessoas() {
        return this.pessoas.todas();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
}
