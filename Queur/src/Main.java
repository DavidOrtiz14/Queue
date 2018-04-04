import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList <> ();
		Scanner sc = new Scanner(System.in);
		
		int t=0;
        SLLQueue<Job> inaq = new SLLQueue<>();
        SLLQueue<Job> outaq = new SLLQueue<>();
        ArrayList<Job> finalJ = new ArrayList<>();
        
        //*****************************************************
        //Collect data
     
        System.out.println("To stop enter data write -1:");
        while(true) {
        	String strA=sc.nextLine();
        	if(strA.equals("-1")) {
        		break;
        	}
        	str.add(strA);
        }
        //*****************************************************
        
        int ID=0;
        for(int z=0; z<str.size(); z++) {
        	Job j= new Job(ID,Integer.parseInt(str.get(z).substring(0,1)),Integer.parseInt(str.get(z).substring(2)));
            inaq.enqueue(j);
            ID++;
           // System.out.println(Integer.parseInt(str.get(z).substring(0,1))+" "+Integer.parseInt(str.get(z).substring(2)));
        }

        //*****************************************************
        t=0;
        while(!inaq.isEmpty()||!outaq.isEmpty()) {
        	
        	if(!outaq.isEmpty()) {
        		Job jn =outaq.dequeue();
        		jn.setRemainingTime(jn.getRemainingTime()-1);
             
        		   
        		if(jn.getRemainingTime()==0) {
        			jn.setDepartureTime(t);
        			
        			finalJ.add(jn);
        		}
        		else {
        			outaq.enqueue(jn);
        		}
        	
        	}
        	if((!inaq.isEmpty()) && (inaq.first().getArrivalTime()==t)) {
        		outaq.enqueue(inaq.dequeue());
        	}
        	
        	t++;
        }

        
  //******************************************************      
        
        
        double promedio=0;
        double result=0;
        
        for(int y =0;y<finalJ.size();y++) {
        	result = (finalJ.get(y).getDepartureTime()-finalJ.get(y).getArrivalTime())+result;
        }
        
        promedio=result/finalJ.size();
        System.out.println("Promedio: "+promedio);
        
	}

}
