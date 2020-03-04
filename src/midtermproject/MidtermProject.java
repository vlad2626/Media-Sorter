/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;


/**
 *
 * @author valmi
 */
public class MidtermProject {

    /**
     * @param args the command line arguments
     */
   static ArrayList <Media> items = new ArrayList();
    public static void main(String[] args) {
        // TODO code application logic here
        MidtermProject mp = new MidtermProject();
        mp.populateArrayList();
        mp.mainMenu();

        
    }
    
    public void populateArrayList()
    {
      boolean open = false;
      String aMedia;
     Scanner sc= null;
      try
       {
           File aFile = new File("catalog2-1.txt");
            sc = new Scanner(aFile);
            
           fillArrayList(sc);
           
           open = false;
         
       }
        catch(FileNotFoundException e)
               {
                   System.out.println("File not found");
                   open= true;
               }
      finally
      {
          
          sc.close();
      }
       
      
      
    }
    
    public void mainMenu()
    {
        Scanner keyboard = new Scanner(System.in);
        int userAnswer =-1;
        do{
            System.out.println("Main Menu");
            System.out.println("1. Search By Artist(Singer/Actor)");
            System.out.println("2. Serch by Media Title ");
            System.out.println("3. add Media to catalog ");
            System.out.println("4. quit");
            userAnswer = keyboard.nextInt();
            if(userAnswer <0 || userAnswer > 4)
            {
                System.out.println("Incorect Menu Option please select a valid Option");
                userAnswer = keyboard.nextInt();
            }
            if(userAnswer == 1)
            {
                searchArtist(keyboard);
            }
            else if(userAnswer == 2)
            {
                searchMedia(keyboard);
            }
            else if(userAnswer ==3)
            {
                addMedia(keyboard);
            }
            else if (userAnswer ==4)
            {
                System.out.println("Exiting program.");
            }
        }while(userAnswer != 4);
    }
    
    public static void fillArrayList(Scanner sc)
    {
        String aName="";
        String aArtist= ""; 
        String anAlbum="";
        String aMedia="";
        String aMovie="";
        ArrayList <String> sSong ;
        ArrayList <String> coStars ;
        String aYear=" ";
        String aSong = "";
        CDMedia a;
        DVDMedia b;
        
        String media;
        String [] parts;
        
        do{
          
            media= sc.nextLine();
          parts= media.split(" ");
          if(parts[0].equalsIgnoreCase("C"))
          {
              sSong = new ArrayList<String>(); 
             
              for(int i=0; i< parts.length; i++)// nested loop for the cd SOngs
              {
                  aMedia = parts[0];
                  aArtist = parts[1];
                  anAlbum = parts[2];
                  
                  if(i>3 && i< parts.length)
                  {
                      sSong.add(parts[i]);
                  }
                  
              }
            a = new CDMedia(anAlbum, aArtist, aMedia, sSong);
            items.add(a);
             
              
              
          }
          else
          {
               coStars = new ArrayList<String>();
              for(int i =0; i< parts.length; i++)
              {
                 
                  aMedia = parts[0];
                  aArtist = parts[1];
                  aMovie = parts[2];
                  aYear = (parts[3]);
                  if(i>3)
                  {
                      coStars.add(parts[i]);
                  }
              }
              b= new DVDMedia(aYear, aArtist,aMedia, coStars, aMovie);
              items.add(b);
          }
        
         
        }while(sc.hasNextLine());
       
        
        
        
       
    }
    
       

    
    public static void searchArtist(Scanner keyboard)
    {
        Collections.sort(items , new ComparatorByArtistName());
        System.out.println("Sorting by artist Name ");
        String x =" ";
        
       
        
        System.out.println("What is the name of the artist ?");
        keyboard.nextLine();
        x = keyboard.nextLine();
         String aName= x.replace(" ", "_");
         System.out.println(aName);
        
        
         ComparatorByArtistName c = new ComparatorByArtistName();
        int result = Collections.binarySearch(items, new Media(x, null),c);
       
        if(result < -1)
        {
            System.out.println("Element not present");
        }
        else
        {
            //System.out.println(items.get(result));
            print(result, aName);
        }
        System.out.println(result);

    }
    
