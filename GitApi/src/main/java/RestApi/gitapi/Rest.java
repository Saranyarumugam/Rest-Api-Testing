package RestApi.gitapi;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Rest {
    public CloseableHttpResponse Response;
	//GET Method
	public CloseableHttpResponse getMethod(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient	httpclient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet(url);
	
	//Response of the Get method
	Response = httpclient.execute(httpget);
	return Response;
	}
	
}
