import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by slafa on 09.05.2017.
 */
public class Txt {

    ArrayList<ArrayList> skatteListe = new ArrayList<>();
    ArrayList<String> arrNavn = new ArrayList<>();
    ArrayList<String> arrInntekt = new ArrayList<>();
    ArrayList<String> arrSkatteklasse = new ArrayList<>();




    public static void main(String[] args) {
        Txt t1 = new Txt();
    }

    private Txt(){
        skatteListe.add(arrNavn);
        skatteListe.add(arrInntekt);
        skatteListe.add(arrSkatteklasse);

        printFile("Skatt.txt");
        printFile("Skatt2.txt");
        printFile("Skatt3.txt");

        System.out.println("hest");
        sorter("Skatt2.txt", "skatt3.txt");

        System.out.println("hest");
        System.out.println(skatteListe);

    }


    public void printFile(String file){
        Scanner sc = null;
        try{
            int skatteKlasse1 = 0;
            int skatteKlasse2 = 0;
            int samletIntekt = 0;
            int antalLinjer = 0;

            sc = new Scanner(new File(file));

            System.out.printf("%-15s","Navn");
            System.out.printf("%-15s","Inntekt");
            System.out.printf("%-15s","Skatteklasse");
            System.out.println();

            while (sc.hasNext()){
                for(int i = 0; i < 3; i++) {
                    String data = sc.nextLine();
                    System.out.printf("%-15s", data);
                    if(i==1) samletIntekt += Integer.parseInt(data);
                    if(i==2 && Integer.parseInt(data) == 1){
                        skatteKlasse1++;
                    }else skatteKlasse2++;
                }
                System.out.println();
                antalLinjer++;
            }
            int gjennomsnittInt = samletIntekt/antalLinjer;
            System.out.printf("%n%-30s%d", "Antall i skatteklasse 1:", skatteKlasse1);
            System.out.printf("%n%-30s%d", "Antall i skatteklasse 2:", skatteKlasse2);
            System.out.printf("%n%-30s%d","Gjennomsnittsinntekt:", gjennomsnittInt);
            System.out.println("\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }

    public void sorter(String f1, String f2){
        Scanner sc = null;
        Scanner sc2 = null;
        try {
            sc = new Scanner(new File(f1));
            sc2 = new Scanner(new File(f2));
            addToArrayList(sc);
            addToArrayList(sc2);


        }catch (IOException ex){
            System.out.println("error: " + ex.getMessage());
        }finally {
            sc.close();
            sc2.close();
        }
    }
        private void addToArrayList(Scanner sc){
            while (sc.hasNext())
                for (int i = 0; i <3; i++){
                    skatteListe.get(0).add(sc.nextLine());
                    skatteListe.get(1).add(sc.nextLine());
                    skatteListe.get(2).add(sc.nextLine());
                }
    }
}


