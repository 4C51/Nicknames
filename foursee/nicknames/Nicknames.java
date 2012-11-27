package foursee.nicknames;

import java.util.logging.Logger;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import foursee.nicknames.CommonProxy;
import foursee.nicknames.NickHandler;
import foursee.nicknames.NickColor;

@Mod(modid="Nicknames", name="Nicknames", version="0.1.0")
@NetworkMod(clientSideRequired=false, serverSideRequired=false)
public class Nicknames {
	public static final String ID = "Nicknames";

    // The instance of your mod that Forge uses.
	@Instance("Nicknames")
	public static Nicknames instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="foursee.nicknames.CommonProxy", serverSide="foursee.nicknames.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		logger = Logger.getLogger(ID);
		logger.setParent(FMLLog.getLogger());
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		logger.info("Registered NickHandler with Forge.");
		NetworkRegistry.instance().registerChatListener(new NickHandler(logger));
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}

}
