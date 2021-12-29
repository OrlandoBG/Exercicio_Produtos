package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for(int i=1; i<=numberProducts; i++) {
			System.out.println("Product #"+ i + " data:");
			System.out.print("Commom, used or imported (c/u/i)? ");
			char kindProduct = sc.next().charAt(0);
			
			if(kindProduct == 'c') {
				System.out.print("name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("price: ");
				double price = sc.nextDouble();
				list.add(new Product(name,price));	
			}else if(kindProduct == 'i') {
				System.out.print("name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("price: ");
				double price = sc.nextDouble();
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name,price,customFee));
			}else {
				System.out.print("name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (dd/MM/yyyy): ");
				sc.nextLine();
				String date = sc.nextLine();
				list.add(new UsedProduct(name,price,sdf.parse(date)));
			
			}	
		}
		
		System.out.println();
		
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}

}
