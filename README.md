# JSF

Este projeto está estruturado com os assuntos relacionados ao JSF.

**Aulas**

*[Aula 1 - Conceitos Básicos ](https://github.com/ifpb-disciplinas-2020-2/ads-dac-jsf/commit/566935d9b22b5a939990def346c117bdea4d51ae)*

*[Aula 2 - Conversores e Validadores ](https://github.com/ifpb-disciplinas-2020-2/ads-dac-jsf/commit/ba47c7cecdefc39cf47a7aacca2743b7e068be73)*

*[Aula 3 - HTML 5 e templates ](https://github.com/ifpb-disciplinas-2020-2/ads-dac-jsf/commit/1447cd0e40d024f88ca61bac67e784dcfd81a49b)*


# Atividade prática

Desenvolva uma aplicação que realize as operações de CRUD para a entidade `Pessoa` e `Dependente`. 
As funcionalidades precisam estar disponíveis com UI (interface para o usuário) com um template usável.

```java
public class Pessoa {
    private int id;
    private String nome;
    private CPF cpf;
    private Dependente dependente;
}
class Dependente{
    private String uuid;
    private String nome;
    private LocalDate dataDeNascimento;
}
```
## Metodologia

Esta atividade prática está planejada em um conjunto de requisitos e para ser desenvolvida individualmente. 
Cada aluno deve fazer o __fork__ deste projeto e implementar sua própria solução. 

Caso surja alguma dúvida no desenvolvimento, falar de imediato via [Slack](https://ifpb-dac-2020-2.slack.com/archives/C01LWJK7P8F). 
> Lembrete: Não guardem dúvidas, elas são como as dívidas. Acumulam-se e nos prejudicam :)
 

## Requisitos

* **RF01** - Implementar a classe `PessoasEmMemoria`; 
* **RF02** - Criar um Conversor para a classe `Dependente`; 
* **RF03** - Adicionar um `selectOneMenu` na página `edit.xhtml` da pasta __pessoa__. 
Deve ser possível selecionar um `Dependente` e associar sua instância ao atributo da classe `Pessoa` 
```
<h:selectOneMenu value="{controladorDePessoas.pessoa.dependente}" 
                 converter="converter.Dependente">
    <f:selectItems value="{controladorDePessoas.listarTodosOsDependentes()}"
                   var="dep" itemLabel="{de.uuid}" />
</h:selectOneMenu>
```
* **RF04** - Criar as páginas para edição e listagem da entidade `Dependente`; 
* **RF05** - Criar um Validador para a classe `Dependente`. Serão válidos apenas Dependentes que possuem data de nascimento anterior a data atual e o nome não vazio; 
* **RF06** - Criar uma página que permita realizar uma busca por `CPF`; 
* **RF07** - Criar e Implementar a classe `PessoasEmJDBC` que é uma solução que utiliza a conexão com Banco de Dados. 