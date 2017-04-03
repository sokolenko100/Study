package server_HTTP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpPrincipal;

public class SimpleHttpServer  
{
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8080);
		System.out.println("Listening for connection on port 8080 ....");
		while (true)
		{ try (Socket socket = server.accept())
			{ Date today = new Date();
			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today; 
			socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			}
		}










//		HttpServer server = HttpServer.create();
//		server.bind(new InetSocketAddress(8765), 0);
//
//		HttpContext context = server.createContext("/", new EchoHandler());
//		context.setAuthenticator(new Auth());
//
//		server.setExecutor(null);
		//server.start();
	}

	static class EchoHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			StringBuilder builder = new StringBuilder();

			builder.append("<h1>URI: ").append(exchange.getRequestURI()).append("</h1>");

			Headers headers = exchange.getRequestHeaders();
			for (String header : headers.keySet()) {
				builder.append("<p>").append(header).append("=")
				.append(headers.getFirst(header)).append("</p>");
			}

			byte[] bytes = builder.toString().getBytes();
			exchange.sendResponseHeaders(200, bytes.length);

			OutputStream os = exchange.getResponseBody();
			os.write(bytes);
			os.close();
		}
	}

	static class Auth extends Authenticator
	{
		@Override
		public Result authenticate(HttpExchange httpExchange) {
			if ("/forbidden".equals(httpExchange.getRequestURI().toString()))
				return new Failure(403);
			else

				return new Success(new HttpPrincipal("c0nst", "realm"));
		}
	}/// http://localhost:8765/some-url
}
