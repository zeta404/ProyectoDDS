package modelo;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BalaEnemigo extends EntidadDinamica{
	public BalaEnemigo (float x,float y,float ancho,float alto, float vx, float vy,AtlasRegion textura){
		super(x,y,ancho,alto,vx,vy,textura);
	}
}
