package com.epam.pashkov;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Yaroslav_Pashkov on 4/15/2015.
 */
public class Task2 {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> f;

    public static void main(String[] args) {
        f = scannerInput();
        String[] par = new String[f.size()];
        par = f.toArray(par);
        subtask1(par);
        subtask2(par);
        subtask3(par);
        subtask4(par);
        subtask5(par);
        subtask6(par);
        subtask7(par);
        subtask8(par);

        System.out.println("Введите размерность матрицы:");
        //Scanner scan = new Scanner(System.in);
        int s = sc.nextInt();
        //sc.close();
        subtask9(s);
    }

    public static ArrayList<String> scannerInput() {
        ArrayList<String> inputArray = new ArrayList<String>();
        //Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа:");
        while (sc.hasNextLine()) {
            String i = sc.nextLine();
            if (i.equals("Exit")) {
                break;
            }
            inputArray.add(i);
        }
        //sc.close();
        return inputArray;
    }

    public static void subtask1(String[] args)
    {
        System.out.println("---Самое длинное число---");

        int maxLength = 0;
        for(int i = 0; i<args.length; i++)
        {
            if(maxLength<=args[i].length())
            {
                maxLength = args[i].length();
            }
        }

        System.out.println("Максимальная длина числа: " + maxLength);
        System.out.println("Это числа:");
        for(int i = 0; i<args.length;i++)
        {
            if(args[i].length()==maxLength)
            {
                System.out.println(args[i]);
            }
        }

        System.out.println("---Самое короткое число---");

        int minLength = 1;
        for(int i = 0; i<args.length; i++)
        {
            if(minLength>=args[i].length())
            {
                minLength = args[i].length();
            }
        }

        System.out.println("Минимальная длина числа: " + minLength);
        System.out.println("Это числа:");
        for(int i = 0; i<args.length;i++)
        {
            if(args[i].length()==minLength)
            {
                System.out.println(args[i]);
            }
        }
    }

    public static void subtask2(String[] args)
    {
        int[] sizeOfNumsArray = new int[args.length];
        for(int i = 0; i<args.length;i++)
        {
            sizeOfNumsArray[i] = args[i].length();
        }

        System.out.println("В порядке возрастания длины:");

        for(int i = 0; i<sizeOfNumsArray.length-1; i++)
        {
            for(int j = 0; j < sizeOfNumsArray.length - i - 1; j++) {
                if (sizeOfNumsArray[j] > sizeOfNumsArray[j + 1]) {
                    int tmp = sizeOfNumsArray[j];
                    sizeOfNumsArray[j] = sizeOfNumsArray[j + 1];
                    sizeOfNumsArray[j + 1] = tmp;

                    int tmpNum = Integer.parseInt(args[j]);
                    args[j] = args[j+1];
                    args[j+1] = String.valueOf(tmpNum);
                }
            }
        }

        System.out.println(Arrays.toString(args));

        System.out.println("В порядке убывания длины:");

        for(int i = 0; i<sizeOfNumsArray.length-1; i++)
        {
            for(int j = 0; j < sizeOfNumsArray.length - i - 1; j++) {
                if (sizeOfNumsArray[j] < sizeOfNumsArray[j + 1]) {
                    int tmp = sizeOfNumsArray[j];
                    sizeOfNumsArray[j] = sizeOfNumsArray[j + 1];
                    sizeOfNumsArray[j + 1] = tmp;

                    int tmpNum = Integer.parseInt(args[j]);
                    args[j] = args[j+1];
                    args[j+1] = String.valueOf(tmpNum);
                }
            }
        }

        System.out.println(Arrays.toString(args));
    }

    public static void subtask3(String[] args)
    {
        int[] sizeOfNumsArray = new int[args.length];
        int sum = 0;
        for(int i = 0; i<args.length;i++)
        {
            sizeOfNumsArray[i] = args[i].length();
            sum+=args[i].length();
        }

        int avgSize = sum/args.length;
        System.out.println("Средняя длина составляет: "+avgSize);

        System.out.println("Длина больше средней у:");
        for(int i = 0; i<args.length;i++)
        {
            if(args[i].length()>avgSize)
            {
                System.out.println(args[i] +", длина: "+args[i].length());
            }
        }

        System.out.println("Длина меньше или равна средней у:");
        for(int i = 0; i<args.length;i++)
        {
            if(args[i].length()<=avgSize)
            {
                System.out.println(args[i] +", длина: "+args[i].length());
            }
        }
    }

