/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos_2.view;

/**
 * show and log exception.
 */
public class ExceptionHandler  {
    /**
     * Show the exception message to users.
     * @param excp exception
     */
    public void showExceptionMessage (Exception excp){
        System.out.println("\n"+excp.getMessage());
    /**
     * log the exception, and show it on the screen.
     * @param excp exception
     */
    }
    public void logException(Exception excp){
        System.out.println("------------Exception log------------");
        System.out.println("\n"+"The exception have been thrown:"+excp.getMessage()+"\n");
        System.out.println("-------------------------------------");
        excp.printStackTrace(System.out);
    }
    
}
