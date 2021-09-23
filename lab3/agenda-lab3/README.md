### Conteúdo sendo exercitado
* Classe básica de composição 
* Uso do equals
* Introdução a testes de unidade com JUnit
* Introdução a tratamento de erros com exceção

### Perguntas que você deveria saber responder após este lab
* Como se caracteriza o relacionamento entre objetos via composição?
* O que significa dizer que o método equals é um método padrão de Java?
* Em que situações é necessário sobrescrever o método equals?
* O que é uma exceção?
* De que forma podemos usar exceções para lidar com entradas inválidas?
* Toda exceção deve fazer o programa parar?
* Os testes de unidade devem testar a unidade básica de um programa em Java. Liste algumas boas práticas para escrever testes de unidade.
* Em um cenário de composição, como separamos os testes da classe base (composite) e da classe composta?

### to fix:
testes observando que:
(4) - Testes da classe contato (1 por grupo):
- Testes de Construtor
- Testes de Exibir/toString (com e sem alguns dados)
- Testes de pegar dados (ex.: Nome completo, versão resumida)
- Testes de equals e outros métodos específicos do design do aluno

6 - Teste da classe agenda (2 por grupo):

- Testes de cadastro de contato (válido, posições limites, já cadastrados, sobrescrita de contato)

- Testes de listagem/exibição de contato e aplicação de tags (listar vazio, exibir contato, posição inválida, limite de tags, sobrescrita de tags, tags em mais de um contato por operação)

- Testes de favoritos (adicionar favorito, exibir cadastro favoritado, exibir cadastro de ex-favoritado)
