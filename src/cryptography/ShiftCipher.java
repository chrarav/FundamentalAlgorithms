package cryptography;

import java.util.Scanner;

/**
 * @author: chrarav
 * @date: 8 April 2023
 * @description: Upgrade of shiftCipher
 * @key: Permute the letters by some shift
 * @Start: 10:27
 * @approximateTime:
 *
 */

public class ShiftCipher {

   static char [][] arr ={
            {'a', 'd'},
            {'b', 'e'},
            {'c', 'f'},
            {'d', 'g'},
            {'e', 'h'},
            {'f', 'i'},
            {'g', 'j'},
            {'h', 'k'},
            {'i', 'l'},
            {'j', 'm'},
            {'k', 'n'},
            {'l', 'o'},
            {'m', 'p'},
            {'n', 'q'},
            {'o', 'r'},
            {'p', 's'},
            {'q', 't'},
            {'r', 'u'},
            {'s', 'v'},
            {'t', 'w'},
            {'u', 'x'},
            {'v', 'y'},
            {'w', 'z'},
            {'x', 'a'},
            {'y', 'b'},
            {'z', 'c'},
            {' ', ' '},
            {',', ','},
            {'!', '!'},
            {'.', '.'},
            {'?', '?'},
   };


    public static void displayArrayChar(char[ ] [] arr){
        for(int i =0; i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static String promptInput(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter a String: ");
        String str = keyboard.nextLine();
        return str;
    }


    public static int findCharForEncryption(char c){
        int n = 0;
        for(int i=0;i<arr.length;i++){
            if(c==arr[i][0]){
                n=i;
            }
        }
        return n;
    }

    public static String encryptMessage(String str){
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int n=findCharForEncryption(c);
            str = str.substring(0,i)+arr[n][1]+str.substring(i+1);
        }

        return str;
    }


    public static int findCharForDecryption(char c){
        int n = 0;
        for(int i=0;i<arr.length;i++){
            if(c==arr[i][1]){
                n=i;
            }
        }
        return n;
    }

    public static String decryptMessage(String str){
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int n=findCharForDecryption(c);
            str = str.substring(0,i)+arr[n][0]+str.substring(i+1);
        }
        return str;
    }



        public static void main(String[] args) {

        String str = promptInput();
        System.out.println("Original message: "+str);

        String encryptedMessage= encryptMessage(str);
        System.out.println("Encrypted message: "+ encryptedMessage);

        String decryptedMessage = decryptMessage(encryptedMessage);
        System.out.println("Decrypted message: "+decryptedMessage);
    }
}
