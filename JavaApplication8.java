/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 22cseb57
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner obj=new Scanner(System.in);
        int b,a;
        System.out.println("Enter the first num:");
        b=obj.nextInt();
        System.out.println("Enter the last num:");
        a=obj.nextInt();
        numberprint n=new numberprint();
        odd t1=new odd(b,a,n);
        even t2=new even(b,a,n);
        t1.start();
        t2.start();
    }
    
}
class numberprint
{
    boolean v=false;
    public synchronized void print1(int a) throws InterruptedException
    {
        while(v)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("e");
            }
        }
        try
        {
            Thread.sleep(1000);
            System.out.println(a);
        }
        catch(InterruptedException e)
        {
            
        }
        v=true;
        notify();
    }
     public synchronized void print2(int a)
    {
        while(!v)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("e");
            }
        }
        try
        {
            Thread.sleep(1000);
            System.out.println(a);
        }
        catch(InterruptedException e)
        {
            
        }
        v=false;
        notify();
    }
}

class odd extends Thread
{
    int b,a;
    numberprint n;
    odd(int b,int a,numberprint n)
    {
        this.n=n;
        this.b=b;
        this.a=a;
    }
    public void run()
    {
        for(int i=b;i<=a;i++)
        {
            if(i%2==1)
            {
                try {
                    //System.out.println("Odd Numbers");
                    n.print1(i);
                } 
                catch (InterruptedException ex)
                {
                    
                }
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
}

class even extends Thread
{
    int b,a;
    numberprint n;
    even(int b,int a,numberprint n)
    {
        this.n=n;
        this.b=b;
        this.a=a;
    }
    public void run()
    {
        for(int i=b;i<=a;i++)
        {
            if(i%2==0)
            {
               // System.out.println("Even Numbers");
                n.print2(i);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
}