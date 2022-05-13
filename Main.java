package com.kuliah;

import java.util.Scanner;

class Peserta {
    String nama;
    double nilaiA;
    double nilaiB;
    double total;

    Peserta(String nama, double nilaiA, double nilaiB) {
        this.nama = nama;
        this.nilaiA = nilaiA;
        this.nilaiB = nilaiB;
        this.total = nilaiA + nilaiB;
    }
}

class Sort {
    Peserta[] peserta;
    int jumlah;

    Sort(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setPeserta(Peserta[] peserta) {
        this.peserta = peserta;
    }

    public void bubbleSort() {
        for (int i = 0; i < jumlah - 1; i++) {
            for (int j = 0; j < jumlah - i - 1; j++) {
                if (peserta[j].nilaiB > peserta[j + 1].nilaiB) {
                    Peserta temp = peserta[j];
                    peserta[j] = peserta[j + 1];
                    peserta[j + 1] = temp;
                    if (peserta[j].nilaiB == peserta[j + 1].nilaiB) {
                        if (peserta[j].nilaiA > peserta[j].nilaiA) {
                            Peserta curr = peserta[j];
                            peserta[j] = peserta[j + 1];
                            peserta[j + 1] = curr;
                        }
                    }
                }
            }
        }
    }

    public int search(String nama) {
        for (int i = 0; i < jumlah; i++) {
            if (peserta[i].nama.equals(nama)) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlah = input.nextInt();
        int rank = input.nextInt(); input.nextLine();
        Sort sort = new Sort(jumlah);
        Peserta[] peserta = new Peserta[jumlah];

        for (int i = 0; i < peserta.length; i++) {
            peserta[i] = new Peserta(input.next(), input.nextDouble(), input.nextDouble());
        }
        sort.setPeserta(peserta);
        sort.bubbleSort();

        int index = sort.search(input.next());
        if (index < rank) {
            System.out.println("LOLOS");
        } else {
            System.out.println("GAGAL");
        }
    }
}