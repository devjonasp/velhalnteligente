# 🚀 VelhaInteligente

## 📖 Descrição

Jogo da Velha com algoritmo de decisão desenvolvido do zero para a máquina, simulando um comportamento inteligente.

## 🎯 Objetivo

Consolidar os conhecimentos adquiridos ao longo do curso *Java: Primeiros Passos – Lógica de Programação e Algoritmos*, aplicando na prática os conceitos estudados por meio do desenvolvimento de um algoritmo que permite o usuário jogar contra uma máquina.

## 🛠️ Tecnologias Utilizadas

- Java 17

 ## 🧠 Algoritmo da máquina

O jogo é executado inteiramente no terminal. O algoritmo de decisão da máquina foi desenvolvido do zero.

A tomada de decisão segue a seguinte ordem de prioridade:

1. Verificar se existe uma jogada que garanta a vitória da máquina.
2. Caso contrário, verificar se o usuário possui uma jogada vencedora e, se houver, bloqueá-la.
3. Se nenhuma das condições anteriores for atendida, realizar a próxima jogada disponível.

Para manter o jogo equilibrado e compatível com o objetivo do projeto, a lógica de bloqueio foi implementada apenas para as combinações horizontais e para a diagonal principal. Dessa forma, o usuário ainda pode vencer pelas combinações verticais ou pela diagonal secundária.

Essa foi uma escolha de implementação para demonstrar a construção de um algoritmo de tomada de decisão utilizando apenas lógica de programação, sem recorrer a técnicas mais avançadas.

## 📚 Conceitos Aplicados

- Estrutura sequencial
- Estruturas condicionais (`if`, `else` e `else if`)
- Estruturas de repetição (`for`, `while` e `do-while`)
- Matrizes
- Tratamento de exceções (`try-catch`)
