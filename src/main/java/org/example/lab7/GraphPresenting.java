package org.example.lab7;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class GraphPresenting {
    private static int[][] incidence;
    private static int[][] adjacency;
    private static int vertices;
    private static int edges;


    public static void initGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                vertices = Integer.parseInt(line.split(" ")[0]);
                edges = Integer.parseInt(line.split(" ")[1]);
                incidence = new int[vertices][edges];
                adjacency = new int[vertices][vertices];
            } else {
                System.out.println("empty input file");
                return;
            }
            int lineNumber = 0;
            line = reader.readLine();
            while (line != null) {
                makeIncidenceMatrix(line, lineNumber);
                makeAdjacencyMatrix(line);
                line = reader.readLine();
                lineNumber++;
            }
        }
    }

    public static void makeIncidenceMatrix(String line, int lineNumber) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);

        if (from == to) {
            incidence[from - 1][lineNumber] = 2;
        } else {
            incidence[from - 1][lineNumber] = -1;
            incidence[to - 1][lineNumber] = 1;
        }
    }

    public static void makeAdjacencyMatrix(String line) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        adjacency[from - 1][to - 1]++;
    }

    public static String adjacencyMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 1; i <= vertices; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        for (int i = 0; i < adjacency.length; i++) {
            result.append(String.format("\n| v%-2d |", i + 1));
            Arrays.stream(adjacency[i]).forEach(value -> result.append(String.format(" %2d |", value)));

        }
        return result.toString();
    }

    public static String incidenceMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\e |");
        for (int i = 1; i <= edges; i++) {
            result.append(String.format(" e%-2d|", i));
        }
        for (int i = 0; i < incidence.length; i++) {
            result.append(String.format("\n| v%-2d |", i + 1));
            Arrays.stream(incidence[i]).forEach(value -> result.append(String.format(" %2d |", value)));
        }
        return result.toString();
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
            System.out.println("1: Print incidence(інцидентності) matrix into console");
            System.out.println("2: Print adjacency(суміжності) matrix into console");
            System.out.println("3: Save incidence(інцидентності) matrix into file");
            System.out.println("4: Save incidence(суміжності) matrix into file");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu=scanner.nextInt();
            switch (menu){
                case 1:
                    printMatrix(incidenceMatrixToString());
                    break;
                case 2:
                    printMatrix(adjacencyMatrixToString());
                    break;
                case 3:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave= scanner.nextLine()+".txt";
                    saveMatrixToFile(incidenceMatrixToString(),fileToSave);
                    break;
                case 4:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave = scanner.nextLine()+".txt";
                    saveMatrixToFile(adjacencyMatrixToString(),fileToSave);
                    break;
                default: break;
            }
        }while (menu!=0);
    }
    public static void main(String[] args) throws IOException {
        initGraph("graph_01_1.txt");
        int[][] res = degree();
        System.out.println(isOdnoridnii(res));
        boolean[][] res2 = visachiy(res);
        res2[0][0]=true;
        res2[3][1]=true;
        res2[4][0]=true;
        for (boolean[] a: res2){
            System.out.println(Arrays.toString(a));
        }
        for (int[] a: res){
            System.out.println(Arrays.toString(a));
        }
        printMatrix(adjacencyMatrixToString());
        System.out.println( degreeToString(res));
        System.out.println( visachiyToString(res2));

        //menu();
    }

    public static int[][] degree(){
        int[][] result = new int[vertices][2];
        for (int i=0;i<vertices;i++){
            for (int j = 0;j<vertices;j++){
                result[i][0]+=adjacency[i][j];
                result[j][1]+=adjacency[i][j];
            }
        }
        return result;
    }
    public static int isOdnoridnii(int[][] degree){
        int k = degree[0][0];
        long count = Arrays.stream(degree)
                .flatMap((Function<int[], Stream<?>>) ints -> Arrays.stream(ints).boxed())
                .mapToInt(x-> (Integer)x)
                .filter(x->x!=3)
                .count();
        return count!=0?-1:k;
    }

    //0 -ізольована
    //1 - висяча
    public static boolean[][] visachiy(int[][] degree){
        boolean[][] res = new boolean[vertices][2];
        for (int i=0;i<degree.length;i++){
            if (degree[i][0]+degree[i][1]==0) res[i][0]=true;
            if (degree[i][0]+degree[i][1]==1) res[i][1]=true;
        }
        return res;
    }

    public static String degreeToString(int[][] degree){
        StringBuilder result = new StringBuilder();
        result.append("|  v  | напівстепені входу | напівстепені виходу |\n");
        for (int i=0;i<degree.length;i++){
            result.append(String.format("| v%-2d | %18d | %19d |\n",i+1,degree[i][0],degree[i][1]));
        }
        return result.toString();
    }


    public static String visachiyToString(boolean[][] visachii){
        StringBuilder result = new StringBuilder();
        result.append("| Ізольовані вершини | Висячі вершини |\n");
        for (int i=0;i<visachii.length;i++){
            if (visachii[i][0]&&visachii[i][1]) result.append(String.format("| %18s | %14s |\n","v"+i,"v"+i));
            else if (visachii[i][0])result.append(String.format("| %18s | %14s |\n","v"+i+1,""));
            else if (visachii[i][1])result.append(String.format("| %18s | %14s |\n","","v"+i+1));
        }
        return result.toString();
    }
}
