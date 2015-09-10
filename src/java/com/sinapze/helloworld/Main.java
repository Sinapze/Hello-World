package com.sinapze.helloworld;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

//declaration that tells forge mod loader that this is a mod, with a modid, name, and version
@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	//set the modid, modname, and version. Read above and referenced elsewhere
	public static final String MODID = "helloworld";
	public static final String MODNAME = "Hello World";
	public static final String VERSION = "0.1";
	
	@Instance//makes a new instance of the mod so we can actually use it
	public static Main instance = new Main();
	
	//create a proxy which determines whether the mod is running on client or server side
	@SidedProxy(clientSide= "com.sinapze.helloworld.ClientProxy", serverSide="com.sinapze.helloworld.ServerProxy")
	public static CommonProxy proxy; //actually makes the proxy
	
	//self explanatory, pre-initialization. Put
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
		System.out.println("Pre-Initialization Start");
	}
	
	//self explanatory, initialization. Put
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		System.out.println("Initialization Start");
	}
	
	//self explanatory, post-initialization. Put
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		System.out.println("Post-Initialization Start");
	}
}
