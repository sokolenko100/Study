package chat;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/massage")
public class ChatTest {
	
	static String story = "";

	@GET
	@Path("/{userMasseges}/")
	@Produces("text/plain")
	public 	Response getUser(@PathParam("userMasseges") String userMasseges)
	{
		story+=userMasseges+"\n";
		System.out.println(story);
		return	Response.status(200).entity(story).header("Access-Control-Allow-Origin", "*").build();
	}
}

