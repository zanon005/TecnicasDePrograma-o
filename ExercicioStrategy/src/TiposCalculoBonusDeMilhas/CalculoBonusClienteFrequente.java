package TiposCalculoBonusDeMilhas;

public class CalculoBonusClienteFrequente implements ICalculaBonusDeMilhas {

	@Override
	public double calculaBonusDeMilhas(double milhasVoadasEmMilhas) {
		double milhas = milhasVoadasEmMilhas;
		if(milhasVoadasEmMilhas > 2000) { milhas*= 1.10;}
		return milhas;
	}

}
