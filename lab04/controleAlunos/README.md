## Conteúdo sendo exercitado
* Coleções como objetos que armazenam outros objetos
* Operações básicas sobre coleções: adicionar, remover, pesquisar e iterar
* Coleções em Java: listas, conjuntos, mapas 
* O conceito de generics aplicado a coleções Java
* Implementações de coleções baseadas em tabelas hash
* O “contrato” hashcode+equals

### Perguntas que você deveria saber responder após este lab
* Como se diferenciam as listas, conjuntos e mapas oferecidos em Java? Explique com exemplos.
* Qual a semântica de funcionamento de um ArrayList? Por exemplo, você entende o que acontece internamente quando chamamos a operação add() sobre um objeto do tipo ArrayList?
* Qual a semântica de funcionamento de um HashSet?
* Qual a semântica de funcionamento de um HashMap?
* Considerando as implementações de coleções de Java, em quais situações cada coleção é mais apropriada para ser usada?
* O que é generics? E qual a sua vantagem no contexto de coleções?
* Explique o “contrato” entre equals e hashcode e porque é importante. 


### to fix:
* - Esperava-se que fosse utilizado um hashmap ou hashset para armazenar os alunos de um grupo.
* - O método jaExiste de OperecoesGrupos é um método auxiliar utilizado apenas pela classe e deveria ser privado.
- Em exibeAluno de OperacoesAlunos é gerada a representação em string de um aluno (matricula, nome e curso), o que deveria ser responsabilidade da classe Aluno.
- Se Aluno tem um conjunto de seus grupos então Aluno deveria gerar a lista de grupos em vez de retornar o conjunto para a lista ser gerada em OperacoesAluno.
- Em alocaAluno de OperacoesGrupo adicionar um grupo a um aluno deveria ser responsabilidade de OperacoesAluno ao invés de retornar o aluno para OperacoesGrupos.
* - Não permite cadastrar um grupo sem tamanho.
- Não permite cadastrar um aluno com nome e sobrenome, pois o sobrenome é armazenado como curso.
- Existem problemas na impressão da saídas como quebras de linhas e repetição de mensagens.
- O menu das funcionalidades alocar aluno e pertinência  a grupo não foi implementado como especificado (Ao selecionar a opção  (A) correspondente a alocação, o usuário é perguntado se ele deseja alocar ou checar pertinência a um grupo).
- Não lança exceção para entradas vazias ou nulas.
- Em alocar aluno não deveria fazer distinção entre letras maiúsculas e minúsculas para o nome do grupo.
- Ao imprimir os grupos de um aluno não imprime com o case que os nomes dos grupos foram cadastrados. 
