import EstadosPossiveisDoAviao.EstadoEstacion�rio;
import EstadosPossiveisDoAviao.IEstado;

class Aviao implements IAviao { // class publica

	//private CategoriaDoAviao categoria; COMO COLOCAR ENUM NESSA CLASSE????
	private int id;
	private String marca;
	private double pesoEmbarcado;
	private double combustivelAtual; // Em litros , vai ser o total do tanque de combustivel na partida do voo.
	private IEstado meuEstado; // vai definir quantos Km/L o avi�o far�.
	
	Aviao(int id, String marca,double pesoEmbarcado,double combustivel){ // Construtor
		//this.categoria = comercial;
		this.id = id; 
		this.marca = marca;
		this.pesoEmbarcado = pesoEmbarcado;
		this.combustivelAtual = combustivel;
		
		this.meuEstado = new EstadoEstacion�rio();
	}

	@Override
	public double distanciaTotalPossivelAtualmenteEmKM() {
		return combustivelAtual / meuEstado.litrosGastosPorKM();
	}
	
	@Override
	public void voar(double distancia) {
		double combustivelNecessarioParaVoo = distancia*meuEstado.litrosGastosPorKM(); 
		if(combustivelNecessarioParaVoo <= combustivelAtual) {
			combustivelAtual-= combustivelNecessarioParaVoo; 
		}else if(combustivelNecessarioParaVoo > combustivelAtual) {
			System.out.println("Imposs�vel realizar o voo, combust�vel insuficiente");
		}
	} 
	
	//CategoriaDoAviao getCategoria() {return this.categoria;} // ENUM da instancia.
	void setEstado(IEstado estado) {meuEstado = estado;} // Muda a instancia de "meuEstado" para a do estado novo, muda a classe
	int getID() { return id ;}
	String getMarca() {return marca;}
	double getPesoEmbarcado() {return pesoEmbarcado;}
	double getCombustivelAtual() {return combustivelAtual;}
	
	//!!!!!!!!!!!!! DUVIDA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// Este metodo precisa da declara��o PUBLIC, porque???? 
	@Override
	public String toString() { 
		/*return "[Avi�o De Uso :"+getCategoria()+"ID: "+getID()+", Marca: "+getMarca()+", "
				+ "Peso Embarcado: "+getPesoEmbarcado()+"e Combustivel No Tanque: "+getCombustivelAtual()+" ]";*/
		return "[Avi�o de ID: "+getID()+", Marca: "+getMarca()+", "
		+ "Peso Embarcado: "+getPesoEmbarcado()+"e Combustivel No Tanque: "+getCombustivelAtual()+" ]";
	}
	
	
	
	
	
	
	
	
	
	
}
