package enumeration;



public class SportsCarDemo2 {

	public static void main(String[] args) {
	
		
		SportsCar newCar = new SportsCar(CarType.PORSCHE, CarColor.RED, 1000000);
		
		
		System.out.println(newCar);

		if (newCar.getMake().equals(CarType.PORSCHE)) {
			System.out.println("Bilen er lavet i Tyskland");
		} else if (newCar.getMake() == CarType.FERRARI) {
			System.out.println("Bilen er lavet i Italien");
		} else if (newCar.getMake().equals(CarType.JAGUAR)) {
			System.out.println("Bilen er lavet i England");

		} else
			System.out.println("Jeg ved ikke hvor bilen er lavet");
	
		switch (newCar.getMake()){
		case PORSCHE:
			System.out.println("Bilen er lavet i Tyskland");
			break;
		case FERRARI:
			System.out.println("Bilen er lavet i Italien");
			break;
		case JAGUAR:
			System.out.println("Bilen er lavet i England");
			break;
		default:
	}
	}
	

}
