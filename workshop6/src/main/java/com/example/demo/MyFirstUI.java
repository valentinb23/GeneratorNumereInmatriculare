package com.example.demo;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

@SpringUI(path = "paginameaa")
public class MyFirstUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout superMain = new VerticalLayout();
		HorizontalLayout mainLayout = new HorizontalLayout();

		Label label = new Label("Generator numere inmatriculare");
		TextField input = new TextField();
		Button button = new Button("Genereaza");

		CheckBox check = new CheckBox("Like!");

		List<String> judete = new ArrayList<>();
		judete.add("AG");
		judete.add("B");

		List<String> tipDiplomatic = new ArrayList<>();
		tipDiplomatic.add("CD");
		tipDiplomatic.add("TC");

		List<String> tipNumar = new ArrayList<>();
		tipNumar.add("Normal");
		tipNumar.add("Provizoriu");
		tipNumar.add("Diplomatic");
		tipNumar.add("Armata");

		List<String> listaGoala = new ArrayList<>();

		ComboBox<String> combo = new ComboBox("Tip numar");
		combo.setItems(tipNumar);
		combo.setWidth(300, Unit.PIXELS);
		combo.setId("my_combo");
		combo.setStyleName("my_class");

		ComboBox<String> comboJudete = new ComboBox("Judete");
		comboJudete.setItems(judete);
		comboJudete.setWidth(200, Unit.PIXELS);
		comboJudete.setId("comboJudete");
		comboJudete.setStyleName("my_class");

		comboJudete.setItems(listaGoala);
		combo.addSelectionListener(e -> {
			if (combo.getValue() == "Diplomatic")
				comboJudete.setItems(tipDiplomatic);
			else if (combo.getValue() == "Armata")
				comboJudete.setItems(listaGoala);
			else {
				comboJudete.setItems(judete);
			}
		});

		button.addClickListener(e -> {
			if (combo.getValue() == null) {
				Notification.show("Alegeti un tip de numar");
				return;
			}
			if (combo.getValue() != "Armata" && comboJudete.getValue() == null) {
				Notification.show("Alegeti un judet");
				return;
			}
			if (combo.getValue() == "Normal")
				input.setValue(VehicleUtil.Normal(comboJudete.getValue()));
			else if (combo.getValue() == "Provizoriu" || combo.getValue() == "Diplomatic")
				input.setValue(VehicleUtil.Provizoriu(comboJudete.getValue()));
			else if (combo.getValue() == "Armata")
				input.setValue(VehicleUtil.Armata());
		});

		mainLayout.addComponent(label);
		mainLayout.addComponent(input);
		mainLayout.addComponent(button);

		superMain.addComponent(mainLayout);
		superMain.addComponent(combo);
		superMain.addComponent(comboJudete);
		setContent(superMain);

	}

}
