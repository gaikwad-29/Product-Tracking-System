package productTrackingProject;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		AnnotationConfigApplicationContext con=new AnnotationConfigApplicationContext(ProductConfig.class);
	OperationDao operation=	con.getBean("operationDao",OperationDao.class);
	
	while(true)
	{
		System.out.println("\t\t======== Welcome ========\n\tProduct Tracing Project");
		System.out.println("========================================");
		System.out.println("Enter 1 for Add new Product");
		System.out.println("Enter 2 for check Product count");
		System.out.println("Enter 3 for get Product price using  product Name");
		System.out.println("Enter 4 for get  Product details using id");
		System.out.println("Enter 5 for get all products deatils.");
		System.out.println("Enter 6 for update Product using id");
		System.out.println("Enter 7 for remove Product using product Id");
		System.out.println("Enter 8 for Exit");
		System.out.println("========================================");
	System.out.print("Enter your choice: ");
	int choice=sc.nextInt();
	
	switch(choice)
	{
	case 1:{
		System.out.println("Enter ProductId: ");
		int id=sc.nextInt();
		System.out.println("Enter product Name: ");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Shipping address: ");
		String address=sc.nextLine();
		System.out.println("Enter product  price");
		double price=sc.nextDouble();
		System.out.println("Enter product quantity:");
		int qty=sc.nextInt();
		System.out.println("Enter Product Placed Date");
		sc.nextLine();
		String date=sc.nextLine();
		
		ProductDelivery delivery=new ProductDelivery();
		delivery.setProductId(id);
		delivery.setProductName(name);
		delivery.setProductShippingAddress(address);
	     delivery.setProductPrice(price);
	     delivery.setProductQuantity(qty);
	     delivery.setProductPlaceData(date);
		int count=operation.insetProduct(delivery);
		if(count>=1)
		{
			System.out.println("Product inserted successfully!..");
		}
		else
		{
			System.out.println("Something went wrong..");
		}
	break;
	}
	
	case 2:
	System.out.println("Product Count: "+	operation.getProductCount());
		break;
	case 3: 
		sc.nextLine();
		System.out.println("Enter product name to get price: ");
		String name=sc.nextLine();
		System.out.println("Product price using Name: "+operation.getProductPrice(name));
		break;
		
	case 4:
		System.out.println("Enter id to get product details: ");
		int pid=sc.nextInt();
		System.out.println("Product dtails: \n"+operation.getProductDetailsById(pid));
		break;
	case 5: 
		System.out.println(" get  all product Details");
		operation.getAllProduct().forEach(System.out::println);
		break;
		
	case 6:
	{
		sc.nextLine();
		System.out.println("Enter product name to update product shipping address and placed date: ");
		String pName=sc.nextLine();
		System.out.println("Enter new Shipping address and placed date");
		String shipping=sc.nextLine();
		String date=sc.nextLine();
		 
	int count=	operation.updateProduct(shipping, date, pName);
	
	if(count>=1)
	{
		System.out.println("Project updated successfully!..");
	}
	else {
		System.out.println("something went wrong");
	}
		break;
	}
	case 7:{
		System.out.println("Delete the product Using id:");
		System.out.println("Enter Id:: ");
		int dId=sc.nextInt();
	int count=	operation.deleteProduct(dId);
	if(count>=1)
	{
		System.out.println("Project deleted successfully!..");
	}
	else {
		System.out.println("something went wrong");
	}
		break;
	}
	case 8:
		System.out.println("Thanks for visiting !..");
          System.exit(choice);	
          break;
          
        default: System.out.println("Invalid choice");
	}
	System.out.println();
   }
	
 }
	

}
