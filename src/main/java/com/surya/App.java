package com.surya;
import java.io.FileReader;
import com.opencsv.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App 
{
    Scanner sc = new Scanner (System.in);
    //Hibernate Setup
    static SessionFactory factory = new Configuration()
                            .addAnnotatedClass(com.surya.data_class.class)
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();
    static Session session = factory.openSession();
    public static void main( String[] args )
    {
        App app = new App();
        while (true){
        int sw ;
        System.out.println("Choose the operation \n 1.Load the DataBase\n 2.Get data from data base \n 3.Update\n 4.Remove any person \n 5.Add Person \n 6.Close application ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter selected number ");
        sw = sc.nextInt();
        sc.nextLine();
        switch (sw) {
        case 1 :
        System.out.println("Hibernate Connection Successfull......");
        //Creating the Object for class Data 
        data_class [] data = new data_class[750];
        int count = 1;
        System.out.println("Object created successfully........");
        //Reading Data From CSV File
        String file = "C:\\Users\\surya\\Desktop\\MavenProject\\maven_demo\\src\\main\\java\\com\\surya\\ece_database_csv.csv";
        String line ="";
        try {
        CSVReader reader = new CSVReader(new FileReader(file));
        Transaction transaction = session.beginTransaction();
        System.out.println("CSV File reader initiated.......");
        reader.readNext();
        String[] row;
        while ((row=reader.readNext())!= null)
        {
            if (row.length < 11) {
            System.out.println("Skipping incomplete row: " + line);
            continue;
            }
            data[count] = new data_class();
            data[count].setReg_no(Integer.parseInt(row[0]));
            data[count].setName(row[1]);
            data[count].setEmail(row[2]);
            data[count].setDd(row[3].isEmpty()? 0: Integer.parseInt(row[3]));
            data[count].setMm(row[4].isEmpty()? 0: Integer.parseInt(row[4]));
            data[count].setYyyy(row[5].isEmpty()? 0: Integer.parseInt(row[5]));
            data[count].setGender(row[6]);
            data[count].setCommunity(row[7]);
            data[count].setAddress(row[8]);
            data[count].setMobile_number(row[9]);
            data[count].setAadhar(row[10]);
           // System.out.println("Data added "+data[count].toString());
            session.persist(data[count]);
            count +=1;
        }
        transaction.commit();
        reader.close();
        System.out.println("Data saved successfully "+count+" records");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        break;

        case 2:
            System.out.print("Enter the Registation Number of candidate: ");
            int n = sc.nextInt();
            System.out.println();
            app.find(n);
        break;

        case 3:
          // System.out.print("\n***********************************************************************\n");
           System.out.print("Enter the Registation Number of candidate: ");
           n = sc.nextInt();
           app.find(n);
           System.out.print("Enter the column need to change: ");
           String a = sc.next();
           sc.nextLine();
           data_class data1 = session.find(data_class.class,n);
           if (a.equalsIgnoreCase("Dd") || a.equalsIgnoreCase("Mm") || a.equalsIgnoreCase("Yyyy")) {
                System.out.print("Enter the new integer data: ");
                int m = sc.nextInt();
                sc.nextLine(); 
                switch (a.toLowerCase()) {
                    case "dd":
                        data1.setDd(m);
                        break;
                    case "mm":
                        data1.setMm(m);
                        break;
                    case "yyyy":
                        data1.setYyyy(m);
                        break;
                }
            } else {
                System.out.print("Enter the new data: ");
                String newData = sc.nextLine();
                
                switch (a.toLowerCase()) {
                    case "name":
                        data1.setName(newData);
                        break;
                    case "email":
                        data1.setEmail(newData);
                        break;
                    case "gender":
                        data1.setGender(newData);
                        break;
                    case "community":
                        data1.setCommunity(newData);
                        break;
                    case "address":
                        data1.setAddress(newData);
                        break;
                    case "mobile_number":
                        data1.setMobile_number(newData);
                        break;
                    case "aadhar":
                        data1.setAadhar(newData);
                        break;
                    default:
                        System.out.println("Invalid column name.");
                        break;
                }
            }
            Transaction transaction = session.beginTransaction();
            session.merge(data1);
            transaction.commit();

            System.out.println("Data updated successfully!");


            app.find(n);

            System.out.println("Updated data shown above");
            System.out.println();

            //System.out.print("\n***********************************************************************");

        break;

        case 4:
           System.out.print("Enter the person register number: ");
           int reg = sc.nextInt();
           app.find(reg); 
           data_class data2 = session.find(data_class.class, reg);
           if(data2 != null){
            Transaction transaction2 = session.beginTransaction();
            session.remove(data2);
            transaction2.commit();
            System.out.println("The above person removed\n");
           }
           else {
            System.out.println("Data not found or Check register number");
           }
        break;

        case 5:
           data_class person = new data_class();
           System.out.print("Enter the Register number: ");
           int reg_no = sc.nextInt();
           person.setReg_no(reg_no);
           data_class dup = session.find(data_class.class, reg_no);
           if(dup != null){
            System.out.println("The peson exits");
            break;
           }
           sc.nextLine();
           System.out.print("Enter the Name: ");
           person.setName(sc.nextLine());
           System.out.print("Enter email: ");
           person.setEmail(sc.nextLine());
           System.out.print("Enter the Date: ");
           person.setDd(sc.nextInt());
           System.out.print("Enter the Month: ");
           person.setMm(sc.nextInt());
           System.out.print("Enter the Year: ");
           person.setYyyy(sc.nextInt());
           sc.nextLine();
           System.out.print("Enter the Address: ");
           person.setAddress(sc.nextLine());
           System.out.print("Enter the Mobile number: ");
           person.setMobile_number(sc.nextLine());
           System.out.print("Enter the Community: ");
           person.setCommunity(sc.nextLine());
           System.out.print("Enter the Gender: ");
           person.setGender(sc.nextLine());
           System.out.print("Enter the Aadhar: ");
           person.setAadhar(sc.nextLine());

           Transaction transaction2 = session.beginTransaction();
           session.persist(person);
           transaction2.commit();
           
           
        break;
         case 6:
           System.exit(0);
        break;
    }}} 
    void find(int n){
        System.out.print("\n***********************************************************************\n");
            data_class data1 = session.find(data_class.class, n);
          //  System.out.println("\tRegistration Number: " + data1.getReg_no());
            System.out.println("\tName: " + data1.getName());
            System.out.println("\tEmail: " + data1.getEmail());
            System.out.println("\tDate of Birth: " + data1.getDd() + "/" + data1.getMm() + "/" + data1.getYyyy());
            System.out.println("\tGender: " + data1.getGender());
            System.out.println("\tCommunity: " + data1.getCommunity());
            System.out.println("\tAddress: " + data1.getAddress());
            System.out.println("\tMobile Number: " + data1.getMobile_number());
            System.out.println("\tAadhar: " + data1.getAadhar());
            System.out.print("***********************************************************************\n");
           
    }
}