package TestApple;



import io.restassured.response.Response;
import Apple.AddingProduct;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PayloadEndpoint {


	
@Test(priority=1)
 void ApiApple(){
		
		
		
		        AddingProduct.Data data =new AddingProduct.Data();
		        data.setYear(2023);
		        data.setPrice(7999.99);
		        data.setCpu_model("Apple ARM A7");
		        data.setHard_disk_size("1 TB");

		        
		        AddingProduct device = new AddingProduct();
		        device.setName("Apple Max Pro 1TB");
		        device.setData(data);
		       

		      
		        Response response = given()
		                .header("Content-Type", "application/json") 
		                .body(device) 
		                .when()
		                .post("https://api.restful-api.dev/objects"); 

		        
		        //response.prettyPrint();

		        
		        response.then()
		                .statusCode(200)
		        .body("name", equalTo("Apple Max Pro 1TB"))
                .body("data.year", equalTo(2023))
                .body("data.price", equalTo(7999.99f)) 
                .body("data.cpu_model", equalTo("Apple ARM A7"))
                .body("data.hard_disk_size", equalTo("1 TB"))
                .body("id", notNullValue()) 
                .body("createdAt", notNullValue());
		                
		


	}
}

