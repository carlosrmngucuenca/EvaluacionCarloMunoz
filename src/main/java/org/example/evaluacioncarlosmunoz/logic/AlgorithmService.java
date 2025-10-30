package org.example.evaluacioncarlosmunoz.logic;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlgorithmService {

    public void ejercicio1() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("SOMOS BA");
            } else if (i % 3 == 0) {
                System.out.println("SOMOS");
            } else if (i % 5 == 0) {
                System.out.println("BA");
            } else {
                System.out.println(i);
            }
        }
    }
    public boolean ejercicio2(String s1, String s2) {

        if (s1 == null || s2 == null) return false;

        s1 = s1.toLowerCase().replaceAll("\\s+", "");
        s2 = s2.toLowerCase().replaceAll("\\s+", "");
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("Comparando: " + s1 + " vs " + s2);
        System.out.println("Ordenados: " + Arrays.toString(arr1) + " vs " + Arrays.toString(arr2));
        return Arrays.equals(arr1, arr2);

    }
    public int[] ejercicio3() {
        int arreglo[]={50,5,10,36,25,85,23,65};
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        return arreglo;
    }

}
