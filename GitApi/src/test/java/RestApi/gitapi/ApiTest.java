package RestApi.gitapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ApiTest extends Base{

	public ApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Rest client= new Rest();
	public String url;
	public String apiurl;
	public String testurl;
	
	@BeforeTest
	public <RestClient> void getUrl() throws IOException {
		
		url = prop.getProperty("URL");
		
	}
	
	
	//1. Validate status code & search with q param
	@Test
	public void searchUrl() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL");
		testurl = url + apiurl;
		client.getMethod(testurl);
		int Statuscode = client.Response.getStatusLine().getStatusCode();
		System.out.println("Status code is:  "+Statuscode);
		Assert.assertEquals(Statuscode, 200);
		
		
	}
	
	//2. Validate search with q & sort param
	@Test
	public void searchSorted() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL1");
		testurl = url + apiurl;
		client.getMethod(testurl);
		int Statuscode = client.Response.getStatusLine().getStatusCode();
		System.out.println("Status code is:  "+Statuscode);
		Assert.assertEquals(Statuscode, 200);
	}
	
	//3. Validate search with q, sort & order param
	@Test
	public void searchOrdered() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL2");
		testurl = url + apiurl;
		client.getMethod(testurl);
		int Statuscode = client.Response.getStatusLine().getStatusCode();
		System.out.println("Status code is:  "+Statuscode);
		Assert.assertEquals(Statuscode, 200);
	}
	
	//4. Validate search for invalid url with status code 404
	@Test
	public void invalidCode() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL3");
		testurl = url + apiurl;
		client.getMethod(testurl);
		int Statuscode = client.Response.getStatusLine().getStatusCode();
		System.out.println("Status code is:  "+Statuscode);
		Assert.assertEquals(Statuscode, 404);
	}
	
	//5. validate json response of search url
	@Test
	public void jasonValidation() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL");
		testurl = url + apiurl;
		client.getMethod(testurl);
		String responseString = EntityUtils.toString(client.Response.getEntity(),StandardCharsets.UTF_8);
		JSONObject jsonobj = new JSONObject(responseString);
		//System.out.println("Response in JSON format  :" +jsonobj);
		Object Total = jsonobj.get("total_count");
		System.out.println("Total count is: "+Total);
		Assert.assertEquals(Total, 95188);
	}
	
	//6. validate header
	@Test
	public void headerValidation() throws ClientProtocolException, IOException {
		apiurl = prop.getProperty("serviceURL");
		testurl = url + apiurl;
		client.getMethod(testurl);
		
		Header[] header = client.Response.getAllHeaders();	
		HashMap<String, String> allHeader = new HashMap<String, String>();
		for (Header headerarray : header) {
			allHeader.put(headerarray.getName(), headerarray.getValue());
	}
		System.out.println("Headers:  "+allHeader);
		System.out.println("Headers lenght: "+header.length);	
		Assert.assertEquals(header.length, 22);
		}
	
}
