package br.edu.ifpb.infra.persistence.memory;


import br.edu.ifpb.domain.Pessoa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 11:01:12
 */
public class PessoasEmMemoria {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void nova(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public List<Pessoa> todasAsPessoas() {
        return Collections.unmodifiableList(
            this.pessoas
        );
    }

}
