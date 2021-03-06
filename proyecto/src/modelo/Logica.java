package modelo;

import java.util.ArrayList;
import modelo.niveles.Nivel1;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Logica {
	InterfazFabricaEntidad fabrica = new FabricaEntidadesDinamicas();
	
	private SpriteBatch batch;
	Nivel1 nivel1;
	private Reloj reloj;
	private ColeccionEntidades coleccionEntidades;

public Logica() {
	coleccionEntidades =  new ColeccionEntidades();
	batch = new SpriteBatch();
	nivel1=new Nivel1();
	reloj=new Reloj();
}

public void crearBala(){
	coleccionEntidades.crearBala();
}

public void inicializarMapa(){
	int numeroFila=nivel1.getFilaActual();
	int numeroColumna=0;
	ArrayList<String> filas=nivel1.getFila(Constantes.filasPantalla+1);
	
	for(String unaFila : filas){
		coleccionEntidades.crearEntidad(unaFila, new float[]{numeroColumna,numeroFila,0,-1f});
		if(numeroColumna<3)numeroColumna++;
		if(numeroColumna==3){
		numeroFila++;
		numeroColumna=0;}
	}
}
public void actualizar(float time){
	coleccionEntidades.actualizar(time);
	
	reloj.actualizar(time);
	if(reloj.getAcumulado()>Constantes.tiempoRefrescoMapa){
		  reloj.reset();
		  ArrayList<String> filas=nivel1.getFila(1);
		  if(!filas.isEmpty()){
			    for(int numeroColumna=0;numeroColumna<filas.size();numeroColumna++)
			  coleccionEntidades.crearEntidad(filas.get(numeroColumna), new float[]{numeroColumna,
				  Constantes.filasPantalla+1,0,-3f});
		  }	
	}
}
/*
public void iA(){
	double random;
	for(int i=0;i<array.size();i++){
		if(array.get(i) instanceof Enemigo){
		random=Math.random()*50;
		if(random>2 && random<2.55){
			crearEntidades("BalaEnemigo",new float[]{array.get(i).getX()+array.get(i).getAncho()/2,array.get(i).getY(),20,20,0,-4});
		}
		}
	}
}
*/
/*
public void colision(){
	Entidad[] eliminar= new Entidad[array.size()];
	for(int r=0;array.size()>r;r++) {
		for(int i=0;array.size()>i;i++){
			
		if(array.get(i)!=array.get(r))
		if(array.get(r).colision(array.get(i).getSuperficie()))
			if(array.get(i) instanceof Bala && array.get(r) instanceof Enemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Bala && array.get(i) instanceof Enemigo){
				eliminar[r]=array.get(r); 
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Nave && array.get(i) instanceof Enemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Enemigo && array.get(i) instanceof Nave){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof BalaEnemigo && array.get(i) instanceof Nave){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}else if(array.get(r) instanceof Nave && array.get(i) instanceof BalaEnemigo){
				eliminar[r]=array.get(r);
				eliminar[i]=array.get(i);
			}
	}
		
		if(array.get(r) instanceof Bala || array.get(r) instanceof Enemigo)
			if(array.get(r).getY()<0 || array.get(r).getY()>Gdx.graphics.getHeight()+50 )
				eliminar[r]=array.get(r);}
		//System.out.println(array.size());
	for(Entidad entidad : eliminar){
		if(entidad!=null)array.remove(entidad);
	}
}
*/
public void dibujar(){
	coleccionEntidades.dibujar(batch);
}

public void moverNaveX(float vx){
	coleccionEntidades.moverNaveX(vx);
}
public void moverNaveY(float vy){
	coleccionEntidades.moverNaveY(vy);
}
}

