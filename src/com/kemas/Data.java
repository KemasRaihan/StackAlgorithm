package com.kemas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;


public class Data {
    public static ArrayList<Integer> genData(int n)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Random r = new Random();

        int size = 0;
        int num;

        while(res.size() < n){
            num = (int)(r.nextInt(n*2));
            if(!res.contains(num))
                res.add(num);
        }

        return res;
    }

    public static void printArray (ArrayList<Integer> data) {

        for(int i=0; i<data.size(); i++) {
                System.out.print(data.get(i)+"\t");
            System.out.println();
        }
    }

    public static double [] readFile (String fileName){

        double [] res = null;

        try {

            FileReader fr = new FileReader (fileName);
            BufferedReader br = new BufferedReader (fr);

            int col=0, row=0;
            String line = null;

            //need to know how many rows and cols in the csv file
            while ((line = br.readLine()) != null)
            {
                row++;
                String [] column = line.split(",");
                col = column.length;

            }

            int i=0, j=0;
            res = new double [row]; //set the size of the array after we have known the row and col
            //System.out.println(col+" "+row);

            br = new BufferedReader (new FileReader (fileName)); //this has to be initiated again!

            while ((line = br.readLine()) != null)
            {
                String [] column = line.split(",");

                for (j=0; j<column.length; j++)
                {
                    res [i] = Double.parseDouble(column [j]) ;
                }

                i++;
            }

        }
        catch(Exception e) {
            System.err.print("Error");
        }


        return res;
    }

    public static void writeResult(int[] iterations, double[] timeUsingTemp, double[] timeUsingRecursion) {

        String fn = iterations.length+".csv";

        try {

            FileWriter fw = new FileWriter(fn);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i < iterations.length; i=i+100){
                bw.write(Double.toString(iterations[i]));
                bw.write(",");
                bw.write(Double.toString(timeUsingTemp[i]));
                bw.write(",");
                bw.write(Double.toString(timeUsingRecursion[i]));
                bw.newLine();
            }

            bw.close();
            fw.close();

        }
        catch(Exception e) {
            System.err.print("Error");
        }
    }




    public static void main(String[] args) {

        ArrayList<Integer> data = genData(500);
        //printArray(data);
        //writeData(data);

        printArray(data);
    }

}