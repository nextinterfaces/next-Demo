/*
 * Copyright 2011 Vancouver Ywebb Consulting Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package next.interfaces.controller.widgets;

import next.i.controller.XTableController;
import next.i.view.CellData;
import next.i.view.TableData;
import next.i.view.XTableCell;
import next.i.view.XTableView;
import next.interfaces.rpc.HelloService;
import next.interfaces.rpc.HelloServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;

public class WidgetsController extends XTableController {

	private final HelloServiceAsync helloRPC = GWT.create(HelloService.class);

	public WidgetsController() {

		setTitle("NEXT widgets");

		// getNavigationBar().setRightTitle("Source");
		// getNavigationBar().getRightButton().addClickHandler(new ClickHandler() {
		// public void onClick(ClickEvent event) {
		// DemoUtils.openGit(getGitPath());
		// }
		// });

		((XTableView) getView()).showChevron(true);

		TableData tableDS = new TableData();

		tableDS.add(new CellData(createImage("images/icons/i-list.png"), "Lists", null), new CellData(
				createImage("images/icons/i-slider.png"), "Slider", null), new CellData(
				createImage("images/icons/i-radio.png"), "Radio Button", null), new CellData(
				createImage("images/icons/i-button.png"), "Buttons", null), new CellData(
				createImage("images/icons/i-picker.png"), "Picker", null), new CellData(
				createImage("images/icons/i-switch.png"), "Switch", null), new CellData(createImage("images/icons/i-form.png"),
				"Form", null), new CellData(createImage("images/icons/i-progress.png"), "Progress", null), new CellData(
				createImage("images/icons/i-checkbox.png"), "CheckBox", null), new CellData(
				createImage("images/icons/i-image.png"), "Label and Image", null), new CellData(
				createImage("images/icons/i-navigation.png"), "Navigation", null)
		// new CellData(createImage("images/icons/i-TODO.png"), "Popup", null)
				);
		// , "Slide"

		initDataSource(tableDS);
	}

	private SimplePanel createImage(String url) {
		SimplePanel img = new SimplePanel();
		img.setSize("30px", "30px");
		img.getElement().getStyle().setProperty("backgroundImage", "url('" + url + "')");
		return img;
	}

	@Override
	public void onRowSelected(int indexSelected, CellData cellDataSelected, XTableCell tableCell) {

		if (indexSelected == 0) {
			// getNavigationController().pushController(new DragViewController(),
			// true);
			getNavigationController().pushController(new ListController(), true);

		} else if (indexSelected == 1) {
			getNavigationController().pushController(new SliderController(), true);

		} else if (indexSelected == 2) {
			getNavigationController().pushController(new RadioButtonController(), true);

		} else if (indexSelected == 3) {
			getNavigationController().pushController(new ButtonsController(), true);

		} else if (indexSelected == 4) {
			getNavigationController().pushController(new PickerController(), true);

		} else if (indexSelected == 5) {
			getNavigationController().pushController(new SwitchController(), true);

		} else if (indexSelected == 6) {
			getNavigationController().pushController(new FormController(), true);

		} else if (indexSelected == 7) {
			getNavigationController().pushController(new ProgressController(), true);

		} else if (indexSelected == 8) {
			getNavigationController().pushController(new CheckboxController(), true);

		} else if (indexSelected == 9) {
			getNavigationController().pushController(new LabelImageController(), true);

		} else if (indexSelected == 10) {
			getNavigationController().pushController(new NavigationBarController(), true);

		} else if (indexSelected == 11) {
			getNavigationController().pushController(new PopupController(), true);

		} else if (indexSelected == 100) {
			// getNavigationController().pushController(new SlideController(), true);

			// featuring RPC call
			helloRPC.sayHello("NEXT rocks!", new AsyncCallback<String>() {
				public void onFailure(Throwable e) {
					Window.alert("Error happened: " + e.getMessage());
				}

				public void onSuccess(String result) {
					Window.alert("Server said \"" + result + "\".");
				}
			});
		}

	}

	public String getGitPath() {
		return "/controller/widgets/WidgetsController";
	}

}
