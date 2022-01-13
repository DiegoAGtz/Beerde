package controller;

public class Calculos {
	final double R = 0.539;
	final int DN = 351;
	final double P1 = 106161.22;
	
	public double calculoPaneles(double tipoConstruccion, double distanciaConstruccion) {
		//altitud -> 21
		double E = ((tipoConstruccion * distanciaConstruccion*1000)/30)*R;
		double delta = 23.45 * Math.sin(Math.toRadians(360 * (248 + DN)/365));
		double ws = Math.tan(Math.toRadians(21)) * Math.tan(Math.toRadians(delta));
		double H = P1 * ws * Math.sin(Math.toRadians(21)) * Math.sin(Math.toRadians(delta)) - Math.cos(Math.toRadians(21)) * Math.cos(Math.toRadians(delta)) * Math.sin(Math.toRadians(ws));
		double G = 8.07 * 1000; //Radiacion -> 8.07 * 1000
		double ktm = G/H;
		double Fd = 1 - 1.13 * ktm;
		double Dd = G * Fd;
		H = G - Dd;
		double Gf = H +Dd;
		
		double HPS = Gf * 0.001;
		double Pp = E / HPS;
		double Np = Pp/(0.28 * 0.9); // OpP -> 0.25 kW
		
		return Np;
	}
	
}
