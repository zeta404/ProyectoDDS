package modelo.niveles;

import java.util.ArrayList;

public class Nivel1 {
	private static final String[][] nivel1 = new String[][]{

			{"","","","","","","","Nave","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","Abeja","Abeja","Abeja"},
			{"","","","","","","","","","","","","Abeja","Abeja","Abeja"},
			{"","","","","","","","","","","","","Abeja","Abeja","Abeja"},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","Libelula","","BolaVida","BolaVida","BolaVida","","","Libelula","Ciclope","Ciclope","Ciclope","MocoRojo","",""},
			{"Libelula","","MocoRojo","Libelula","","Ciclope","Ciclope","Ciclope","Libelula","","","","MocoRojo","","","Libelula"},
			{"MocoRojo","","","MocoRojo","","Libelula","","","Libelula","","MocoRojo","","","Libelula",""},
			{"","","","","","Libelula","MocoRojo","","","MocoRojo","Libelula","","","",""},
			{"MocoRojo","","","","","","","","","","","","","",""},
			{"MocoRojo","","","Libelula","","","MocoRojo","","","","","Libelula","","","MocoRojo"},
			{"","MocoRojo","","","","Libelula","","","Libelula","","MocoRojo","","","",""},
			{"","MocoRojo","","","MocoRojo","","","MocoRojo","","Libelula","","MocoRojo","Libelula","",""},
			{"","","","","","","","Abeja","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","","","","","","","",""},
			{"","","","","","","","JefeRajoy","","","","","","",""}
	};

	/*
	private static final String[][] nivel1 = new String[][]{
		{"","","","Nave"},{"","","",""},{"","Libelula","MocoRojo",""},
		{"","Libelula","",""},{"Libelula","MocoRojo","MocoRojo","Libelula"}};*/
	int filaActual=0;
	public Nivel1(){
		}
	
	public ArrayList<String> getFila(int numFilas){
		ArrayList<String> fila= new ArrayList<String>();
		if(filaActual+numFilas<=nivel1.length)
		for(int j=0;j<numFilas;j++){
		for(int i=0;i<nivel1[filaActual].length;i++){
			fila.add(nivel1[filaActual][i]);
		}
		filaActual++;
		}
		return fila;
	}

	public int getFilaActual() {
		return filaActual;
	}
}
