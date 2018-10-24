import EstadosPossiveisDoAviao.EstadoEstacionário;
import EstadosPossiveisDoAviao.IEstado;

class Aviao implements IAviao { // class publica

	//private CategoriaDoAviao categoria; COMO COLOCAR ENUM NESSA CLASSE????
	private int id;
	private String marca;
	private double pesoEmbarcado;
	private double combustivelAtual; // Em litros , vai ser o total do tanque de combustivel na partida do voo.
	private IEstado meuEstado; // vai definir quantos Km/L o avião fará.
	
	Aviao(int id, String marca,double pesoEmbarcado,double combustivel){ // Construtor
		//this.categoria = comercial;
		this.id = id; 
		this.marca = marca;
		this.pesoEmbarcado = pesoEmbarcado;
		this.combustivelAtual = combustivel;
		
		this.meuEstado = new EstadoEstacionário();
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
			System.out.println("Impossível realizar o voo, combustível insuficiente");
		}
	} 
	
	//CategoriaDoAviao getCategoria() {return this.categoria;} // ENUM da instancia.
	void setEstado(IEstado estado) {meuEstado = estado;} // Muda a instancia de "meuEstado" para a do estado novo, muda a classe
	int getID() { return id ;}
	String getMarca() {return marca;}
	double getPesoEmbarcado() {return pesoEmbarcado;}
	double getCombustivelAtual() {return combustivelAtual;}
	
	//!!!!!!!!!!!!! DUVIDA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// Este metodo precisa da declaração PUBLIC, porque???? 
	@Override
	public String toString() { 
		/*return "[Avião De Uso :"+getCategoria()+"ID: "+getID()+", Marca: "+getMarca()+", "
				+ "Peso Embarcado: "+getPesoEmbarcado()+"e Combustivel No Tanque: "+getCombustivelAtual()+" ]";*/
		return "[Avião de ID: "+getID()+", Marca: "+getMarca()+", "
		+ "Peso Embarcado: "+getPesoEmbarcado()+"e Combustivel No Tanque: "+getCombustivelAtual()+" ]";
	}
	
	
	
	
	
	
	
	
	
	
}
