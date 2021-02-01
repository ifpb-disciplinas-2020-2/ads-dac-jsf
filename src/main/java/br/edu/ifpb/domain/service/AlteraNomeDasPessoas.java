package br.edu.ifpb.domain.service;

import br.edu.ifpb.domain.Pessoa;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2021, 10:21:15
 */
public class AlteraNomeDasPessoas {
    public void alteraNome(Pessoa pessoa){
        pessoa.alterarNomeMinusculo();
    }

}
