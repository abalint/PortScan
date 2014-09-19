import java.net.*;
import java.util.*;
import java.*;
public class portScan
{
    static Socket s;
    public static void main(String[]args)throws Exception
    {
	Scanner cscan = new Scanner (System.in);
	boolean exists = false;
	int choice = 0;
	int low = 0;
	int high = 0;
	String ln = "";
	String ln1 = "";
	InetAddress address = InetAddress.getByName(ln);
	int choice1 = 0;
	int[] open = new int[65535];
	int start = 0;
	int value = 0;
	String print = "";
	while (exists == false)
	{
		System.out.println("Enter an ip");
		ln = cscan.nextLine();
		char check = 'a';
	
		try
		{
			address = InetAddress.getByName(ln);
		}
		catch (java.net.UnknownHostException e)
		{
			System.out.println("Host does not exist");
			check = 'b';
		}
		if(check != 'b')
			exists = true;
		
	}
	System.out.println("That ip exists and is " + address);
	System.out.println("Would you like to scan the ports for this host?");
	System.out.println("1. Yes");
	System.out.println("2. no");
	choice = cscan.nextInt();
	
	if(choice == 1)
	    {
		System.out.println("1. Scan all 65535 ports");
		System.out.println("2. Set port scan range");
		choice1 = cscan.nextInt();
		if (choice1 == 1)
		    {
			System.out.println("Scanning all ports on host " +ln);
			for(int index = 0; index < 65535; index++)
			    {
				try
				    {
			 		s = new Socket(address, index);
					System.out.println("Port " +index+" is open");
					open[start] = index;
					start++;
					s.close();
				    }
				catch(Exception e)
				    {
				    System.out.println("--");
				    }
			    }
		    }
		if (choice1 == 2)
		    {
			System.out.println("Please enter the lowest port");
			low = cscan.nextInt();
			System.out.println("Please enter the highest port");
			high = cscan.nextInt();
			for (int index = low; index < high; index++)
			    {
				try
				    {
					s = new Socket(address, index);
					System.out.println("Port "+ index+" is open");
					open[start] = index;
					start++;
					s.close();
				    }
				catch(Exception e)
				    {
				    System.out.println("--"+index);
				    }
			    }

		    }
	    }

	//print = toString(open[]);
	String print1 = "";
	for(int index = 0; index < open.length; index++)//open[open.length-1]
	    {
		//System.out.println( open[index]+ " ");
		print1 = open[index]+" ";
	    }
	if(start == 0)
	    {
		System.out.println("No ports are open");
		System.exit(0);
	    }
	System.out.print("Ports open: ");
	for(int i = 0; i<start; i++)
	    {
		System.out.print(+open[i]+", ");
	    }
	if (choice == 2);
	{
	    System.out.println("goodbye");
	    System.exit(0);
	}

	return;
    }

    /*public String toString(open[])
    {
	String ln;
	for (int index = 0; index <open[open.length-1]; index++)
	    {
		ln = open[index]+" ";
	    }
	return ln;
	}*/

}