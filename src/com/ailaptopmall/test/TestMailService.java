package com.ailaptopmall.test;
import java.util.Scanner;

import com.ailaptopmall.service.MailService;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class TestMailService {

    public static void main(String[] args) {
//    	String email= null;
//    	System.out.println("請輸入有效的email:");
//    	try(Scanner scanner = new Scanner(System.in);){
//    		email=scanner.next();
//    	}
    	
        //MailService.sendHelloMailWithLogo("clou40308@gmail.com");
    	MailService.sendCheckOutSuccess("clou40308@gmail.com", 3);
    }
}
