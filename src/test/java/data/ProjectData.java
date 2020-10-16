package data;

import java.util.Properties;

public class ProjectData {
	// Attributes
	public String title;
	public String startDate;
	public String endDate;
	public String times;
	public String timeUnit;
	public String status;

	public String eleChequearTodos;
	public String eleDeletechequeados;
	public String eleAddButton;
	public String eleCabezalMensaje;

	public String eleIngresaTitulo;
	public String eleIngresaComienzo;
	public String eleIngresaFin;
	public String eleIngresaTimes;
	public String eleIngresaTimeUnit;
	public String eleIngresaStatus;
	public String eleSaveButton;
	
	public String eleSearchBox;
	public String eleSearchButton;
	
	public String elePathBuscaEnTablaYDel1;
	public String elePathBuscaEnTablaYDel2;
	
	public String eleValidaCabezalMensajeVer;
	
	public String elePathBuscaEnTablaYVer1;
	public String elePathBuscaEnTablaYVer2;
	
	
	
	// Constructor
	private ProjectData(String tit, String start, String end, String time, String timeU, String stat, String eleCheckAll,
			String eleDelSel, String eleAdd, String eleCaMen, String eleIngTit, String eleIngCom, String eleIngFin, 
			String eleIngTimes, String eleIngTimeU, String eleIngStat, String eleSavBut, String eleSeaBox, String eleSeaBut,
			String elePath, String elePathDel, String eleCaMenVer, String elePathVer1, String elePathVer2
			) {

		this.title = tit;
		this.startDate = start;
		this.endDate = end;
		this.times = time;
		this.timeUnit = timeU;
		this.status = stat;
		
		this.eleChequearTodos = eleCheckAll;
		this.eleDeletechequeados = eleDelSel;
		this.eleAddButton = eleAdd;
		
		this.eleCabezalMensaje = eleCaMen;
		
		this.eleIngresaTitulo = eleIngTit;
		this.eleIngresaComienzo = eleIngCom;
		this.eleIngresaFin = eleIngFin;
		this.eleIngresaTimes = eleIngTimes;
		this.eleIngresaTimeUnit = eleIngTimeU;
		this.eleIngresaStatus = eleIngStat;
		
		this.eleSaveButton = eleSavBut;
		
		this.eleSearchBox = eleSeaBox;
		this.eleSearchButton = eleSeaBut;
		
		this.elePathBuscaEnTablaYDel1 = elePath;
		this.elePathBuscaEnTablaYDel2 = elePathDel;
		
		this.eleValidaCabezalMensajeVer = eleCaMenVer;
		
		this.elePathBuscaEnTablaYVer1 = elePathVer1;
		this.elePathBuscaEnTablaYVer2 = elePathVer2;
		
		
		
	}

	// Selector de datos por Int
	public static ProjectData get(int n, Properties prop, Properties eleProp) {
		ProjectData data = new ProjectData("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

		data.title = prop.getProperty("title_" + n);
		data.startDate = prop.getProperty("startDate_" + n);
		data.endDate = prop.getProperty("endDate_" + n);
		data.times = prop.getProperty("times_" + n);
		data.timeUnit = prop.getProperty("timeUnit_" + n);
		data.status = prop.getProperty("status_" + n);
		
		data.eleChequearTodos = eleProp.getProperty("eleChequearTodos");
		data.eleDeletechequeados = eleProp.getProperty("eleDeletechequeados");
		data.eleAddButton = eleProp.getProperty("eleAddButton");

		data.eleCabezalMensaje = eleProp.getProperty("eleCabezalMensaje");
		
		data.eleIngresaTitulo = eleProp.getProperty("eleIngresaTitulo");
		data.eleIngresaComienzo = eleProp.getProperty("eleIngresaComienzo");
		data.eleIngresaFin = eleProp.getProperty("eleIngresaFin");
		data.eleIngresaTimes = eleProp.getProperty("eleIngresaTimes");
		data.eleIngresaTimeUnit = eleProp.getProperty("eleIngresaTimeUnit");
		data.eleIngresaStatus = eleProp.getProperty("eleIngresaStatus");
		
		data.eleSaveButton = eleProp.getProperty("eleSaveButton");
		
		data.eleSearchBox = eleProp.getProperty("eleSearchBox");
		data.eleSearchButton = eleProp.getProperty("eleSearchButton");
		
		data.elePathBuscaEnTablaYDel1 = eleProp.getProperty("elePathBuscaEnTablaYDel1");
		data.elePathBuscaEnTablaYDel2 = eleProp.getProperty("elePathBuscaEnTablaYDel2");
		
		data.eleValidaCabezalMensajeVer = eleProp.getProperty("eleValidaCabezalMensajeVer");
		
		data.elePathBuscaEnTablaYVer1 = eleProp.getProperty("elePathBuscaEnTablaYVer1");
		data.elePathBuscaEnTablaYVer2 = eleProp.getProperty("elePathBuscaEnTablaYVer2");
		
		
		
		return data;

	}

}
