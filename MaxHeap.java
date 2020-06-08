import java.util.Scanner;

public class MaxHeap {
    private int[] Heap;
    private int tamanho;
    private int tamanhoMax;

    public MaxHeap(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
        this.tamanho = 0;
        Heap = new int[this.tamanhoMax + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int pai(int posicao) {
        return posicao / 2;
    }

    private int filhoEsquerdo(int posicao) {
        return (2 * posicao);
    }

    private int filhoDireito(int posicao) {
        return (2 * posicao) + 1;
    }

    // Realiza a troca dos nodos
    private void troca(int paiPosicao, int filhoPosicao) {
        int aux;
        aux = Heap[paiPosicao];
        Heap[paiPosicao] = Heap[filhoPosicao];
        Heap[filhoPosicao] = aux;
    }

    // Compara o pai com os filhos e chama a função troca
    private void maxHeapficar(int posicao) {

        if (Heap[posicao] < Heap[filhoEsquerdo(posicao)] || Heap[posicao] < Heap[filhoDireito(posicao)]) {
            if (Heap[filhoEsquerdo(posicao)] > Heap[filhoDireito(posicao)]) {
                troca(posicao, filhoEsquerdo(posicao));
                maxHeapficar(filhoEsquerdo(posicao));
            } else {
                troca(posicao, filhoDireito(posicao));
                maxHeapficar(filhoDireito(posicao));
            }
        }
    }

    // Insere elementos
    public void inserir(int elemento) {
        Heap[++tamanho] = elemento;

        int atual = tamanho;
        while (Heap[atual] > Heap[pai(atual)]) {
            troca(pai(atual), atual);
            atual = pai(atual);
        }
    }

    //Exibe a estrutura
    public void print() {
        for (int x = 1; x <= tamanho / 2; x++) {
            System.out.print("\t\t      Pai: " + Heap[x] + "\n\t\t   /\t      \\\nFilho Esquerdo: " + Heap[filhoEsquerdo(x)] + "\t\t Filho Direito: " + Heap[filhoDireito(x)] + "\n");
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        int r,x=0,N=100;

        Scanner teclado = new Scanner(System.in);

       
        MaxHeap maxHeap = new MaxHeap(N);

        do{
        System.out.println("\n[0]Sair - Digite os valores : ");
        while (x < N) {
            int H = teclado.nextInt();
            if(H==0)
            break;
            else{
            maxHeap.inserir(H);
            x++;}
        }
        
        System.out.println("\nMax Heap\n");
        maxHeap.print();
        

        System.out.println("[1]Sim [2]Não - Deseja incluir mais valores? ");
        r=teclado.nextInt();
        }while(r==1);
        teclado.close();
    }
}


