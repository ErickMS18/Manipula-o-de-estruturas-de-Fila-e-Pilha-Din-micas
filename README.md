# Manipulação de estruturas de Fila e Pilha Dinâmicas

Este projeto contém três implementações em Java que demonstram estruturas de dados fundamentais e o algoritmo de merge (combinação) para listas encadeadas e vetores.

## 🏗️ Estrutura do Projeto

O projeto consiste em três arquivos Java:

1. **Node.java** - Implementação de um nó para listas encadeadas
2. **Main.java** - Sistema interativo para testar pilhas e filas
3. **merge.java** - Implementação do algoritmo merge para listas e vetores

## 📦 Funcionalidades

### 1. Node.java
- Classe que representa um nó de lista encadeada
- Armazena um valor inteiro e referência para o próximo nó
- Métodos getters e setters para manipulação

### 2. Main.java
- **Pilha**: Implementação LIFO (Last-In-First-Out) com operações:
  - `insere()` - Empilha um elemento
  - `remove()` - Desempilha um elemento
  - `imprime()` - Exibe todos os elementos

- **Fila**: Implementação FIFO (First-In-First-Out) com operações:
  - `insere()` - Enfileira um elemento
  - `remove()` - Desenfileira um elemento
  - `imprime()` - Exibe todos os elementos

- **Menu interativo** para testar ambas as estruturas

### 3. merge.java
- **Algoritmo Merge** para vetores: Combina dois vetores ordenados em um terceiro vetor ordenado
- **Algoritmo Merge** para listas encadeadas: Combina duas listas ordenadas em uma terceira lista ordenada
- Classes auxiliares `Lista` e `Vetor` com métodos de inserção e impressão

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal ou prompt de comando

### Compilação e Execução

1. **Compile todos os arquivos:**
```bash
javac Node.java Main.java merge.java
