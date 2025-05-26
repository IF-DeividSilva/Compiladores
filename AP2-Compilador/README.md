# Compilador para a Linguagem "Gyh-Repaginado" com ANTLR

## Descrição

Este projeto implementa um compilador para a linguagem de programação fictícia "Gyh-Repaginado", desenvolvida como parte da disciplina de Compiladores. O compilador utiliza o **ANTLR** para realizar a análise léxica e sintática do código fonte e, em seguida, emprega um conjunto de classes Java (visitantes ou listeners do ANTLR) para realizar a análise semântica e gerar código em **C**.

A geração de código é facilitada por uma estrutura de classes de comando (`ComandoAtribuicao`, `ComandoCondicao`, etc.), que representam as instruções da linguagem de forma abstrata antes de serem convertidas para a linguagem alvo.

---

## Funcionalidades Principais

* **Análise Léxica e Sintática com ANTLR:** Utilização de uma gramática ANTLR (`.g4`) para definir os tokens e a estrutura sintática da linguagem "Gyh-Repaginado". O ANTLR gera automaticamente o lexer e o parser.
* **Análise Semântica:** Implementada utilizando listeners ou visitors do ANTLR para percorrer a Árvore Sintática Concreta (CST) ou Abstrata (AST) gerada, realizando verificações de tipos, escopo, etc.
* **Geração de Código Estruturada:** Geração de código para **C** a partir da AST/CST, utilizando as classes `Comando*.java` para construir o código de saída.
* **Suporte para Estruturas da Linguagem:**
    * Atribuições (`ComandoAtribuicao.java`)
    * Estruturas condicionais (if/else) (`ComandoCondicao.java`)
    * Comandos de escrita/saída (`ComandoEscrita.java`)
    * Comandos de leitura/entrada (`ComandoLeitura.java`)
    * Laços de repetição (while) (`ComandoRepeticao.java`)
    * [**Adicione outras estruturas que sua linguagem suporta**]

---

## 📖 Especificação da Linguagem "[Nome da Linguagem Aqui]"

A linguagem "[Nome da Linguagem Aqui]" é uma linguagem [**imperativa/procedural/etc.**] desenvolvida para fins didáticos, com as seguintes características principais:

* **Tipos de Dados:** [**Ex: Inteiro, Booleano, String, etc.**]
* **Estruturas de Controle:** `if-else`, `while`.
* **Operações:** [**Ex: Aritméticas (+, -, \*, /), Lógicas (AND, OR, NOT), etc.**]
* **Entrada/Saída:** Comandos para leitura de dados do usuário e escrita de resultados.

A gramática formal da linguagem, utilizada pelo ANTLR, pode ser encontrada no arquivo `[NomeDaSuaGramatica].g4`.

[**Opcional: Adicione um link para a documentação completa da linguagem, se houver. Ex: A especificação completa da linguagem pode ser encontrada em `docs/especificacao_linguagem.pdf`.**]

---

## Como Funciona: ANTLR e Geração de Código

O processo de compilação segue as etapas clássicas, com o ANTLR facilitando as fases iniciais:

1.  **Definição da Gramática:** Uma gramática (`.g4`) define as regras léxicas (tokens) e sintáticas (regras de produção) da linguagem "[Nome da Linguagem Aqui]".
2.  **Geração do Parser/Lexer:** O ANTLR processa o arquivo de gramática e gera as classes Java para o lexer e o parser.
3.  **Análise Léxica:** O código fonte é lido e o lexer gerado pelo ANTLR o divide em uma sequência de tokens.
4.  **Análise Sintática:** O parser gerado pelo ANTLR utiliza os tokens para construir uma Árvore Sintática (Parse Tree ou CST).
5.  **Análise Semântica e Geração de Código Intermediário/Final:**
    * Um **Visitor** ou **Listener** customizado (que herda das classes base do ANTLR) percorre a árvore sintática.
    * Durante essa travessia, são realizadas as análises semânticas (verificação de tipos, declaração de variáveis, etc.).
    * Simultaneamente, ou em uma passagem subsequente, são instanciadas as classes `Comando` (`ComandoAtribuicao`, `ComandoCondicao`, etc.) para representar a lógica do programa de forma abstrata.
    * Finalmente, o método `geradorCodigo()` de cada objeto `Comando` é invocado para produzir o código na linguagem alvo.
        * A classe base abstrata `Comando` define o contrato `geradorCodigo()`.
        * `ComandoAtribuicao` gera código como `id = exp;`.
        * `ComandoCondicao` gera estruturas `if (...) { ... } else { ... }`.
        * `ComandoEscrita` gera chamadas como `printf(...)`.
        * `ComandoLeitura` gera chamadas como `scanf(...)`.
        * `ComandoRepeticao` gera laços como `while (...) { ... }`.

---

## Tecnologias Utilizadas

* **Linguagem de Implementação do Compilador:** Java
* **Gerador de Parser/Lexer:** ANTLR (versão [**Especifique a versão do ANTLR, ex: 4.x**])
* **IDE/Ferramentas de Build:** [**Ex: Eclipse, IntelliJ IDEA com plugin ANTLR, Maven, Gradle**]
* **Outras Ferramentas:** [**Se houver**]

---

## 📂 Estrutura do Repositório (Sugestão)
