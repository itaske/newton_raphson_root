package com.stableshield;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewtonRaphson {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Level of polynomial");
        int level = input.nextInt();
        double array[] = new double [level+1];

        //map to hold the coefficient positions
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "First");
        map.put(2,"Second");
        map.put(3,"Third");
        map.put(4,"Fourth");

        //fill the coefficients in an array
        for (int k=0; k<level+1; k++){
            System.out.println("Enter "+map.get(k+1));
            array[k] = input.nextDouble();
        }

        //print the root of the equation using newton raphson
        System.out.println(root(5, array, 0.046));

    }

    public static double root (double initialGuess, double array[], double percentError){
        double guess = initialGuess;
        double fx = 0;
        double defx = 0;

        double percentDiff = 1;
        double newGuess = 0;
        while(percentDiff > percentError){
            fx=0;
            defx=0;
            for (int i=0; i<array.length; i++){
                fx+=(array[i])*(Math.pow(guess, array.length -1-i));

                if (i != array.length-1){
                    defx+=(array[i])* (array.length -1-i)*(Math.pow(guess, array.length -1-i-1));
                }
            }
             newGuess = guess - (fx/defx);
             System.out.println("New Guess "+newGuess);
             percentDiff = Math.abs((guess - newGuess)/guess);
             System.out.println("Percent Difference "+percentDiff);


            guess = newGuess;

        }

        return guess;
    }
}
