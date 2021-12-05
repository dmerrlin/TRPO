package matrix;

public final class LU {

    private final double[][] L;
    private final double[][] U;
    private final double[] X;

    public  LU(double[][] A)
    {
        if (!checkSystem(A)){
            throw new ArithmeticException("Incorrect system for LU Method");
        }

        double[][] L = new  double[A.length][A.length];
        double[][] U = new  double[A.length][A.length];

        for(int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, U[i], 0, A.length);

        int n = A.length;

        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++)
                L[j][i]=U[j][i]/U[i][i];

        for(int k = 1; k < n; k++)
        {
            for(int i = k-1; i < n; i++)
                for(int j = i; j < n; j++)
                    L[j][i]=U[j][i]/U[i][i];

            for(int i = k; i < n; i++)
                for(int j = k-1; j < n; j++)
                    U[i][j]=U[i][j]-L[i][k-1]*U[k-1][j];
        }

        double[] y = new double[n];
        double[] x = new double[n];
        double[] B = new double[n];

        for(int j = 0; j < A.length; j++)
            B[j] =  A[j][A[0].length-1];

        //поиск Y[n] через выражение L*Y=B
        for (int i = 0; i < n; i++) {
            double sum = 0;
            int k;
            for ( k = 0; k < i; k++)
                sum += L[i][k] * y[k];
            y[k] = (B[i] - sum);
        }

        //поиск X[n] через выражение U*X=Y
        for ( int i = n - 1; i >= 0; i--) {

            double sum = 0;
            for (int  j = i + 1; j < n; j++)
                sum += (U[i][j] * x[j]);
            x[i] = (y[i] - sum) / U[i][i];
        }

        this.L = L;
        this.U = U;
        this.X = x;
    }


    public double[][] getU() {
        return U;
    }

    public double[] getX() {
        return X;
    }

    public double[][] getL() {
        return L;
    }

    private static boolean checkSystem(double[][] system){
        if (system.length < 2) return false;
        for(int i = 0; i < system.length; i++){
            if (system[0].length != (system.length + 1)){
                return false;
            }
        }
        return true;
    }
}
