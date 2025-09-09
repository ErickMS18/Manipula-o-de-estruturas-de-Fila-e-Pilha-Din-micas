package listaencadeada;
import java.util.Scanner;

public class ListaEncadeada {
    private Node lista;

    private static class Node {
        private int informacao;
        private Node proximo;

        public Node() {
            this.proximo = null;
        }

        public int getInformacao() {
            return informacao;
        }

        public void setInformacao(int informacao) {
            this.informacao = informacao;
        }

        public Node getProximo() {
            return proximo;
        }

        public void setProximo(Node proximo) {
            this.proximo = proximo;
        }
    }

    public ListaEncadeada() {
        this.lista = null;
    }

    public boolean vazia() {
        return lista == null;
    }

    private Node erroListaVazia(String metodo) {
        System.out.println("Erro em " + metodo + ": A lista está vazia");
        return null;
    }

    private Node criarNo(int info) {
        Node no = new Node();
        no.setInformacao(info);
        no.setProximo(null);
        return no;
    }

    public void inserir(int informacao) {
        Node no = criarNo(informacao);

        if (vazia()) {
            lista = no;
        } else {
            Node atual = lista;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(no);
        }
    }

    public void inserePrimeiro(int info) {
        Node novoNo = criarNo(info);

        if (vazia()) {
            lista = novoNo;
        } else {
            novoNo.setProximo(lista);
            lista = novoNo;
        }
    }

    public void insereDepois(Node node, int info) {
        if (node == null) {
            System.out.println("Erro: Node não pode ser nulo");
            return;
        }

        Node novoNo = criarNo(info);
        novoNo.setProximo(node.getProximo());
        node.setProximo(novoNo);
    }

    public void insereUltimo(int info) {
        inserir(info);
    }

    public void insereOrdenado(int info) {
        Node novoNo = criarNo(info);

        if (vazia() || info < lista.getInformacao()) {
            inserePrimeiro(info);
            return;
        }

        Node atual = lista;
        while (atual.getProximo() != null && atual.getProximo().getInformacao() < info) {
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);
    }

    public Node removePrimeiro() {
        if (vazia()) {
            return erroListaVazia("removePrimeiro");
        }

        Node removido = lista;
        lista = lista.getProximo();
        removido.setProximo(null);
        return removido;
    }

    public Node removeUltimo() {
        if (vazia()) {
            return erroListaVazia("removeUltimo");
        }

        if (lista.getProximo() == null) {
            Node removido = lista;
            lista = null;
            return removido;
        }

        Node anterior = null;
        Node atual = lista;

        while(atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }

        anterior.setProximo(null);
        return atual;
    }

    public Node remove(Node noParaRemover) {
        if (vazia()) {
            return erroListaVazia("remove");
        }

        if (noParaRemover == null) {
            System.out.println("Erro: O nó não pode ser nulo");
            return null;
        }

        if (lista == noParaRemover) {
            Node removido = lista;
            lista = lista.getProximo();
            removido.setProximo(null);
            return removido;
        }

        Node anterior = null;
        Node atual = lista;

        while (atual != null && atual != noParaRemover) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Erro: Nó não encontrado na lista");
            return null;
        }

        anterior.setProximo(atual.getProximo());
        atual.setProximo(null);
        return atual;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Lista vazia!");
            return;
        }

        Node atual = lista;
        while (atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        System.out.println("Digite os itens da lista (digite '0' para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) {
                break;
            }
            lista.inserir(item);
        }

        System.out.println("Lista Encadeada:");
        lista.imprime();

        scanner.close();
    }
}