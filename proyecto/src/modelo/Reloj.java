package modelo;

public class Reloj {
	
	private float acumulado;
	private float tiempoGuardado;
	
	public float getTiempoGuardado() {
		return tiempoGuardado;
	}

	public void setTiempoGuardado(float tiempoGuardado) {
		this.tiempoGuardado = tiempoGuardado;
	}

	public Reloj(){
		acumulado = 0;
	}
	
	public void actualizar(float time){
		acumulado += time;
	}
	
	public void reset(){
		acumulado = 0;
	}
	
	public float getAcumulado(){
		return acumulado;
	}

}
