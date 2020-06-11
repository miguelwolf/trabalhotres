package br.com.miguelwolf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import br.com.miguelwolf.entidade.Valores;
import br.com.miguelwolf.utils.Constants;

@ManagedBean
@ViewScoped
public class BarChartBean {
	private BarChartModel barModel;

	private ChartSeries b1Dropped;

	private List<Valores> itemsGirls;
	private List<Valores> selectedItemsGirls = new ArrayList<>();

//	private List<Valores> itemsBoys;
//	private List<Valores> selectedItemsBoys = new ArrayList<>();

	@PostConstruct
	public void postConstruct() {

		itemsGirls = new ArrayList<Valores>();
		itemsGirls.add(new Valores(1, "2004", 52));
		itemsGirls.add(new Valores(1, "2005", 60));
		itemsGirls.add(new Valores(1, "2006", 110));
		itemsGirls.add(new Valores(1, "2007", 135));
		itemsGirls.add(new Valores(1, "2008", 120));
		
//		itemsBoys = new ArrayList<Valores>();
//		itemsBoys.add(new Valores(1, "2004", 120));
//		itemsBoys.add(new Valores(1, "2005", 130));
//		itemsBoys.add(new Valores(1, "2006", 110));
//		itemsBoys.add(new Valores(1, "2007", 105));
//		itemsBoys.add(new Valores(1, "2008", 90));

		barModel = new BarChartModel();

	}

	public List<Valores> getItemsGirls() {
		return itemsGirls;
	}
	
//	public List<Valores> getItemsBoys() {
//		return itemsBoys;
//	}

	public void onItemDropped(DragDropEvent event) {
		Valores item = (Valores) event.getData();

		barModel = new BarChartModel();
		BarChartSeries s = new BarChartSeries();
		s.setLabel(Constants.MENINAS);

		// GIRLS============================================================================================
		selectedItemsGirls.add(new Valores(item.getId(), item.getLabel(), item.getValor()));

		for (int i = 0; i < selectedItemsGirls.size(); i++) {
			s.set(selectedItemsGirls.get(i).getLabel(), selectedItemsGirls.get(i).getValor());
		}

		barModel.addSeries(s);
		barModel.setLegendPosition("g");

//		// BOYS=============================================================================================
//		s = new ChartSeries();
//		s.setLabel(Constants.MENINOS);
//		
//		if (!selectedItemsBoys.isEmpty()) {
//			for (int i = 0; i < selectedItemsBoys.size(); i++) {
//				s.set(selectedItemsBoys.get(i).getLabel(), selectedItemsBoys.get(i).getValor());
//			}
//
//			lineModel.addSeries(s);
//			lineModel.setLegendPosition("b");
//		}

		Axis y = barModel.getAxis(AxisType.Y);
		y.setMin(1);
		y.setMax(200);
		y.setLabel(Constants.NASCIMENTOS);

		Axis x = barModel.getAxis(AxisType.X);
		x.setMin(2004);
		x.setMax(2008);
		x.setTickInterval("1");
		x.setLabel(Constants.ANOS);

		itemsGirls.remove(item);

	}

	public List<Valores> getSelectedItems() {
		return selectedItemsGirls;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public ChartSeries getB1Dropped() {
		return b1Dropped;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public void setB1Dropped(ChartSeries b1Dropped) {
		this.b1Dropped = b1Dropped;
	}

	public void setItems(List<Valores> items) {
		this.itemsGirls = items;
	}

	public void setSelectedItems(List<Valores> selectedItems) {
		this.selectedItemsGirls = selectedItems;
	}

}