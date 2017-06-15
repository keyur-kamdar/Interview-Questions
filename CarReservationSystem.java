
import java.lang.Math; 
import java.util.*;


public class CarSystem
{
	HashMap<Integer, Queue<String>> availableCars;
	HashMap<Integer, UsedCarNode> inUse;
	HashMap<String, UsedCarNode> numPlateMap;


	public CarSystem(){
		availableCars = new HashMap<Integer, Queue<String>>();
		inUse = new HashMap<Integer, UsedCarNode>();
		numPlateMap = new HashMap<String, UsedCarNode>();
	}


	public static void main(String[] args)
	{

		CarSystem c = new CarSystem();


		// Trucks
		Queue<String> quCars = new LinkedList<String>();
		quCars.offer("ASD123");
		quCars.offer("POI345");
		quCars.offer("TRE567");
		c.availableCars.put(1, quCars);


		// Cars
		quCars = new LinkedList<String>();
		quCars.offer("QWE123");
		quCars.offer("HGF345");
		quCars.offer("XCV567");
		c.availableCars.put(2, quCars);

		System.out.println(c.bookACar(1));
		System.out.println(c.bookACar(1));
		System.out.println(c.bookACar(1));
		System.out.println(c.bookACar(1));


		System.out.println(c.dropACar("TRE567"));
		System.out.println(c.dropACar("POI345"));
		System.out.println(c.dropACar("POI345"));

		System.out.println(c.bookACar(1));
		System.out.println(c.bookACar(1));

	}

	public String bookACar(Integer carType){
		if(availableCars.get(carType).size()>0){
			String numPlate = availableCars.get(carType).poll();
			UsedCarNode node  = new UsedCarNode(numPlate, carType);
			numPlateMap.put(numPlate, node);
			if(inUse.get(carType) != null){
				UsedCarNode head =  inUse.get(carType);
				head.left = node;
				node.right = head;
				inUse.put(carType, node);
			}
			else{
				inUse.put(carType, node);
			}

		return numPlate;

		}
		else{
			return "car not available";  
		}

	}
	public boolean dropACar(String numPlate){
		if(numPlateMap.get(numPlate) == null) {
			return false; 
		}

		UsedCarNode node = numPlateMap.get(numPlate);
		numPlateMap.remove(numPlate);

		if(node.left != null){
			node.left.right = node.right;
			node.right.left = node.left;
		}

		availableCars.get(node.carType).offer(numPlate);

		int carType = node.carType;
		node = null;
		if(inUse.get(carType) == null){
			inUse.remove(carType); 
		}

	return true;

	}
}

class UsedCarNode{
	String numPlate;	
	UsedCarNode left = null;
	UsedCarNode right = null;
	Integer carType;

	public UsedCarNode(String numPlate, Integer carType){
		this.numPlate = numPlate; 
		this.carType = carType;
	}
}
