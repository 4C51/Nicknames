package foursee.nicknames;

import java.util.logging.Logger;

import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet3Chat;
import cpw.mods.fml.common.network.IChatListener;

public class NickHandler implements IChatListener {
	
	private Logger logger;

	public NickHandler(Logger logger) {
		this.logger = logger;
		// Initialize
	}
	
	@Override
	public Packet3Chat serverChat(NetHandler handler, Packet3Chat message) {
		// TODO Auto-generated method stub
		logger.info("Messsage recieved to serverChat()");
		logger.info(message.message);
		Packet3Chat nickmessage = new Packet3Chat("<Test>" + message.message, false);
		return nickmessage;
	}

	@Override
	public Packet3Chat clientChat(NetHandler handler, Packet3Chat message) {
		// TODO Auto-generated method stub
		logger.info("Message recieved to clientChat()");
		logger.info(message.message);
		return message;
	}

}
