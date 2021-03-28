package javaequationsolver;
import java.util.Scanner;
  
public class JavaEquationSolver {  
      
        public static void main(String[] args) {  
        System.out.println("Which kind of equation will you enter?(linear or quadratic) ");
        Scanner s = new Scanner(System.in); 
        String equ_kind=s.next();
        
        String choose,choose2;
        int n,variable;
        double y=0,x = 0,a,b,c,D,result;
        double root1,root2;
            OUTER:
            while (true) {
                if ("Linear".equalsIgnoreCase(equ_kind)) {
                    System.out.println("Linear equation form: ax+by=c");
                    System.out.println("Enter values of a,b and c");
                    a = s.nextDouble();
                    b = s.nextDouble();
                    c = s.nextDouble();
                    System.out.println("If you want to find x, press 'yes'.Otherwise press 'no'.");
                    choose = s.next();
                    if(choose.equalsIgnoreCase("yes")){
                        System.out.println("Enter value of y: ");
                        y=s.nextDouble();
                        x=(c-b*y)/a;
                        System.out.println("Value of x: "+x);
                        break;
                    }
                    else{
                        System.out.println("Enter value of x: ");
                        x=s.nextDouble();
                        y=(c-a*x)/b;
                        System.out.println("Value of y: "+y);
                        break;
                    }   } else if (equ_kind.equalsIgnoreCase("Quadratic")) {
                        System.out.println("Do you want quadratic equation with one variable or two variable?(enter 1(only x or y) or 2 (both x and y)");
                        variable =s.nextInt();
                    switch (variable) {
                        case 1:
                            System.out.println("Quadratic equation form: ax^2+bx+c=0");
                            System.out.println("Enter values of a,b and c");
                            a = s.nextDouble();
                            b = s.nextDouble();
                            c = s.nextDouble();
                            D=(b*b-4*a*c);
                            if (D>0) {
                                root1=(-b+Math.sqrt(D))/2*a;
                                root2=(-b-Math.sqrt(D))/2*a;
                                System.out.println("This equation has two real roots.");
                                System.out.println("Roots of quadratic equation: \n"+"First root: "+root1+"\nSecond root "+root2);
                                break OUTER;
                            } else if (D==0) {
                                root1=(-b)/2*a;
                                System.out.println("This equation has one root.");
                                System.out.println("Root of quadratic equation: \n"+"root: \n"+root1);
                                break OUTER;
                            } else {
                                double realPart = -b / (2 *a);
                                double imaginaryPart = Math.sqrt(-D) / (2 * a);
                                System.out.println("This equation has two  imaginary (non-real) roots.");
                                System.out.format("First root = %.2f+%.5fi\n" + "Second root = %.2f-%.5fi\n", realPart, imaginaryPart, realPart, imaginaryPart);
                                break OUTER;
                            }
                        case 2:
                            System.out.println("Quadratic equation form: ax^2+by+c=0(1) or ay^2+bx+c=0(2)");
                            System.out.println("Select the number of quadratic equation:");
                            n= s.nextInt();
                            if (n==1) {
                                System.out.println("Enter values of a,b and c");//ax^2+by+c=0
                                a = s.nextDouble();
                                b = s.nextDouble();
                                c = s.nextDouble();
                                System.out.println("If you want to find x, press 'yes'.Otherwise press 'no'.");
                                choose = s.next();
                                if (choose.equalsIgnoreCase("yes")) {
                                    System.out.println("Enter value of y: ");
                                    y=s.nextDouble();
                                    result=(-c-b*y)/a;
                                    if (result>=0) {
                                        x=Math.sqrt(result);
                                        System.out.println("Value of x: "+x);
                                        break OUTER;
                                    } else {
                                        x=Math.sqrt(-result);
                                        System.out.println("One of value of x: +"+x+"i");
                                        System.out.println("Another value of x: -"+x+"i");
                                        break OUTER;
                                    }
                                } else if (choose.equalsIgnoreCase("no")) {
                                    System.out.println("Enter value of x: ");
                                    x=s.nextDouble();
                                    y=(-c-a*x*x)/b;
                                    System.out.println("Value of y: "+y);
                                    break OUTER;
                                }
                            } else if (n==2) {
                                System.out.println("Enter values of a,b and c");//ay^2+bx+c=0
                                a = s.nextDouble();
                                b = s.nextDouble();
                                c = s.nextDouble();
                                System.out.println("If you want to find x, press 'yes'.Otherwise press 'no'.");
                                choose = s.next();
                                if (choose.equalsIgnoreCase("yes")) {
                                    System.out.println("Enter value of y: ");
                                    y=s.nextDouble();
                                    x=(-c-a*y*y)/b;
                                    System.out.println("Value of x: "+x);
                                    break OUTER;
                                } else if (choose.equalsIgnoreCase("no")) {
                                    System.out.println("Enter value of x: ");
                                    x=s.nextDouble();
                                    result=(-c-b*x)/a;
                                    if (result>=0) {
                                        y=Math.sqrt(result);
                                        System.out.println("Value of y: "+y);
                                        break OUTER;
                                    } else {
                                        y=Math.sqrt(-result);
                                        System.out.println("One of value of y: +"+y+"i");
                                        System.out.println("Another value of y: -"+y+"i");
                                        break OUTER;
                                    }
                                }
                            } else {
                                System.out.println("This number does not exist.");
                            }
                            break;
                        default:
                            System.out.println("This number does not exist.");
                            break;
                    }
                } else {  
                        System.out.println("This app does not support this equation type.");
                        break;
                }
            }
        }
        }
