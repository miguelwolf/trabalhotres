package br.com.miguelwolf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import org.primefaces.model.chart.ChartSeries;

import br.com.miguelwolf.entidade.Valores;

@Named
@ApplicationScoped
public class ValoresService {
     
    private final static String[] girls;
    private final static Integer[] girlsNumeros;
     
    private final static String[] boys;
    private final static Integer[] boysNumeros;
     
    static {    	
        girls = new String[5];
        girls[0] = "2004";
        girls[1] = "2005";
        girls[2] = "2006";
        girls[3] = "2007";
        girls[4] = "2008";
         
        boys = new String[5];
        boys[0] = "2004";
        boys[1] = "2005";
        boys[2] = "2006";
        boys[3] = "2007";
        boys[4] = "2008";
        
        
        girlsNumeros = new Integer[5];
        girlsNumeros[0] = 52;
        girlsNumeros[1] = 60;
        girlsNumeros[2] = 110;
        girlsNumeros[3] = 135;
        girlsNumeros[4] = 120;
         
        boysNumeros = new Integer[5];
        boysNumeros[0] = 120;
        boysNumeros[1] = 100;
        boysNumeros[2] = 44;
        boysNumeros[3] = 150;
        boysNumeros[4] = 25;
        
    }
     
    public ArrayList<Valores> createValoresBoys(int size) {
        ArrayList<Valores> list = new ArrayList<Valores>();
        for(int i = 0; i < 5 ; i++) {
        	list.add(new Valores(i, boys[i], boysNumeros[i]));
        }
         
        return list;
    }
    
    public ArrayList<Valores> createValoresGirls(int size) {
    	ArrayList<Valores> list = new ArrayList<Valores>();
        for(int i = 0 ; i < 5 ; i++) {
        	list.add(new Valores(i, girls[i], girlsNumeros[i]));
        }
         
        return list;
    }     
    
}