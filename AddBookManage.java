package com.AddressBookSystemLambda;

import java.util.*;

public class AddressBookManager {
    public ArrayList<AddressBookBluePrint> detailedEntries = new ArrayList<>();
    public Map<String, ArrayList<AddressBookBluePrint>> book = new HashMap<>();
    public Map<String, ArrayList<AddressBookBluePrint>> multiBook = new HashMap<>();
    public Map<String, ArrayList<AddressBookBluePrint>> cityList = new HashMap<>();
    public Map<String, ArrayList<AddressBookBluePrint>> stateList = new HashMap<>();

    Scanner sc = new Scanner(System.in);


    public void callAddressBookBluePrint(){

        //Enter the Book name before detailed Entries
        System.out.println("Enter Address Book Name");
        String BookName = sc.next();

        //Enter the detailed Entries
        System.out.println("Enter you first name");
        String FirstName = sc.next();
        System.out.println("Enter you last name");
        String LastName = sc.next();
        sc.nextLine();
        System.out.println("Enter you Address name");
        String Address = sc.nextLine();
        System.out.println("Enter you zip ");
        int Zip = sc.nextInt();
        System.out.println("Enter you city name");
        String City = sc.next();
        System.out.println("Enter you state name");
        String State = sc.next();
        sc.nextLine();
        System.out.println("Enter you phone number");
        long PhoneNumber = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter you email name");
        String Email = sc.nextLine();

        //Checking name of the person to avoid duplicate Entries
        if (check(FirstName)){
            callAddressBookTemp(BookName, FirstName, LastName, Address, City, Zip, State, PhoneNumber, Email);
            System.out.println("AddressBookBluePrint{" + "firstName='" + FirstName + '\'' + ", lastName='" + LastName + '\'' + ", address='" + Address + '\'' + ", city='" + City + '\'' + ", state='" + State + '\'' + ", eMail='" + Email + '\'' + ", zip=" + Zip + ", mobileNum=" + PhoneNumber + '}');
        }
        else
            System.out.println("The "+FirstName+" already exist in contacts please use different name");
    }

    //Checking duplicate Entries
    private boolean check(String firstName){
        Boolean check = true;
        if (detailedEntries.stream().anyMatch(person -> person.getFirstName().equals(firstName))){
            check = false;
            return check;
        }else {
            return check;
        }
    }

    private void callAddressBookTemp(String bookName,
                                     String firstName, String lastName,
                                     String address, String city, int zip,
                                     String state, long phoneNumber, String email) {
        AddressBookBluePrint adder = new AddressBookBluePrint(bookName, firstName, lastName, address, city, zip, state, phoneNumber, email);
        //adder.toString();
        detailedEntries.add(adder);
        book.put(firstName, detailedEntries);
        multiBook.put(bookName, detailedEntries);
        cityList.put(city, detailedEntries);
        stateList.put(state, detailedEntries);
    }

    public void editContact(){
        System.out.println("enter your book name");
        String bookName = sc.next();
        ArrayList<AddressBookBluePrint> tempContact = multiBook.get(bookName);
        System.out.println("enter your name");
        String name = sc.next();
        for (AddressBookBluePrint eachDetails : tempContact){
            if (eachDetails.getFirstName().equals(name)){
                boolean conditon = true;
                while (conditon){
                    System.out.println("enter number  1:first_name 2:last_name 3:address 4:City 5:zip 6:state 7:phone_number 8:email 0:quit");
                    int opt = sc.nextInt();
                    switch (opt){
                        case 1:
                            System.out.println("Enter you first name");
                            String firstname = sc.next();
                            eachDetails.setFirstName(firstname);
                            System.out.println(book);
                            break;
                        case 2:
                            System.out.println("Enter you last name");
                            String lastname = sc.next();
                            eachDetails.setLastName(lastname);
                            System.out.println(book);
                            break;
                        case 3:
                            System.out.println("Enter you address ");
                            String addressname = sc.next();
                            eachDetails.setAddress(addressname);
                            System.out.println(book);
                            break;
                        case 4:
                            System.out.println("Enter you City name");
                            String cityname = sc.next();
                            eachDetails.setCity(cityname);
                            System.out.println(book);
                            break;
                        case 5:
                            System.out.println("Enter you Zip name");
                            int zipname = sc.nextInt();
                            eachDetails.setZip(zipname);
                            System.out.println(book);
                            break;
                        case 6:
                            System.out.println("Enter you State name");
                            String statename = sc.next();
                            eachDetails.setState(statename);
                            System.out.println(book);
                            break;
                        case 7:
                            System.out.println("Enter you Phone number");
                            long phonenumber = sc.nextLong();
                            sc.nextLine();
                            eachDetails.setMobileNum(phonenumber);
                            System.out.println(book);
                            break;
                        case 8:
                            System.out.println("Enter you email");
                            String emailname = sc.next();
                            eachDetails.seteMail(emailname);
                            System.out.println(book);
                            break;
                        case 0:
                            conditon = false;
                            break;
                        default:
                            System.out.println("invalid input");
                    }
                }
            }
        }
    }

    public boolean takeOption(){
        System.out.println("enter 1:add_contact 2:edit_contact or 0 to quit");
        int opt = sc.nextInt();
        boolean conditon = true;
        switch (opt){
            case 1:
                callAddressBookBluePrint();
                break;
            case 2:
                editContact();
                break;
            case 0:
                conditon = false;
                break;
            default:
                System.out.println("invalid input");
        }
        return conditon;
    }


}