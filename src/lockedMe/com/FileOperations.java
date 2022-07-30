package lockedMe.com;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

public class FileOperations {

public void intro() {
		System.out.println("\n          WELCOME            \n\n");
		System.out.println("   Developer Name  :  Kona Himaja  \n ");
		System.out.println("   Application Name :LockedMe.com            \n\n  ");
	}
public void exit() {
		
		
		System.out.println("Thank You for Visiting! \n");
		System.out.println("See You Again Soon \n\n");
		
		
	}
public void Menu() {
	int choice=0;
	char option;
	Scanner sc=new Scanner(System.in);
	do {

	System.out.println("    MAIN MENU              ");
	System.out.println("\n");
	System.out.println("Select any one option");
    System.out.println("1) List  all the files in Ascending Order");
    System.out.println("2) More Options ");
    System.out.println("3) Exit from the application ");
    System.out.println("Enter your choice : ");
   
    try {
		choice = Integer.parseInt(sc.next());
	} catch (NumberFormatException e) {
		System.out.println("\nInvalid Input.Please try again...\n");
		Menu(); 
	}
	switch(choice) {
	
	case 1:
		File dir=new File(Main.path);
        String[] list = dir.list();
        System.out.println("The following files are in "+ dir);
        Arrays.sort(list);
        for (String str:list) {
            System.out.println(str);
			
        }
			break;
			
	case 2: 
			
			MoreOptions();
			break;
			
	case 3: 
			System.out.println("\nAre you sure you want to exit ? ");
			System.out.println("Enter ' Y' or 'y' to exit  ");
			System.out.println("Enter 'N' or 'n' not to exit");
		    option=sc.next().charAt(0);
			if((option=='Y')||(option=='y')) {
				exit();
                System.exit(0);
			}else if((option== 'N')||(option=='n')) {
				System.out.println("\n");
				Menu();
			}else {
				System.out.println("Invalid Input.Please try again......\n");
				Menu();
			}
			break;
			
			default:
			
			System.out.println("Invalid Input.Please try again....\n");
			Menu();
			
		    
	    }
	
	}while(true);
}

    
    


public void MoreOptions() {
	String fileName;
	
	int choice=0;
	Scanner sc=new Scanner(System.in);
	do {
	System.out.println("\n");
	System.out.println("       MORE OPTIONS              ");
	System.out.println("\n\n");
	System.out.println("Select any one option  ");
    System.out.println("1) Add a file    ");
    System.out.println("2) Delete a file   ");
    System.out.println("3) Search a file   ");
    System.out.println("4) Go Back to the main");
    System.out.println("\n");
    System.out.println("Enter your choice : ");
    try {
		choice = Integer.parseInt(sc.next());
	} catch (NumberFormatException e) {
		System.out.println("\nInvalid Input.Please try again...");
		MoreOptions(); 
	}
    switch(choice) {
	case 1: 
			System.out.println("\n Add a file");
			System.out.println("Enter a file name : ");
			fileName=sc.next();
			try {	
			if (fileName == null || fileName.isEmpty())
				throw new NullPointerException("File name can't be empty or null");
			
			File f1 = new File(Main.path+File.separator+fileName);
			
			if (f1.createNewFile()) {
				
				System.out.println("\nFile Successfully Created: "+f1.getAbsolutePath());
				
			}else  {
				
				System.out.println("\nFile already exists.Please try again...." );
				
			}
			}catch(Exception e) {
				System.out.println("Error occurred.Please try again...");
			}
			
			
			break;
			
	case 2: 
			System.out.println(" Deleting a file");
			System.out.println("Enter a file name to delete : ");
			fileName = sc.next();
			
		try {
			if (fileName == null || fileName.isEmpty())
				throw new NullPointerException("File name can't be empty or null");
			
			File file1 = new File(Main.path+File.separator+fileName);
			
		
			
			if (file1.delete()) {
				
				System.out.println("\nFile deleted successfully");
				
			}else {
				
				System.out.println("\nFile not found.Please try again..." );
				
			}
				
			}catch(Exception e) {
				System.out.println("Error occurred.Please try again...");
			}
			
			break;
			
	case 3: 
			System.out.println("Searching a File...");
			System.out.println("Please enter a file name to Search : ");
			fileName = sc.next();
			
			try {
				if (fileName == null || fileName.isEmpty())
					throw new NullPointerException("File name can't be empty or null");
				
				File d = new File(Main.path);
				
				
				
				String [] fileList = d.list();
				boolean flag = false;
				
				Pattern p = Pattern.compile(fileName);
				
				
					for(String s:fileList) {
						Matcher mt = p.matcher(s);
						if(mt.matches()) {
							System.out.println("File found at " + d.getAbsolutePath());
							flag = true;
							break;
					}
				}
				
				if(flag == false)
					System.out.println("File not found.Please try again.....");
			}
			catch(Exception e) {
				System.out.println("Error occurred.Please try again...");
			}
			
			break;
	case 4: Menu();
			break;
			
	default:
		System.out.println("Invalid Input.Please try again..");
		MoreOptions();
		
       }
	
  }while(true);

  

}

}
