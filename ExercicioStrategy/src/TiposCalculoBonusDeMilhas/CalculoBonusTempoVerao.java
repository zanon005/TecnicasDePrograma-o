package TiposCalculoBonusDeMilhas;

public class CalculoBonusTempoVerao implements ICalculaBonusDeMilhas {

	@Override
	public double calculaBonusDeMilhas(double milhasVoadasEmMilhas) {
		return milhasVoadasEmMilhas*2;
	}

}
