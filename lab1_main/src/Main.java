
import matrix.Gauss;
import matrix.LU;
import matrix.matrixRang;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        double[][] A = new double[0][0];
            while (true) {
                System.out.println();
                System.out.print(
                        """
                                Выберите действие:
                                1.Генерация матрицы
                                2.Решение СЛАУ методом LU-разложение
                                3.Решение СЛАУ методом Гаусса
                                4.Ранг исходной матрицы:
                                5.Выход
                                Ваш выбор:"""
                );
                Scanner scanner = new Scanner(System.in);
                int c = scanner.nextInt();
                System.out.println();

                switch (c) {
                    case 1:
                        try {
                            System.out.println("Введите размерность матрицы: ");
                            int n = scanner.nextInt();
                            int m = scanner.nextInt();
                            A = generate(n,m);
                            printSystem(A);
                        } catch (Throwable t) {
                            System.out.println(t);
                        }
                        break;
                    case 2:
                        if (A.length > 0 && A[0].length > 0)
                        {
                            try {
                                LU res = new LU(A);
                                System.out.println("L матрица:");
                                printSystem(res.getL());
                                System.out.println("U матрица:");
                                printSystem(res.getU());
                                System.out.println("Решение СЛАУ методом LU-разложение");
                                printVector(res.getX());
                            } catch (Throwable t) {
                                System.out.println(t);
                            }
                        } else    System.out.println("Введите матрицу");

                        break;
                    case 3:
                        if (A.length > 0 && A[0].length > 0)
                        {
                            try{
                                Gauss gauss = new Gauss(A);
                                System.out.println("Решение СЛАУ методом Гаусса");
                                printVector(gauss.getX());
                            } catch (Throwable t) {
                                System.out.println(t);
                    }
                        } else    System.out.println("Введите матрицу");
                        break;
                    case 4:
                        if (A.length > 0 && A[0].length > 0)
                        {
                            try{
                                System.out.println("Ранг исходной матрицы:");
                                matrixRang r = new  matrixRang(A);
                                System.out.println(r.rang());
                            } catch (Throwable t) {
                                System.out.println(t);
                                }
                        } else    System.out.println("Введите матрицу");
                        break;

                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Неизвестная команда");
                        break;
                }


            }
        }

    public static void printVector(double[] x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            s.append(String.format("x%d = %f; ", i + 1, x[i]));
        }
        System.out.println(s);
    }

    public static double[][] generate(int size, int size1) {
        if (size < 2 || size1 < 2)
            throw new ArithmeticException("Некорректный размер матриц");
        else {
            double[][] fillerMatrix = new  double[size][size1];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size1; j++) {
                    Random random = new Random();
                    fillerMatrix[i][j] = (double) (random.nextInt() % 50) + 1;
                }
            }
            return fillerMatrix;
        }

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
