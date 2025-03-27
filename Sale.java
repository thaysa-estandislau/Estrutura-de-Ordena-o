import java.util.Scanner;

public class Sale {

    public static void main(String[] args) {
        int[] precos = null;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(" ");
            String[] linha_1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(linha_1[0]);
            int m = Integer.parseInt(linha_1[1]);

            if (m > n || n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Erro! Certifique-se de que 1 ≤ m ≤ n.");
            }

            System.out.println(" ");
            String[] linha_2 = sc.nextLine().split(" ");
            precos = new int[n];

            for (int i = 0; i < n; i++) {
                precos[i] = Integer.parseInt(linha_2[i]);
                if (precos[i] < -1000 || precos[i] > 1000) {
                    throw new IllegalArgumentException("Os preços devem estar no intervalo de -1000 a 1000.");
                }
            }

            quickSort(precos, 0, n - 1);

            int lucroMaximo = 0;

            for (int i = 0; i < m && precos[i] < 0; i++) {
                lucroMaximo += Math.abs(precos[i]);
            }

            System.out.println(lucroMaximo);

        } catch (NumberFormatException e) {
            System.out.println("Formato inválido!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tamanho do array incompatível.");
        } catch (Exception e) {
            System.out.println("Erro! " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void quickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p + 1, direita);
        }
    }

    private static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;

        while (true) {
            do {
                i++;
            } while (vetor[i] < pivot);
            do {
                j--;
            } while (vetor[j] > pivot);
            if (i >= j) {
                return j;
            }

            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
}
