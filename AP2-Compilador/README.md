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

## Especificação da Linguagem "Gyh-Repaginado"

A linguagem "Gyh-Repaginado" é uma linguagem imperativa e procedural, estruturada com blocos de declaração e de programa, desenvolvida para fins didáticos. Suas principais características são:

* **Estrutura do Programa:** Um programa em GYH é definido entre colchetes, iniciando com uma seção de declarações (`[dec] ListaDeclaracoes`) seguida por uma seção de comandos de programa (`[prog] ListaComandos`).

* **Declaração de Variáveis:** As variáveis são declaradas com um identificador (iniciado por letra maiúscula) seguido pelo tipo entre colchetes.
    * Exemplo: `MINHAVAR [integer]`

* **Tipos de Dados:**
    * `integer`: Para números inteiros (Sequências de dígitos sem ponto).
    * `float`: Para números reais (Sequências de dígitos com ponto).
    * `Cadeia`: Sequências de caracteres envoltas por aspas, utilizadas principalmente em comandos de saída.

* **Estruturas de Controle:**
    * **Condicional (`if`):**
        * `if ExpressaoRelacional then Comando`
        * `if ExpressaoRelacional then Comando else Comando`
    * **Repetição (`while`):**
        * `while ExpressaoRelacional then Comando`
    * **Blocos de Comandos/SubAlgoritmo (`start`/`end`):**
        * `start ListaComandos end` (permite agrupar múltiplos comandos onde um único comando é esperado).

* **Operações:**
    * **Aritméticas:**
        * Adição (`+`)
        * Subtração (`-`)
        * Multiplicação (`*`)
        * Divisão (`/`)
    * **Relacionais:**
        * Menor que (`<`)
        * Menor ou igual (`<=`)
        * Maior que (`>`)
        * Maior ou igual (`>=`)
        * Igual (`==`)
        * Diferente (`<>`)
    * **Lógicas/Booleanas:**
        * `and`
        * `or`
    * **Atribuição:**
        * `<<` (Ex: `VARIAVEL << ExpressaoAritmetica`)

* **Entrada e Saída:**
    * **Entrada (`read`):**
        * `read VARIAVEL` (Lê um valor para uma variável).
    * **Saída (`print`):**
        * `print VARIAVEL` (Imprime o valor de uma variável).
        * `print CADEIA` (Imprime uma cadeia de caracteres literal).

* **Expressões:**
    * **Aritméticas:** Combinações de números (inteiros ou reais), variáveis e parênteses com operadores aritméticos.
    * **Relacionais:** Comparações entre expressões aritméticas usando operadores relacionais, ou expressões relacionais aninhadas com parênteses e operadores booleanos.

* **Identificadores (Variáveis):** Sequências de letras ou números que começam com letra MAIÚSCULA.

* **Palavras-chave:** `dec`, `prog`, `integer`, `float`, `read`, `print`, `if`, `else`, `then`, `while`, `start`, `end`, `and`, `or`.

* **Delimitadores e Símbolos:** `[`, `]`, `(`, `)`.

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
* **Gerador de Parser/Lexer:** ANTLR (versão [**4.7.2**])
* **IDE/Ferramentas de Build:** [** Eclipse, VSCode**]

---
## Estrutura do Repositório 
```
AP2-Compilador/
├── src/
│   ├── Main.java
│   ├── ComandoAtribuicao.java
│   ├── ComandoCondicao.java
│   ├── ... (outras classes de comando)
│   ├── Gyh.g4 (gramática ANTLR)
│   ├── GyhLexer.java (gerado pelo ANTLR)
│   ├── GyhParser.java (gerado pelo ANTLR)
│   └── ... (outras classes geradas e customizadas)
├── test/
│   ├── programa1.gyh
│   ├── programa2.gyh
│   └── ...
└── README.md
```

---
## Autores
- Nomes: Deivid da Silva Galvão, João Vitor Nakahodo Yoshida
- E-mails: deivid.2002@alunos.utfpr.edu.br, joaoyoshida@alunos.utfpr.edu.br

O principal objetivo deste projeto é consolidar e aplicar os conceitos de análise léxica e sintática e Java, além de aprofundar meu conhecimento sobre a arquitetura e a geração de código em compiladores.

---

## Licença
MIT License © 2024
