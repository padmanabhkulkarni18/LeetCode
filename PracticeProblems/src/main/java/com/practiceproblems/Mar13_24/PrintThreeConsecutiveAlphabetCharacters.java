package com.practiceproblems.Mar13_24;

public class PrintThreeConsecutiveAlphabetCharacters {

    public static void main(String[] args) {

        char charInput = 'y';

        //X -->YZa
        //A --> BCD
        //

        System.out.println((int) charInput);
        int i=0;
        boolean isLower= false;
        int charInputInt = charInput+1;
        StringBuilder stringBuilder = new StringBuilder();
        int switchCounter =0;
        while(i<3){
            if(charInputInt>= 97 && charInputInt<=122){
                stringBuilder.append((char)charInputInt);
                isLower=true;
                //lowercase
            }
            if(charInputInt>= 65 && charInputInt<=90){
                //upperCase
                stringBuilder.append((char)charInputInt);
            }


            if(isLower==true && charInputInt>122){
                int final1 = 65+switchCounter;
                stringBuilder.append((char)final1);
                switchCounter++;
            }

            if(!isLower && charInputInt>90){
                int final1 = 97+switchCounter;
                stringBuilder.append((char)final1);
                switchCounter++;
            }

            charInputInt++;
            i++;
        }

        System.out.println(stringBuilder.toString());


    }


}
