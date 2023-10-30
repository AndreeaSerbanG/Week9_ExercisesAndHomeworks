import java.util.Arrays;
import java.util.Scanner;

public class Arrays_OperatiiMultimi {
    /*The program reads two arrays (A and B respectively) from the keyboard, each representing a set of numbers
    and implements the difference, intersection and union operations between the two arrays.
     */

    //metoda de citire array de la tasatura
    public static int[] readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numarul de numere:");
        int arrayLength = sc.nextInt();

        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduceti numarul " + (i + 1) + ":");
            array[i] = sc.nextInt();
        }

        return array;
    }

    public static void printResults(int[] result, int index){
        for(int i = 0; i < index ; i++){
            if( i == index-1){
                System.out.print(result[i]);
                break;
            }
            System.out.print( result[i] + ", ");
        }
    }
    //metoda care returneaza rezultatul diferentei dintre arrayA si arrayB
    public static void differenceAB(int[] arrayA, int[] arrayB) {

        int[] result = new int[arrayA.length];
        int index = 0;

        for (int i = 0; i < arrayA.length; i++) {
            boolean iEqualsJ = false;
            for(int j = 0; j < arrayB.length; j++){
                if (arrayA[i] == arrayB[j]) {
                    iEqualsJ = true;
                    break;
                }
            }
            if(!iEqualsJ){
                result[index] = arrayA[i];
                index++;

            }
        }
        result = Arrays.copyOf(result, index);
        BubbleSort.bubbleSort(result);
        printResults(result, index);
    }
    //metoda care returneaza rezultatul intersectiei dintre arrayA si arrayB
    public static void intersectionAB(int[] arrayA, int[] arrayB) {
        int[] result = new int[arrayA.length];
        int index = 0;

        for (int i = 0; i < arrayA.length; i++) {
            boolean iEqualsJ = false;
            for(int j = 0; j < arrayB.length; j++){
                if (arrayA[i] == arrayB[j]) {
                    iEqualsJ = true;
                    break;
                }
            }
            if(iEqualsJ){
                result[index] = arrayA[i];
                index++;
            }
        }
        result = Arrays.copyOf(result, index);
        BubbleSort.bubbleSort(result);
        printResults(result, index);
    }
    // metoda care returneaza rezultatul reuniunii dintre arrayA si arrayB
    public static void unionAB(int[] arrayA, int[] arrayB) {
        int[] result = Arrays.copyOf(arrayA, arrayA.length + arrayB.length);
        int emptyIndex = arrayA.length;
        for (int i = 0; i < arrayB.length; i++) {
            boolean iEqualsJ = false;
            for(int j = 0; j < arrayA.length; j++){
                if (arrayB[i] == arrayA[j]) {
                    iEqualsJ = true;
                    break;
                }
            }
            if(!iEqualsJ){
                result[emptyIndex] = arrayB[i];
                emptyIndex++;
            }
        }
        result = Arrays.copyOf(result, emptyIndex);
        BubbleSort.bubbleSort(result);
        printResults(result, emptyIndex);
    }
    public static void main(String[] args) {
        int[] arrayA = readArray();
        int[] arrayB = readArray();

        System.out.print("Diferenta dintre multimea A si multimea B este: \n A \\ B = {");
        differenceAB(arrayA, arrayB);
        System.out.println("}");
        System.out.print("Intersectia multimilor A si B este : \n A \u2229 B = {");
        intersectionAB(arrayA, arrayB);
        System.out.println("}");
        System.out.print("Reuniunea multimilor A si B este : \n A \u222A B = {");
        unionAB(arrayA, arrayB);
        System.out.println("}");
    }
}