    public static void subtask4(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i<args.length; i++)
        {
            if(args[i].length()>=2)
            {
                arr.add(Integer.parseInt(args[i]));
            }
        }

        int count = 1;
        int numberIt = 0;


        for(int i =0; i<arr.size(); i++)
        {
            String current = String.valueOf(arr.get(i));
            for(int j = 0; j<current.length()-1; j++)
            {
                int innerCount = 1;
                for(int k = j+1; k<current.length()-1;k++)
                {
                    if(current.charAt(j) == current.charAt(k)){
                        innerCount++;
                        if(innerCount>count){
                            count = innerCount;
                            numberIt = Integer.parseInt(current);
                        }
                    }
                }
            }
        }
        System.out.println("Количество различных символов минимально в числе:");
        System.out.println(numberIt);
    }

    public static void subtask5(String[] args)
    {
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        //счетчик чисел
        int count = 0;

        for(int i = 0; i<args.length;i++)
        {
            //символы
            String[] status = new String[args[i].length()];
            for(int j = 0; j<args[i].length();j++)
            {
                if(Integer.parseInt(String.valueOf(args[i].charAt(j)))%2!=0)
                {
                    break;
                }
                if(j==args[i].length()-1)
                {
                    count++;
                    intArr.add(Integer.parseInt(args[i]));
                }
            }
        }

        System.out.println("Числа, содержащие только четные цифры: "+intArr.toString());

        //найти максимальное количество символов
        int countEven = 0;
        int countOdd = 0;
        for(int i =0; i<intArr.size();i++)
        {
            if(intArr.get(i).toString().length()%2==0)
            {
                countEven++;
            }
            else{
                countOdd++;
            }
        }
        System.out.println("Количество четных: " + countEven + ", количество нечетных: " + countOdd);
    }

    public static void subtask6(String[] args)
    {
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        for(int i = 0; i<args.length && intArr.size()==0; i++)
        {
            if(args[i].length()>=2) {
                for (int j = 1; j < args[i].length(); j++) {
                    if (Integer.parseInt(String.valueOf(args[i].charAt(j-1))) >= Integer.parseInt(String.valueOf(args[i].charAt(j)))) {
                        break;
                    }

                    if (j == args[i].length() - 1) {
                        intArr.add(Integer.parseInt(args[i]));
                    }
                }
            }
        }
        System.out.println("Число, цифры в котором идут в строгом порядке возрастания: " + intArr);
    }

    public static void subtask7(String[] args)
    {
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        for(int i = 0; i<args.length && intArr.size()==0; i++)
        {
            if(args[i].length()>=2) {
                for (int j = 1; j < args[i].length(); j++) {
                    if (Integer.parseInt(String.valueOf(args[i].charAt(j-1))) == Integer.parseInt(String.valueOf(args[i].charAt(j)))) {
                        break;
                    }

                    if (j == args[i].length() - 1) {
                        intArr.add(Integer.parseInt(args[i]));
                    }
                }
            }
        }
        System.out.println("Число, состоящее только из различных цифр: " + intArr);
    }

    public static void subtask8(String[] args){
        double[][] leftRight = new double[f.size()][f.size()];
        double[][] topBottom = new double[f.size()][f.size()];

        int last = 1;
        for(int i = 0; i<args.length; i++)
        {
            for(int j = 0; j<args.length; j++, last++)
            {
                leftRight[i][j]=last;
                topBottom[j][i]=last;
            }
        }

        System.out.println("Заполнение слева направо:");
        print(leftRight);
        System.out.println("Заполнение сверху вниз:");
        print(topBottom);
    }

    public static void subtask9(int n)
    {
        double[][] arOriginal = new double[n][n];

        Random rand = new Random();

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                arOriginal[i][j] = rand.nextInt((n + n) + 1) - n;
            }
        }

        System.out.println("Массив случайных чисел n*n:");
        print(arOriginal);

        // Создание оригинального массива ar
        double[][] ar = cloneArray(arOriginal);

        //9.1
        for(int str = 0; str<n; str++)
        {
            for(int i = 0; i < n - 1; i++)
                for(int j = 0; j < n - i - 1; j++)
                    if(ar[str][j] > ar[str][j + 1])
                    {
                        double tmp = ar[str][j];
                        ar[str][j] = ar[str][j+1];
                        ar[str][j + 1] = tmp;
                    }
        }
        System.out.println("Массив, отсортированный по строкам:");
        print(ar);

        ar = cloneArray(arOriginal);

        for(int str = 0; str<n; str++)
        {
            for(int i = 0; i < n - 1; i++)
                for(int j = 0; j < n - i - 1; j++)
                    if(ar[j][str] > ar[j + 1][str])
                    {
                        double tmp = ar[j][str];
                        ar[j][str] = ar[j+1][str];
                        ar[j + 1][str] = tmp;
                    }
        }
        System.out.println("Массив, отсортированный по столбцам:");
        print(ar);

        ar = cloneArray(arOriginal);

        // 9.2 сдвиги
        int k = 1; // шаг сдвига
        toLeft(n,ar,k);
        print(ar);

        ar = cloneArray(arOriginal);
        toRight(n, ar, k);
        print(ar);

        ar = cloneArray(arOriginal);
        toTop(n, ar, k);
        print(ar);

        ar = cloneArray(arOriginal);
        toBottom(n, ar, k);
        print(ar);


        double[][] arN = {{2,4,-1,2},{0,4,3,1},{2,1,-4,4},{0,3,-1,4}};
        //double[][] arN = {{0,-1,-4,-1},{-3,4,3,2},{-2,-1,1,3},{-4,-4,1,1}};
        // 9.3
        ar = cloneArray(arOriginal);
        maxPositive(ar);
        maxNegative(ar);

        // 9.4
        sumInRange(ar);

        // 9.5
        ar = cloneArray(arOriginal);

        System.out.println("Поворот на 90 градусов:");
        rotate(ar, 1);
        print(ar);

        ar = cloneArray(arOriginal);

        System.out.println("Поворот на 180 градусов:");
        rotate(ar, 2);
        print(ar);

        ar = cloneArray(arOriginal);

        System.out.println("Поворот на 270 градусов:");
        rotate(ar, 3);
        print(ar);

        //9.6
        ar = cloneArray(arOriginal);
        System.out.println("Элементы строки минус среднее арифметическое:");
        avgStringMinus(ar);
        print(ar);

        //9.7
        ar = cloneArray(arOriginal);
        System.out.println("Уплотнение массива:");
        double aaa[][] = {{1,2,0,3},{0,0,0,0},{4,5,0,6},{7,8,0,9}};
        sealing(aaa);

        //9.8
        ar = cloneArray(arOriginal);
        System.out.println("Все нули в конце:");
        zeroAfter(ar);
        print(ar);
    }

    private static void toLeft(int n, double[][] ar, int l) {

        System.out.println("Массив со смещением влево:");
        for(int f = 1; f<=l; f++) {
            int k = 1;
            double[][] tempArrayNew = new double[n][k];
            //записываю столбцы начиная с позиции начала сдвига во временный массив
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    tempArrayNew[i][j] = ar[i][j];
                }
            }

            //смещаю столбцы исходной матрицы
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-1; j++) {
                    ar[i][j] = ar[i][j + 1];
                }
            }

            // записываю временную матрицу в новую
            for (int i = 0; i < n; i++) {
                ar[i][n-1] = tempArrayNew[i][0];
            }
        }
    }

    private static void toRight(int n, double[][] ar, int l) {

        System.out.println("Массив со смещением вправо:");
        for(int f = 1; f<=l; f++) {
            int k = 1;
            double[][] tempArrayNew = new double[n][k];
            //записываю столбцы начиная с позиции начала сдвига во временный массив
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    tempArrayNew[i][j] = ar[i][n - k - j];
                }
            }

            //смещаю столбцы исходной матрицы
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j > k - 1; j--) {
                    ar[i][j] = ar[i][j - 1];
                }
            }

            // записываю временную матрицу в новую
            for (int i = 0; i < n; i++) {
                ar[i][0] = tempArrayNew[i][0];
            }
        }
    }

    private static void toTop(int n, double[][] ar, int l) {

        System.out.println("Массив со смещением вверх:");
        for(int f = 1; f<=l; f++) {
            int k = 1;
            double[][] tempArrayNew = new double[1][n];
            //записываю строки начиная с позиции начала сдвига во временный массив
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    tempArrayNew[i][j] = ar[i][j];
                }
            }

            //смещаю строки исходной матрицы
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = ar[i+1][j];
                }
            }

            // записываю временную матрицу в новую
            for (int j = 0; j < n; j++) {
                ar[n-1][j] = tempArrayNew[0][j];
            }
        }
    }

    private static void toBottom(int n, double[][] ar, int l) {

        System.out.println("Массив со смещением вниз:");
        for(int f = 1; f<=l; f++) {
            int k = 1;
            double[][] tempArrayNew = new double[1][n];
            //записываю строки начиная с позиции начала сдвига во временный массив
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    tempArrayNew[i][j] = ar[n-1][j];
                }
            }

            //смещаю строки исходной матрицы
            for (int i = n-1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = ar[i-1][j];
                }
            }

            // записываю временную матрицу в новую
            for (int j = 0; j < n; j++) {
                ar[0][j] = tempArrayNew[0][j];
            }
        }
    }

    //9.3
    private static void maxPositive(double[][] ar)
    {
        ArrayList<Double> enumInGlobal = new ArrayList<Double>();
        int globalCount = 1;
        for(int i=0; i<ar.length; i++)
        {
            // числа в строке уменьшаются
            ArrayList<Double> enumInString = new ArrayList<Double>();
            //счетчик для строки
            int localCount = 1;
            int indexAL = 0;

            for(int j = 0; j<ar[i].length-1; j++)
            {
                if(ar[i][j]<ar[i][j+1])
                {
                    if(!enumInString.isEmpty()) {
                        enumInString.set(indexAL, ar[i][j]);
                    }
                    else {
                        enumInString.add(ar[i][j]);
                    }
                    localCount++;
                    enumInString.add(ar[i][j + 1]);
                    indexAL++;

                    if(globalCount<localCount){
                        globalCount=localCount;
                        //localCount=0;
                        //enumInGlobal=new ArrayList<Double>(enumInString);
                        enumInGlobal.clear();
                        enumInGlobal.addAll(enumInString);
                        //enumInString.clear();
                    }
                }

                else{
                    if(globalCount<localCount){
                        globalCount=localCount;
                        localCount=1;
                        enumInGlobal.clear();
                        enumInGlobal.addAll(enumInString);
                        enumInString.clear();
                        indexAL=0;
                    }

                    else{
                        localCount=1;
                        enumInString.clear();
                        indexAL=0;
                    }
                }
            }
        }
        System.out.println("Возрастающие элементы матрицы:");
        System.out.println(Arrays.toString(enumInGlobal.toArray()));
        System.out.println("Счетчик возрастающих элементов:");
        System.out.println(globalCount);
    }


    private static void maxNegative(double[][] ar)
    {
        ArrayList<Double> enumInGlobal = new ArrayList<Double>();
        int globalCount = 1;
        for(int i=0; i<ar.length; i++)
        {
            // числа в строке уменьшаются
            ArrayList<Double> enumInString = new ArrayList<Double>();
            //счетчик для строки
            int localCount = 1;
            int indexAL = 0;

            for(int j = 0; j<ar[i].length-1; j++)
            {
                if(ar[i][j]>ar[i][j+1])
                {
                    if(!enumInString.isEmpty()) {
                        enumInString.set(indexAL, ar[i][j]);
                    }
                    else {
                        enumInString.add(ar[i][j]);
                    }
                    localCount++;
                    enumInString.add(ar[i][j + 1]);
                    indexAL++;

                    if(globalCount<localCount){
                        globalCount=localCount;
                        //localCount=0;
                        //enumInGlobal=new ArrayList<Double>(enumInString);
                        enumInGlobal.clear();
                        enumInGlobal.addAll(enumInString);
                        //enumInString.clear();
                    }
                }

                else{
                    if(globalCount<localCount){
                        globalCount=localCount;
                        localCount=1;
                        enumInGlobal.clear();
                        enumInGlobal.addAll(enumInString);
                        enumInString.clear();
                        indexAL=0;
                    }

                    else{
                        localCount=1;
                        enumInString.clear();
                        indexAL=0;
                    }
                }
            }
        }
        System.out.println("Убывающие элементы матрицы:");
        System.out.println(Arrays.toString(enumInGlobal.toArray()));
        System.out.println("Счетчик убывающих элементов:");
        System.out.println(globalCount);
    }

    // 9.4
    private static void sumInRange(double[][] ar)
    {
        int start = 0;
        int stop = 0;
        double sum = 0;

        for(int i = 0; i<ar.length; i++)
        {
            for(int j = 0; j<ar[i].length; j++)
            {
                // первый положительный элемент
                if(ar[i][j]>=0)
                {
                    start=j;
                    break;
                }
            }

            for(int j = start+2; j<ar[i].length; j++)
            {
                // второй положительный элемент
                if (ar[i][j] >= 0)
                {
                    stop = j;
                    break;
                }
            }

            // находим сумму
            for(int j = start+1; j<stop; j++)
            {
                if(start+1 != stop && start < stop) {
                    sum+=ar[i][j];
                }
            }

            //Обнуляем позиции
            start = 0;
            stop = 0;
        }
        System.out.println("Сумма элементов между первым и вторым положительными равна: "+sum);
    }

    // 9.5
    private static void rotate(double[][] ar, int n)
    {
        double[][] arClone = cloneArray(ar);
        for(int r = 0; r<n; r++) {
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[i].length; j++) {
                    ar[i][j] = arClone[j][ar.length - i - 1];
                }
            }
            arClone = cloneArray(ar);
        }
    }

    //9.6
    private static void avgStringMinus(double[][] ar)
    {
        // массив средних арифметических для каждой строки
        double[] avg = new double[ar.length];
        for(int i = 0; i<ar.length; i++)
        {
            double sum = 0;
            for(int j = 0; j<ar[i].length; j++)
            {
                sum+=ar[i][j];
            }
            avg[i]=sum/ar.length;

            for(int j = 0; j<ar[i].length; j++)
            {
                ar[i][j]-=avg[i];
            }
        }
    }

    //9.7
    private static void sealing(double[][] ar)
    {
        // Строки, заполненные нулями
        double[][] tempArray;
        for(int i = 0; i<ar.length; i++)
        {
            boolean del = false;
            for(int j = 0; j<ar[0].length; j++)
            {
                if(ar[i][j]==0){
                    if(j==ar[i].length-1){
                        del = true;
                    }
                    continue;
                }
                else{
                    break;
                }
            }

            if(del){
                tempArray = new double[ar.length-1][ar.length];
                //toBottom(ar.length,ar,ar.length-i-1);

                for(int l = i; l<ar.length-1; l++)
                {
                    for(int m=0; m<ar[l].length; m++)
                    {
                        double temp = ar[l][m];
                        ar[l][m] = ar[l+1][m];
                        ar[l+1][m] = temp;
                    }
                }

                for(int l = 0; l<tempArray.length; l++)
                {
                    for(int m = 0; m<tempArray[i].length;m++)
                    {
                        tempArray[l][m]=ar[l][m];
                    }
                }
                ar=tempArray;
            }
        }

        //Столбцы, заполненные нулями
        for(int i = 0; i<ar[0].length; i++)
        {
            boolean del = false;
            for(int j = 0; j<ar.length; j++)
            {
                if(ar[j][i]==0){
                    if(j==ar.length-1){
                        del = true;
                    }
                    continue;
                }
                else{
                    break;
                }
            }

            if(del){
                tempArray = new double[ar.length][ar[0].length-1];

                for(int l = 0; l<ar.length; l++)
                {
                    for(int m=i; m<ar[l].length-1; m++)
                    {
                        double temp = ar[l][m];
                        ar[l][m] = ar[l][m+1];
                        ar[l][m+1] = temp;
                    }
                }

                for(int l = 0; l<tempArray.length; l++)
                {
                    for(int m = 0; m<tempArray[i].length;m++)
                    {
                        tempArray[l][m]=ar[l][m];
                    }
                }
                ar = tempArray;
            }
        }

        print(ar);
    }

    // 9.8
    private static void zeroAfter(double[][] ar)
    {
        for(int st = 0; st<ar.length;st++) {
            for (int i = 0; i < ar.length - 1; i++)
                for (int j = 0; j < ar.length - i - 1; j++)
                    if (ar[st][j] == 0) {
                        double temp = ar[st][j];
                        ar[st][j]=ar[st][j+1];
                        ar[st][j+1]=temp;
                    }
        }
    }

    private static double[][] cloneArray(double[][] ar)
    {
        double[][] arClone = new double[ar.length][ar.length];
        for(int i = 0; i<ar.length; i++){
            for(int j = 0; j<ar[i].length; j++)
            {
                arClone[i][j] = ar[i][j];
            }
        }
        return arClone;
    }


    private static void print(double[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}