
import java.util.*;
import java.io.FileReader;
import java.util.regex.Pattern;
/**
 * Simulation class runs the simulation of the coffee shop
 *
 * @author  Omar Drira
 * @version 04/04/2020
 */
public class Simulation
{
    PriorityQueue<Event> eventSet;
    ArrayDeque<Customer> customerQueue;
    ArrayList<Integer> waitTimes;
    Cashier[] cashierArray;
    float p1,p2,c;
    int t1,t2,s;
    Scanner sc,sc1;
    int openTime = 6*3600;
    int closeTime= 21*3600;
    int overflow=0;
    int currentTime;
    int n=0; //number of clients we went through (served or overflowed)
    float totalProfit=0;
    int max= 0;int sum =0; int average =0;
    /**
     * Constructor for objects of class Simulation, initializes all the variables and data structures
     * @param the number of cashiers
     */
    public Simulation(int s)
    {
        this.s=s;
        currentTime=openTime;
        eventSet = new PriorityQueue<Event>();
        customerQueue = new ArrayDeque<Customer>();
        cashierArray= new Cashier[s] ;
        for (int i=0;i<s;i++) cashierArray[i] = new Cashier();
        waitTimes = new ArrayList<Integer>();
        Scanner sc=null;
        readFile();
    }
    
    /**
     * readFile method reads the input file and generates a priorityqueue of arrival events
     */
    public void readFile(){
        try {
            sc = new Scanner(new FileReader("input.txt"));
            p1=sc.nextFloat();
            p2=sc.nextFloat();
            c=sc.nextFloat();
            t1=sc.nextInt();
            t2=sc.nextInt();
            while (sc.hasNext()){
                Scanner sc1=null;
                sc1= new Scanner(sc.next());
                sc1.useDelimiter(Pattern.compile(":"));
                int h =sc1.nextInt();
                int m=sc1.nextInt();
                int ss = sc1.nextInt();
                int tempArriv=3600*h+60*m+ss;
                Customer c = new Customer(tempArriv);
                Event ev1=new Arrival(c,c.arrivalTime);
                eventSet.add(ev1);
            }
        }catch (Exception e){
            System.out.println("Exception occured in readFile method "+e);
        }
    }
    
    /**
     * runSimulation method runs the simulation and keeps track of statistics
     */
    public void runSimulation(){
        Event e =null;
        while( !eventSet.isEmpty( ) ){
            e = eventSet.remove( );
            if (e.type==1){
                if(e.time>closeTime){break;}
                if(isFreeCashier()){
                    n++;
                    Cashier ca = freeCashier();
                    e.who.cashier= ca;
                    ca.assign(t1,t2,p1,p2);
                    ca.notAvailable();
                    eventSet.add(e.process());
                    waitTimes.add(e.time - e.who.arrivalTime);
                } else{
                    if((customerQueue.size()<8*s)){
                        customerQueue.push(e.who);
                    }else{overflow++;n++;}
                }
            }else{
                currentTime=e.time;
                e.who.cashier.available=true;
                totalProfit+=e.who.cashier.profit;
                if (!(customerQueue.isEmpty())){
                    Customer c = customerQueue.pop();
                    Event ev1=new Arrival(c,currentTime);
                    eventSet.add(ev1);}
            }
        }
        totalProfit-= s*c;

        for (Integer m : waitTimes) {
            sum+=m;
            if (m>max) max=m;
        }
        average=sum/waitTimes.size();
    }
    
    /**
     * isFreeCashier methods determines if there is at least one free cashier
     * @return a boolean expressing if there is a free cashier or not
     */
    public boolean isFreeCashier(){
        int i =0 ;
        while (i<s){
            if (cashierArray[i].available) return true;
            i++;
        }
        return false;
    } 
    
    /**
     * freeCashier method returns a free cashier if there is one or null if there is none
     * @return a free cashier if there is one or null if there is none
     */
    public Cashier freeCashier(){

        int i =0 ;
        while (i<s){
            if (cashierArray[i].available) return cashierArray[i];
            i++;
        }
        return null;
    }

    /**
     * main method does the computation used in the analysis of the project
     * @param String array of arguments
     */
    public static void main(String[] args){

        for (int i=1 ;i<=15 ;i++){
        System.out.println(i+" cashiers :");
        Simulation s= new Simulation(i);
        s.runSimulation();
        System.out.println(s.overflow+" / "+s.n);
        System.out.println("total profit: "+ s.totalProfit);
        System.out.println("average waitime: "+s.average+"seconds, max waitime: "+s.max+" seconds");}
        
        
        for (int j=1;j<=10;j++){
            float averageProfit=0; int averageOverflow=0; int averageWaitime=0; int averageMaxWaitime=0;
            for (int i=0;i<100;i++){
                Simulation s= new Simulation(j);
                s.runSimulation();
                averageProfit += s.totalProfit;
                averageOverflow += s.overflow;
                averageWaitime += s.average;
                averageMaxWaitime += s.max;
            }
            System.out.println(j+" cashiers :");
            System.out.println("Average overflow: "+ (int)averageOverflow/100) ;
            System.out.println("Average profit: "+ averageProfit/100);
            System.out.println("Average waitime: "+ averageWaitime/100 + " seconds");
            System.out.println("Average max waitime: "+ averageMaxWaitime/100 + " seconds");
        }
    }
}
