package org.example.lab12;

import java.io.*;
import java.util.*;

public class GraphPresenting {
    private static int[][] weightInt;
    private static String[][] weight;

    private static int vertices;
    private static int edges;
    private static String[] p;
    private static int[] d;


    public static void initGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                vertices = Integer.parseInt(line.split(" ")[0]);
                edges = Integer.parseInt(line.split(" ")[1]);
                weightInt = new int[vertices][vertices];
                weight = new String[vertices][vertices];
                p = new String[vertices];
                d = new int[vertices];
                for (int i = 0; i < vertices; i++) {
                    Arrays.fill(weight[i], "∞");
                    Arrays.fill(weightInt[i],Integer.MAX_VALUE);
                }




            } else {
                System.out.println("empty input file");
                return;
            }
            line = reader.readLine();
            while (line != null) {
                makeWeightMatrix(line);
                line = reader.readLine();
            }
            for (int i = 0; i < vertices; i++) {
                weight[i][i] = "0";
                weightInt[i][i] = 0;
            }
        }
    }

    private static int convertVertex(String v) {
        return v.equals("v") ? vertices - 1 : Integer.parseInt(v.substring(1));
    }
    private static String convertVertex(Integer pos) {
        return pos==(vertices-1) ? "v" : "v"+pos;
    }

    public static String printDistance(String v){
        StringBuilder stringBuilder = new StringBuilder("\n");
        int pos = convertVertex(v);
        for (int i=0;i<vertices;i++){
            if (i==pos)continue;
            stringBuilder.append(String.format("%-3s -> %-3s | %-3d\n",v,convertVertex(i),d[i]));
        }
        return stringBuilder.toString();
    }

    public static String printDistance(String v1,String v2){
        List<String> list = new ArrayList<>();
        String current = v2;
        while(current!=null){
            list.add(current);
            current = p[convertVertex(current)];
        }
        Collections.reverse(list);
        return String.format(String.format("%-3s -> %-3s | %-3d | %s\n",v1,v2,d[convertVertex(v2)],list));
    }


    public static void deykstry(String v) {
        int pos = convertVertex(v);
        List<Integer> notUsed = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (pos == i) continue;
            d[i] = weightInt[pos][i];
            p[i]=v;
            notUsed.add(i);
        }

        for (int i = 0; i < vertices - 1; i++) {

            int min = notUsed.stream().min(Comparator.comparingInt(o -> d[o])).get();

            for (int j=0;j<notUsed.size();j++){
                if (notUsed.get(j)==min){
                    notUsed.remove(j);
                    break;
                }
            }

            for (int j: notUsed){

                if (d[min]!=Integer.MAX_VALUE&&weightInt[min][j]!=Integer.MAX_VALUE){
                    if (weightInt[min][j]+d[min]<d[j]){
                        p[j]=convertVertex(min);
                        d[j]=weightInt[min][j]+d[min];
                    }
                }
            }
        }


    }


    public static void makeWeightMatrix(String line) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        int lineWeight = Integer.parseInt(line.split(" ")[2]);
        weight[from][to] = String.valueOf(lineWeight);
        weightInt[from][to] = lineWeight;

    }

    public static String weightMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 0; i < vertices - 1; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        result.append("  v |");
        for (int i = 0; i < weight.length - 1; i++) {
            result.append(String.format("\n| v%-2d |", i));
            Arrays.stream(weight[i]).forEach(value -> result.append(String.format(" %2s |", value)));

        }
        result.append("\n|  v  |");
        Arrays.stream(weight[weight.length - 1]).forEach(value -> result.append(String.format(" %2s |", value)));
        return result.toString();
    }




    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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
            System.out.println("3: Print distance from vertex");
            System.out.println("4: Print distance between two vertices");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    printMatrix(weightMatrixToString());
                    break;
                case 2:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave = scanner.nextLine() + ".txt";
                    saveMatrixToFile(weightMatrixToString(), fileToSave);
                    break;
                case 3:
                    System.out.print("input vertex: ");
                    scanner.nextLine();
                    String v = scanner.nextLine();
                    deykstry(v);
                    System.out.println(printDistance(v));
                    break;
                case 4:
                    System.out.print("input first vertex: ");
                    scanner.nextLine();
                    String v1 = scanner.nextLine();
                    System.out.print("input second vertex: ");
                   // scanner.nextLine();
                    String v2 = scanner.nextLine();
                    deykstry(v1);
                    System.out.println(printDistance(v1,v2));
                    break;
                default:
                    break;
            }
        } while (menu != 0);
    }


    public static void printMatrix(String matrix) {
        System.out.println(matrix);
    }

    public static void saveMatrixToFile(String matrix, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.println(matrix);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cannot find file to write");
        }

    }


}
