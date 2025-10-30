package org.example.evaluacioncarlosmunoz;

import org.example.evaluacioncarlosmunoz.logic.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class EvaluacionCarlosMunozApplication implements CommandLineRunner {

    @Autowired
    private AlgorithmService algorithmService;

    public static void main(String[] args) {
        SpringApplication.run(EvaluacionCarlosMunozApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n=======================================================");
        System.out.println("EJECUTANDO EJERCICIOS DE LÓGICA AL INICIAR");
        System.out.println("=======================================================\n");

        // --- Ejercicio 1: SOMOS BA (FizzBuzz) ---
        System.out.println("----------[ Ejercicio 1: SOMOS BA ]----------");
        algorithmService.ejercicio1();
        System.out.println("----------------------------------------------\n");

        // --- Ejercicio 2: Anagramas ---
        System.out.println("----------[ Ejercicio 2: Anagramas ]----------");
        String s1 = "ACUERDO";
        String s2 = "ECUADOR";
        boolean areAnagrams = algorithmService.ejercicio2(s1, s2);
        System.out.printf("¿'%s' y '%s' son anagramas? -> %b\n", s1, s2, areAnagrams);
        System.out.println("-----------------------------------------------\n");

        // --- Ejercicio 3: Ordenar Arreglo ---
        System.out.println("----------[ Ejercicio 3: Ordenar Arreglo ]----------");
        int[] arreglo = {50, 5, 10, 36, 25, 85, 23, 65};
        System.out.println("Arreglo Original: " + Arrays.toString(arreglo));
        int[] arregloOrdenado = algorithmService.ejercicio3();
        System.out.println("Arreglo Ordenado (Mayor a Menor): " + Arrays.toString(arregloOrdenado));
        System.out.println("---------------------------------------------------\n");

        System.out.println("=======================================================");
        System.out.println("EJERCICIOS DE LÓGICA COMPLETADOS. LA APLICACIÓN ESTÁ LISTA.");
        System.out.println("=======================================================\n");
    }

}
