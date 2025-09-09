import java.util.Scanner;

public class Main {


    static class Pilha {
        private Node topo;

        public Pilha() {
            this.topo = null;
        }

        public void insere(int valor) {
            Node novoNo = new Node(valor);
            novoNo.setProximo(topo);
            topo = novoNo;
        }

        public int remove() {
            if (topo == null) {
                return -1; 
            }
            
            int valor = topo.getValor();
            topo = topo.getProximo();
            return valor;
        }

        public void imprime() {
            if (topo == null) {
                System.out.println("Pilha vazia");
                return;
            }
            
            System.out.println("Elementos da pilha:");
            Node atual = topo;
            while (atual != null) {
                System.out.print(atual.getValor() + " ");
                atual = atual.getProximo();
            }
            System.out.println();
        }
    }

    static class Fila {
        private Node inicio;
        private Node fim;

        public Fila() {
            this.inicio = null;
            this.fim = null;
        }

        public void insere(int valor) {
            Node novoNo = new Node(valor);
            
            if (inicio == null) {
                inicio = novoNo;
                fim = novoNo;
            } else {
                fim.setProximo(novoNo);
                fim = novoNo;
            }
        }

        public int remove() {
            if (inicio == null) {
                return -1; 
            }
            
            int valor = inicio.getValor();
            inicio = inicio.getProximo();
            
            if (inicio == null) {
                fim = null;
            }
            
            return valor;
        }

        public void imprime() {
            if (inicio == null) {
                System.out.println("Fila vazia");
                return;
            }
            
            System.out.println("Elementos da fila:");
            Node atual = inicio;
            while (atual != null) {
                System.out.print(atual.getValor() + " ");
                atual = atual.getProximo();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();
        Fila fila = new Fila();
        int opcao, valor;
        
        do {
            System.out.println("\n=== TESTE DAS ESTRUTURAS ===");
            System.out.println("1. Pilha - Inserir");
            System.out.println("2. Pilha - Remover");
            System.out.println("3. Pilha - Imprimir");
            System.out.println("4. Fila - Inserir");
            System.out.println("5. Fila - Remover");
            System.out.println("6. Fila - Imprimir");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Valor para pilha: ");
                    valor = scanner.nextInt();
                    pilha.insere(valor);
                    break;
                    
                case 2:
                    valor = pilha.remove();
                    if (valor != -1) {
                        System.out.println("Removido da pilha: " + valor);
                    } else {
                        System.out.println("Pilha vazia!");
                    }
                    break;
                    
                case 3:
                    pilha.imprime();
                    break;
                    
                case 4:
                    System.out.print("Valor para fila: ");
                    valor = scanner.nextInt();
                    fila.insere(valor);
                    break;
                    
                case 5:
                    valor = fila.remove();
                    if (valor != -1) {
                        System.out.println("Removido da fila: " + valor);
                    } else {
                        System.out.println("Fila vazia!");
                    }
                    break;
                    
                case 6:
                    fila.imprime();
                    break;
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}