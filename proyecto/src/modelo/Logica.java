package modelo;

import java.util.ArrayList;

import vista.Proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Logica {
	private static Proyecto proyecto;
	InterfazFabrica fabrica = new FabricaEntidadesDinamicas();
	private ArrayList<Entidad> array = new ArrayList<Entidad>();
	private SpriteBatch batch;
	EntidadDinamica nave;
	private float acumulador=0;
	private int fila=0;
	private TextureAtlas texture;
	public AtlasRegion naveTextura,mocoRojo,libelula,fondo,bala;
	private String[][] nivel1 = new String[][]{
			{"","Nave",""},{"","",""},{"","libelula","mocoRojo"},
			{"","",""},{"","",""},
			{"mocoRojo","mocoRojo",""}};
	
public Logica(Proyecto proy) {
	proyecto=proy;
	batch = new SpriteBatch();
	texture = new TextureAtlas(Gdx.files.internal("data/game.atlas"));
	naveTextura = texture.findRegion("naveNormal");
	mocoRojo = texture.findRegion("mocoRojo");
	libelula = texture.findRegion("libelula");
	fondo = texture.findRegion("fondo");
	bala = texture.findRegion("bala");
}
public void crearNave(AtlasRegion textura){
	nave=(EntidadDinamica) fabrica.crearEntidad("Nave", new float[]{0,0 ,50,50,0,0},textura);
	array.add(nave);
}
public void crearBala(){
	crearEntidades("Bala",new float[]{nave.getX()+nave.getAncho()/2,nave.getY()+nave.getAlto(),20,20,0,4},bala);
}
public void crearEntidades(String _entidad, float[] parametros,AtlasRegion textura){
	if(!_entidad.equals(""))
	array.add(fabrica.crearEntidad(_entidad, parametros,textura));
	}
public void inicializarMapa(){
	for(fila=0;fila<4;fila++)
		for(int j=0;j<nivel1[fila].length;j++){
			if(nivel1[fila][j].equals("Nave"))
				crearNave(naveTextura);
			else if(nivel1[fila][j].equals("mocoRojo"))
			crearEntidades(nivel1[fila][j], new float[]{800/3*j,600/3*fila,50,50,0,-0.2f}, mocoRojo);	
			else if(nivel1[fila][j].equals("libelula"))
				crearEntidades(nivel1[fila][j], new float[]{800/3*j,600/3*fila,50,50,0,-0.2f}, libelula);	

		}
}
public void actualizar(float time){
	for(Entidad entidad : array) ((EntidadDinamica) entidad).actualizar(5f);
	acumulador+=time;
	if(acumulador>6){
		  acumulador=0;
		  if(fila<nivel1.length){
		  for(int j=0;j<nivel1[fila].length;j++)
			  crearEntidades(nivel1[fila][j], new float[]{800/3*j,600/3*3,50,50,0,-0.2f}, libelula);
			fila++;
		  }	
	}
}
public void iA(){
	double random;
	for(int i=0;i<array.size();i++){
		if(array.get(i) instanceof Enemigo){
		random=Math.random()*50;
		if(random>2 && random<2.55){
			crearEntidades("BalaEnemigo",new float[]{array.get(i).getX()+array.get(i).getAncho()/2,array.get(i).getY(),20,20,0,-4},bala);
		}
		}
	}
}
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
public void dibujar(){
	batch.begin();
	batch.draw(fondo, 0, 
			0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	for(Entidad entidad : array)
	batch.draw(entidad.getTextura(), entidad.getX(), 
			entidad.getY(), entidad.getAncho(), entidad.getAlto());
	batch.end();
}

public void moverNaveX(float vx){
	nave.setVx(vx);
}
public void moverNaveY(float vy){
	nave.setVy(vy);
}
}

