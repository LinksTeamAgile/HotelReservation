package com.links.ressys;

import com.links.ressys.controller.*;
import com.links.ressys.gui.*;


public class Main {
	
	public static void main(String[] args) {
		Sys sys = new Sys();
		Gui gui = new GuiBash();
		Controller cntrl = new ControllerConcrete(sys, gui);
		cntrl.start();
	}
	
}

