import java.util.logging.ErrorManager;

import EstadosPossiveisDoAviao.*;

public class App {
	public static void main(String args[]) {
		//int id, String marca,double pesoEmbarcado,double combustivel em litros
		Aviao aviao = new Aviao(001,"TAM",1500.0,25.0);
		
		aviao.setEstado(new EstadoPousando());
		System.out.println("Distancia que o avi�o pode percorrer em KM: "+aviao.distanciaTotalPossivelAtualmenteEmKM());
		
		aviao.setEstado(new EstadoDecolando());
		System.out.println("Distancia que o avi�o pode percorrer em KM: "+aviao.distanciaTotalPossivelAtualmenteEmKM());
		
		aviao.setEstado(new EstadoEstacion�rio());
		System.out.println("Distancia que o avi�o pode percorrer em KM: "+aviao.distanciaTotalPossivelAtualmenteEmKM());
		
		aviao.setEstado(new EstadoVooMaximaVelocidade());
		System.out.println("Distancia que o avi�o pode percorrer em KM: "+aviao.distanciaTotalPossivelAtualmenteEmKM());
		
		/*try {
		aviao.setEstado(new EstadoVooQuedaLivre());
		}catch(Error e) {
			//throw new RuntimeException();
			System.out.println("Erro pois a classe requisitada n�o foi encontrada/carregada/compilada");
		}*/
	}
}
