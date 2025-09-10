public class merge {

    static class Lista {
        Node head = null;

        void inserirValor(int valor) {
            Node novo = new Node(valor);

            if (head == null) {
                head = novo;
            } else {
                Node atual = head;

                while (atual.getProximo() != null) {
                    atual = atual.getProximo();
                }

                atual.setProximo(novo);
            }
        }

        void imprimeLista() {

            Node atual = head;
            while (atual != null) {
                System.out.print(atual.getValor() + " ");
                atual = atual.getProximo();
            }
            System.out.println();
        }
    }

    static class Vetor {

        static void imprimeVetor(int[] vetor, int comprimento){
            for(int i = 0; i < comprimento ; i++){
                System.out.print(vetor[i]+" ");
            }
            System.out.println();
        }


    }
    public static int[] merge(int[] A, int[] B, int comprimentoA, int comprimentoB){

        int comprimentoC = comprimentoA + comprimentoB;
        int[] C = new int [comprimentoC];

        int i=0, j=0, k=0;

        while(i<comprimentoA && j<comprimentoB){

            if(A[i] < B[j]){
                C[k] = A[i];
                i++;
            }

            else{
                C[k] = B[j];
                j++;
            }
        k++;
        }
        while(i < comprimentoA){
            C[k] = A[i];
            i++;
            k++;
        }
        while(j < comprimentoB){
            C[k] = B[j] ;
            j++;
            k++;
        }

        return C;
    }

    public static Lista merge(Lista A, Lista B){
            Lista C = new Lista();
            Node a = A.head;
            Node b = B.head;

            while( a != null && b != null){
                if( a.getValor() < b.getValor()){
                    C.inserirValor(a.getValor());
                    a= a.getProximo();
                }
                else{
                    C.inserirValor(b.getValor());
                    b = b.getProximo();
                }
            }
            while(a != null){
                C.inserirValor(a.getValor());
                a = a.getProximo();

            }

            while(b != null){
                C.inserirValor(b.getValor());
                b = b.getProximo();

            }

            return C;
    }

    public static void main(String[] args) {

            Lista A = new Lista();
            Lista B = new Lista();


            A.inserirValor(14);
            A.inserirValor(15);
            A.inserirValor(35);
            A.inserirValor(47);
            A.inserirValor(52);
            A.inserirValor(74);
            A.inserirValor(92);

            B.inserirValor(23);
            B.inserirValor(29);
            B.inserirValor(39);
            B.inserirValor(72);
            B.inserirValor(89);


            System.out.println("Lista A: ");
            A.imprimeLista();

            System.out.println("Lista B: ");
            B.imprimeLista();

            System.out.println("Aplicando merge...");
            Lista C = merge(A, B);

            System.out.println("Lista C: ");
            C.imprimeLista();
            System.out.println();


            int[] vetorA = {4, 32, 41, 48 ,72, 79, 101};
            int[] vetorB = {1, 16, 27 ,29, 45, 81, 92 };
            int lengthA = 7;
            int lengthB = 7;
            int lengthC = lengthA + lengthB;


            System.out.println("Vetor A: ");
            Vetor.imprimeVetor(vetorA, lengthA);

            System.out.println("Vetor B: ");
            Vetor.imprimeVetor(vetorB, lengthB);

            System.out.println("Aplicando merge...");
            int[] vetorC = merge(vetorA, vetorB, lengthA, lengthB);

            System.out.println("Vetor C: ");
            Vetor.imprimeVetor(vetorC, lengthC);

        }


}

       
