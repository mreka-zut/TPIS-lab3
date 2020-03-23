package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //zad1
        //Set<String> zbiorDni = new HashSet<>();
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        System.out.println(zbiorDni);
        for(String dzien : zbiorDni) {
            System.out.println(dzien);
        }
        /*
        1. Czym się różni HashSet od TreeSet?
        HashSet implementuje zbiór przy użyciu tablicy hashowej a TreeSet przy użyciu drzewa, przez co różne
         operacje na tych kontenerach zajmują rózne długości czasu. Elementy w TreeSet ułożone
        są w tym przypadku alfabetycznie, w HashSet bez zadnego widocznego porządku.
        Po zajrzeniu do internetu można dodatkowo dowiedzieć się że:
        -TreeSet przechowuje dane w pewnym porządku, HashSet nie (tak jak wyszlo w laboratorium);
        -HashSet dopuszcza obiekty null, a TreeSet nie;
        -TreeSet wspiera operacje floor(), ceiling() i higher(), HashSet nie;
        -do przyrównywania obiektów ze sobą HashSet używa equals(), a TreeSet compareTo();
        2. Której klasy użyć w jakiej sytuacji?
        Najlepiej użyć HashSet - operacje dostępu oraz dodawania są szybsze, a tylko te operacje przeprowadzamy.
        3. Czy były wymagane jakiekolwiek zmiany w kodzie poza miejscem tworzenia obiektu (new HashSet<>() / new TreeSet<>())?
        Nie były wymagane żadne zmiany w kodzie.
         */
        //zad2
        List<Teacher> sampleTeachers=new ArrayList<>();
        sampleTeachers.add(new Teacher("M","Fedorov","Mail","programowanie obiektowe"));
        sampleTeachers.add(new Teacher("Imie","Nazwisko","Mail","wf"));
        sampleTeachers.add(new Teacher("Imie","Nazwisko","Mail","elektronika"));
        sampleTeachers.add(new Teacher("Imie","Nazwisko","Mail","strony"));
        sampleTeachers.add(new Teacher("Imie","Nazwisko","Mail","programowanie"));
        Map<String,Teacher> whoTeachWhat=new HashMap<>();   //mapowanie po imieniu nauczyciela czy obiekcie?
        for(Teacher teacherTemp : sampleTeachers)
        {
            whoTeachWhat.put(teacherTemp.getCourseName(),teacherTemp);
        }
        for(String courseName : whoTeachWhat.keySet()) {    //iteruje po mapie
            if(courseName=="programowanie obiektowe")   //sprawdzam czy klucz rowna sie zadanej wartosci
            {
                System.out.println(whoTeachWhat.get(courseName)); //przeladowanie z person
            }
        }
        Map<Integer, List<Student>> groups = new HashMap<>();
        int noGroups=5;
        for(int i=0;i<noGroups;i++) //tworze mape
        {
            List<Student> tempGroup = new ArrayList<>();
            String groupID=Integer.toString(30+i);
            //Dodaje groupID by pokazac pozniej w wyswietlaniu czy wlasciwa grupa sie wyswietla(kazdy student jest unikalny)
            tempGroup.add(new Student("Jan"+groupID, "Kowalski","jk.gmail.com",groupID));
            tempGroup.add(new Student("Jan", "Nowak"+groupID,"jn.gmail.com",groupID));
            groups.put(Integer.valueOf(groupID), tempGroup);
        }
        for(Integer groupID : groups.keySet()) {    //iteruje po mapie
            if(groupID==32)   //sprawdzam czy klucz rowna sie zadanej wartosci
            {
                List<Student> tempGroup=groups.get(groupID);
                for(Student student : tempGroup)
                {
                    System.out.println(student.getFirstName()+" "+student.getLastName());
                }
            }
        }
        //zad3
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {

            String lineFromFile = in.readLine();
            List <Product> products = new ArrayList<>();    //lista produktow
            while(lineFromFile!=null) {
                String[] fields = lineFromFile.split(";");
                products.add(new Product(Integer.valueOf(fields[0]),fields[1],Double.valueOf(fields[3]),fields[2]));
                lineFromFile = in.readLine();
            }
            Map<Integer, Product> productsByID = new HashMap<>();
            Set<String> productsCat=new HashSet<>();    //zeby wszystkie kategorie byly unikalne
            for(Product product : products)
            {
                productsByID.put(product.getId(),product);
                productsCat.add(product.getCategory());
            }
            Map<String, List<Product>> productsMapByCat = new HashMap<>();
            for(String category : productsCat)
            {
                List<Product> productsOneCat = new ArrayList<>();
                for(Product product : products)
                {

                    if(product.getCategory().compareTo(category)==0) //jesli uzywam przyrownania stringow ("==") dodaje tylko pierwszy dodany w secie
                    {
                        productsOneCat.add(product);
                    }
                }
                productsMapByCat.put(category,productsOneCat);
            }
            for(String category : productsMapByCat.keySet())
            {
                List<Product> productCatList=productsMapByCat.get(category);
                String displayProductsStream="";
                System.out.println("Kategoria: "+category);
                for(Product product : productCatList)
                {
                    displayProductsStream=displayProductsStream+product.getName()+", ";
                }
                displayProductsStream=displayProductsStream.substring(0,displayProductsStream.length()-2);
                System.out.println(displayProductsStream+";");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }


    }

