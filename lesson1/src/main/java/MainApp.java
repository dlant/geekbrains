//package ru.geekbrains.lesson1;

public class MainApp {


        public static void main(String[] args) {

            byte bt = 98; short srt = 17999; int val = 12345678; long lg = 200100500L; float ft = 96.6f;
            double dl = 12888.128888;
            char ch = '$';
            boolean bln = true;

        printSomething(calculate(2,3,10,14));     ///// 3) задача

        printSomething(task10and20(10,30));                 ///// 4) задача

        printSomething(isPositiveOrNegative(10));                      ///// 5) задача

        isNegative(-10);                                ///// 6) задача

            String str = "Привет, ";
            printSomething(str+"Диман"+"!");         //// 7) задача

            isYear(2119);                       /////* 8ая задача
    }

    ///*8
           public static void isYear(int z){
                String yes ="Год " + z + " - високосный";
                String no = "Год " + z + " - невисокосный";

                if (z < 0){
                    printSomething("Год не может быть отрицательным");
                return;
                }
                if (z>2100){
                    printSomething("какая тебе разница, столько не живут))");
                }
                    if (z%400==0){                 //каждый 400ый?
                        printSomething(yes);
                    return;
                }

                if (z%100==0){                     //каждый 100ый?
                    printSomething(no);
                    return;
                }

                    if (z%4==0) {                  //каждый 4ый?
                    printSomething(yes);}

                    else printSomething(no);

        }

///// 3
        public static float calculate ( float a, float b, float c, float d){

        return a * (b + (c / d));
        }

//// 4
        public static boolean task10and20 (int x1, int x2) {

            return ((x1 + x2)<= 20 && (x1 + x2) >= 10);
        }

//// 5
        public static String isPositiveOrNegative (int w){
           String pos;
            if (w < 0){
                return "Число отрицательное";
            }

            else
                return "Число положительное";
        }


//// 6
        public static boolean isNegative(int x) {

            boolean m = (x < 0);

            if (m) {
                    printSomething(m);
                return true;
            }
            else
                return false;
                //return (x<0);
            }



        public static void printSomething(float flt) {
            System.out.println(flt);
        }
        public static void printSomething(String name){
            System.out.println(name);
        }
//        public static void printSomething(int value){
//            System.out.println(value);
//    }
        public static void printSomething(boolean q){
            System.out.println(q);
        }

    }
