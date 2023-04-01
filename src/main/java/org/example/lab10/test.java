package org.example.lab10;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    private static int[][] weightInt;
    private static String[][] weight;

    private static int vertices;
    private static int edges;
    private static Map<String,Integer> map = new HashMap<>();


    public static void initGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                vertices = Integer.parseInt(line.split(" ")[0]);
                edges = Integer.parseInt(line.split(" ")[1]);
                weightInt = new int[vertices][vertices];
                weight = new String[vertices][vertices];
                for (int i =0;i<vertices;i++){
                    Arrays.fill(weight[i],"∞");
                }

                for (int i =0;i<vertices;i++){
                    weight[i][i]="0";
                }


            } else {
                System.out.println("empty input file");
                return;
            }
            line = reader.readLine();
            int counter=0;
            while (line != null) {
                if (!map.containsKey(line.split(" ")[0])){
                    map.put(line.split(" ")[0],counter++);
                }
                if (!map.containsKey(line.split(" ")[1])){
                    map.put(line.split(" ")[1],counter++);
                }
                makeWeightMatrix(line);
                line = reader.readLine();
            }
        }
    }

    public static void makeWeightMatrix(String line) {
        String from = line.split(" ")[0];
        String to =line.split(" ")[1];
        int lineWeight = Integer.parseInt(line.split(" ")[2]);
        weight[map.get(from)][map.get(to)]=String.valueOf(lineWeight);
        weightInt[map.get(from)][map.get(to)]=lineWeight;
    }

    public static String weightMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        String [] test = map.keySet().toArray(new String[0]);
        Arrays.sort(test);
        for (String s : test){
            result.append(String.format(" %-3s|", s));
        }
        for (String s : test){
            result.append(String.format("\n| %-3s |", s));
            Arrays.stream(weight[map.get(s)]).forEach(value -> result.append(String.format(" %2s |", value)));
        }
        return result.toString();
    }






    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input path to file(or name): ");
        String filePath = scanner.nextLine();
        try {
            initGraph(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("incorrect input file");
            throw new RuntimeException(e);
        }
        String fileToSave;
        int menu;
        do {
            System.out.println("Chose operation:");
            System.out.println("1: Print weight matrix into console");
            System.out.println("2: Save weight matrix into file");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu=scanner.nextInt();
            switch (menu){
                case 1:
                    printMatrix(weightMatrixToString());
                    break;
                case 2:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave= scanner.nextLine()+".txt";
                    saveMatrixToFile(weightMatrixToString(),fileToSave);
                    break;
                default: break;
            }
        }while (menu!=0);
    }






    public static void printMatrix(String matrix){
        System.out.println(matrix);
    }
    public static void saveMatrixToFile(String matrix,String filePath){
        try(PrintWriter printWriter = new PrintWriter(filePath)){
            printWriter.println(matrix);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Cannot find file to write");
        }

    }



}
