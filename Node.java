public class Node {

    private int valor;
    private Node proximo;

    Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }

    int getValor(){
        return this.valor;
    }

    Node getProximo(){
        return this.proximo;
    }

    void setValor(int valor){
            this.valor = valor;
    }
    void setProximo(Node proximo){
        this.proximo = proximo;
    }




}