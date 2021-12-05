package matrix;

public final class Gauss {

    double[] X;
    public Gauss(double[][] a) {

        if (!checkSystem(a)){
           throw new ArithmeticException("Incorrect system for Gauss Method");
         }

        double[] x = new double[a.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = a[i][a[i].length - 1];
        }
        double m;
        for (int k = 1; k < a.length; k++) {
            for (int j = k; j < a.length; j++) {
                m = a[j][k - 1] / a[k - 1][k - 1];
                for (int i = 0; i < a[j].length; i++) {
                    a[j][i] = a[j][i] - m * a[k - 1][i];
                }
                x[j] = x[j] - m * x[k - 1];
            }
            this.X = x;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < a.length; j++) x[i] -= a[i][j] * x[j];
            x[i] = x[i] / a[i][i];
        }

    }
    public double[] getX() {
        return X;
    }

    private static boolean checkSystem(double[][] system){
        if (system.length < 2 || system[0].length < 2 || system.length >= system[0].length ) return false;

        return true;
    }

}
