    public static void print(int result,String aName)
    {
        ArrayList<Integer> index = new ArrayList<Integer>();
       // loop will check the 5 postions before and after the binary search
        for(int i=0; i<=5; i++)
        {
            if(items.get(result-i).getArtistName().equalsIgnoreCase(aName))
            {
                index.add(i);
                System.out.println(i);
            }
            if(items.get(result+i).getArtistName().equalsIgnoreCase(aName))
            {
                index.add(i);
                System.out.println(i);
            }
        }
       for(int j=0; j< index.size(); j++)
       {
           System.out.println(items.get(index.get(j)));
       }
    }
    
    public static void searchMedia(Scanner keyboard)
    {
        keyboard.nextLine();
        System.out.println("Sorting By album/movie Name");
        Collections.sort(items, new ComparatorByMediaName());
        
        System.out.println("What is the name of the album/Movie  name");
        String name = keyboard.nextLine();
        String replace = name.replace(" ","_");
        
        //System.out.println(replace);
        
        ComparatorByMediaName s = new ComparatorByMediaName();
        for(Media val : items)
        {
            System.out.println(val);
        }
        int result = Collections.binarySearch(items, new Media(null, replace), s);
      // System.out.println(items.get(0));
        if (result < -1 )
        {
            System.out.println("Sorry media not found");
        }
        else
        {
//            System.out.println(result);
        }
         System.out.println(result);
        
       
        
    }
    
    public static void addMedia(Scanner keyboard)
    {
        FileWriter fw = null;
        
        PrintWriter out = null;
        boolean open = false;
        try
        {
            fw = new FileWriter("catalog2-1.txt", true);
            out = new PrintWriter(fw);
            open = true;
            appendToFile(keyboard, fw, out);
            
            
        }
        catch(FileNotFoundException E)
        {
            System.out.println("Sorry the file was not found");
            open= false;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            open= false;
        }
        finally
        {
            if (open)
            {
                out.close();
            }
        }
        
    }
    
    public static void appendToFile(Scanner keyboard, FileWriter fw, PrintWriter out)
    {
        int userAnswer, num, aYear;
        String aMedia, aName, anAlbum,aMovie, aSong, yearR, cos;
        String  bName,bAlbum, cSong ,bMovie, bCos;
    
       // ArrayList<String> coStar = new ArrayList<String>();
        do{
        System.out.println("1.CD \n 2. DVD \n 3.Exit");
        userAnswer = keyboard.nextInt();
        keyboard.nextLine();
       
        if(userAnswer == 1)
        {
            aMedia = "C";
            System.out.println("CD req, artist name, album name, Songs");
            System.out.println(" ");
            System.out.println("Enter the artist's name");
            aName = keyboard.nextLine();
            System.out.println("Enter the Album Name");
            anAlbum = keyboard.nextLine();
            System.out.println("How many songs do you wish to add");
            num = keyboard.nextInt();
             // correction so file is in uniform format
            bName = aName.replace(" ", "_");
            bAlbum = anAlbum.replace(" ", "_");
            out.println(" ");
            out.print(aMedia + " " + bName + " " + bAlbum + " ");
            keyboard.nextLine();
            
            for(int i=0; i< num; i++)
            {
                System.out.println("Enter the name of song number: " + i +1);
                aSong = keyboard.nextLine();
                cSong = aSong.replace(" ","_");
                out.print(cSong + " ");
            }
            System.out.println("Songs by " + aName + " are added to the file");
           
           
            out.println(" ");
           
        }
        
        else if(userAnswer == 2)
        {
            
            aMedia ="D";
            System.out.println("Requirements for A DVD: Movie Name, Actor Name, Costars, year released");
            System.out.println("Enter the Actor Name");
            aName = keyboard.nextLine();
            System.out.println("Enter the name of the Movie");
            aMovie = keyboard.nextLine();
            System.out.println("Enter the year released");
            aYear = keyboard.nextInt();
            //yearR =String.valueOf(aYear);
            System.out.println("How many costars in the movie");
            num = keyboard.nextInt();
            keyboard.nextLine();
            bName = aName.replace(" ", "_");
            bMovie = bName.replace(" ", "_");
            out.println(" ");
            out.print(aMedia + " " + bName + " " + aYear + " ");
            for(int i=0; i< num; i++)
            {
                System.out.println("Enter the name of Costar : " + i +1);
                cos = keyboard.nextLine();
                bCos = cos.replace(" ", "_");
                out.print(bCos + " ");
            }
        }
        else if(userAnswer == 3)
        {
            System.out.println("Exiting ...");
            
        }
        else
        {
            System.out.println("Incorect menu Option selected");
        }
        
        
    }while(userAnswer<0 || userAnswer > 3); 
       
    
    }
}

