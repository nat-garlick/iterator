package edu.io;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text =""; 
        if(args.length==0){
            System.out.println("itx <tryb> [<nazwa_pliku>]");
            return;
        }
        else if(args.length==1){
            if(!args[0].equals("c") && !args[0].equals("w")){
                System.out.println("Podano niepoprawny tryb. \nDozwolone wartosci to: \nc-czytanie po znakach \nw-czytanie po slowach");
                return;
            }
            Scanner sc = new Scanner(System.in);
            text=sc.nextLine();
            sc.close();

        }else if(args.length==2){
            if(!args[0].equals("c") && !args[0].equals("w")){
                System.out.println("Podano niepoprawny tryb. \nDozwolone wartosci to: \nc-czytanie po znakach \nw-czytanie po slowach");
                return;
            }
            try {
                text = new String(Files.readAllBytes(Paths.get(args[1])));
            }catch(FileNotFoundException e){
                System.out.println("Nie znaleziono pliku");
                return;
            }
            catch (IOException e) {
                System.out.println("Blad wejscia/wyjscia");
                return;
            }
        }else if(args.length>2){
            System.out.println("Podano za duzo argumentow");
            return;
        }
        var ts= new TextSource(text);
        if(args[0].equals("c")){
            //var iterator=ts.iterator();
            for(var c: ts){
                System.out.println(c);
            }
        }
        if(args[0].equals("w")){
            var iterator=ts.wordIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}