package matrix;

public final class  matrixRang {

    int rang;
    public  matrixRang(double[][] A)
    {
        int r = 0;
        int q = 1;

        while(q<=Math.min(A.length,A[0].length)) // проверка: порядок матрицы меньше или равен минимальному из размеров матрицы?
        { // если да
            double[][] B = new  double[q][q]; // создаем новую матрицу размера q


            for(int a=0;a<(A.length-(q-1));a++) // тут начинается перебор матриц q-го порядка
            {
                for(int b=0;b<(A[0].length-(q-1));b++)
                {
                    for(int c=0;c<q;c++)
                    {
                        System.arraycopy(A[a + c], b, B[c], 0, q);
                    }
                    Determine dd = new Determine(B);
                    if(dd.getValue()!=0) // если определитель матрицы отличен от нуля
                    { // то
                        r = q; // присваиваем рангу значение q
                    }
                }
            }
            q++; // прибавляем 1
        }

        this.rang = r;

    }
    public int rang() {
        return rang;
    }
}

class Determine {
    private double sum;

    public Determine(double[][] matrix) {
        getReduction(matrix, 1);
    }


    public double getValue() {

        return this.sum;

    }


    private void getReduction(double[][] subMinor, double elemParentMinor) {
        if (subMinor.length > 1) {
            double[][] tmpMinor = new double[subMinor.length - 1][subMinor[0].length - 1];
            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }
                double paramForSub = Math.pow(-1, c + 2) * subMinor[0][c] * elemParentMinor;
                getReduction(tmpMinor, paramForSub);
            }
        } else
            this.sum += elemParentMinor * subMinor[0][0];
    }
}






























