package matrix;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        System.out.println("Исходная матрица:");
        double[][] A = generate(4,5);
        printSystem(A);
       // LU res = new LU(A);
        Gauss gauss = new Gauss(A);
       // System.out.println("L матрица:");
      //  printSystem(res.getL());
      //  System.out.println("U матрица:");
       // printSystem(res.getU());
       // System.out.println("Решение СЛАУ методом LU-разложение");
       // printVector(res.getX());
        System.out.println();
        System.out.println("Решение СЛАУ методом Гаусса");
        printVector(gauss.getX());
        System.out.println();
        System.out.println("Ранг исходной матрицы:");
        matrixRang r = new  matrixRang(A);
        System.out.println(r.rang);
    }

    public static void printVector(double[] x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            s.append(String.format("x%d = %f; ", i + 1, x[i]));
        }
        System.out.println(s);
    }

    public static double[][] generate(int size, int size1) {
        if (size < 2) size = 2;
        double[][] fillerMatrix = new  double[size][size1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size1; j++) {
                Random random = new Random();
                fillerMatrix[i][j] = (double) (random.nextInt() % 50) + 1;
            }
        }
        return fillerMatrix;
    }

    public static void printSystem(double[][] system){
        for (double[] doubles : system) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < system[0].length; j++) {
                s.append(String.format("%f; %s", doubles[j], "\t"));
            }
            System.out.println(s);
        }
        System.out.println();
    }
}
