package com.links.ressys.controller;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

public abstract class Controller {
	
	protected Sys sys;
	protected Gui gui;
	
	public Controller(Sys sys, Gui gui){
		this.sys = sys;
		this.gui = gui;
	}
	
	public abstract void start();

}
