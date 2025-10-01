package org.example;

public class Funcoes {

    public int fa(int n) {
        int i, j, k;
        int res = 0;
        int cont_op = 0;

        for (i = 1; i <= n * n; i += 1) {
            for (j = 1; j <= i; j += 2) {
                for (k = n + 1; k <= 2 * i; k += i * j) {
                    res = res + (k + 1);
                    cont_op++;
                }
            }
        }

        return cont_op;
    }

    public int fb(int n) {
        int i, j, k;
        int res = 0;
        int cont_op = 0;

        for (i = n; i <= n; i += i / 2 + 1) {
            for (j = i / 2; j <= i * i; j += i + 1) {
                for (k = n; k <= 2 * n; k += i + 1) {
                    res = res + n;
                    cont_op++;
                }
            }
        }

        return cont_op;
    }

    public int fc(int n) {
        int i, j, k;
        int res = 0;
        int cont_op = 0;

        for (i = 1; i <= n * n; i += 2) {
            for (j = i / 2; j <= 2 * i; j += i / 2 + 1) {
                for (k = j + 1; k <= n + j; k += k / 2 + 1) {
                    res = res + Math.abs(j - i);
                    cont_op++;
                }
            }
        }

        return cont_op;
    }

    public int fd(int n) {
        int i, j, k;
        int res = 0;
        int cont_op = 0;

        for (i = 1; i <= n * n; i += 2) {
            for (j = 2; j <= n + 1; j += i + 1) {
                for (k = j / 2; k <= i + 1; k += j / 2 + 1) {
                    res = res + j + 1;
                    cont_op++;
                }
            }
        }

        return cont_op;
    }

    public int fe(int n) {
        int i, j, k;
        int res = 0;
        int cont_op = 0;

        for (i = n / 2; i <= n; i += 3) {
            for (j = i; j <= i * i; j += 2) {
                for (k = i; k <= 2 * j; k += 1) {
                    res = res + n + j;
                    cont_op++;
                }
            }
        }

        return cont_op;
    }
}
