package conege.spiral6.conegetts;

import javax.speech.EngineException;

import conege.spiral6.conegetts.Commands.TTSCommand;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid=Base.MODID, name=Base.MODNAME, version=Base.MODVER) //Tell forge "Oh hey, there's a new mod here to load."
public class Base //Start the class Declaration
{
    //Set the ID of the mod (Should be lower case).
    public static final String MODID = "conegetts";
    //Set the "Name" of the mod.
    public static final String MODNAME = "Conege TTS";
    //Set the version of the mod.
    public static final String MODVER = "0.0.0";
    
    @SidedProxy(clientSide="conege.spiral6.conegetts.ClientProxy", serverSide="conege.spiral6.conegetts.ServerProxy")
    public static CommonProxy proxy;

    @Instance
    public static Base instance = new Base();
        
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) throws EngineException
    {
      event.registerServerCommand(new TTSCommand());
    }
    
    
    
    
}
