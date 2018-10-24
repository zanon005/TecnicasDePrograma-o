import TiposCalculoBonusDeMilhas.CalculoBonusClienteFrequente;
import TiposCalculoBonusDeMilhas.CalculoBonusSorte;
import TiposCalculoBonusDeMilhas.CalculoBonusTempoVerao;
import TiposCalculoBonusDeMilhas.CalculoSemBonusMilhas;
import TiposCalculoBonusDeMilhas.ICalculaBonusDeMilhas;

public class ClienteCompanhiaAerea implements IClienteCompanhiaAerea {

	private String nome;
	private double milhasAcumuladas;
	
	private ICalculaBonusDeMilhas calculoDeMilhas;
	
	public ClienteCompanhiaAerea(String nome, int milhasVoadas) {
		this.nome = nome;
		this.milhasAcumuladas = milhasVoadas;
		calculoDeMilhas = new CalculoSemBonusMilhas();
	}
	
	public double milhasAcumuladas(double distanciaVoadaEmMilhas) {
		milhasAcumuladas += calculoDeMilhas.calculaBonusDeMilhas(distanciaVoadaEmMilhas);
		return milhasAcumuladas; // retorna as milhas que já tinha mais o bonus que ganhou com a viagem
	}
	
	// VERIFICAR A DIFERENÇA ENTRE ESTES 2 METODOS DE SET ABAIXO !!!!!!!!!!!!!!!!!
	public void setCalculoBonusDeMilhas(ICalculaBonusDeMilhas calculo) {
		if(calculo instanceof CalculoBonusClienteFrequente) {
			calculo = new CalculoBonusClienteFrequente();
		}else if(calculo instanceof CalculoBonusTempoVerao) {
			calculo = new CalculoBonusTempoVerao();
		}else if(calculo instanceof CalculoBonusSorte) {
			calculo = new CalculoBonusSorte();
		}
	}
	// VERIFICAR A DIFERENÇA ENTRE ESTES 2 METODOS DE SET !!!!!!!!!!!!!!!!!
	public void setCalculoBonusDeMilhas2(ICalculaBonusDeMilhas calculo) {
		this.calculoDeMilhas = calculo;
	}
	// VERIFICAR A DIFERENÇA ENTRE ESTES 2 METODOS DE SET ACIMA !!!!!!!!!!!!!!!!!
	
	public String getNome() {return nome;}
	public double getMilhasAcumuladas() {return milhasAcumuladas;}
	
	@Override
	public String toString() {
		return "Cliente da Companhia [Nome: "+getNome()+" ,Milhas Acumuladas: "+getMilhasAcumuladas()+" ]";
	}
}
