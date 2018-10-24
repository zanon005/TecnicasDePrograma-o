package TiposCalculoBonusDeMilhas;

public class CalculoBonusSorte implements ICalculaBonusDeMilhas {

	@Override
	public double calculaBonusDeMilhas(double milhasVoadasEmMilhas) {
		double milhas = milhasVoadasEmMilhas;
		double percentBonus = Math.random()+1; // range default 0.0->1.0, como quero somente entre
		if(percentBonus > 1.7) { percentBonus = 1.7; } // 1.0->1.7, somo 1 e limito até 1.7
		milhas *= percentBonus;
		return milhas;
	}

}
