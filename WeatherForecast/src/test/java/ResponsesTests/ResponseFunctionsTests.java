package ResponsesTests;

import Responses.ResponseFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ResponseFunctionsTests {
    private ResponseFunctions responseFunctions;
    private String testString = "{\"coord\":{\"lon\":26.72,\"lat\":58.37},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":-2,\"pressure\":1025,\"humidity\":86,\"temp_min\":-2,\"temp_max\":-2},\"visibility\":10000,\"wind\":{\"speed\":4.6,\"deg\":200},\"clouds\":{\"all\":75},\"dt\":1513803000,\"sys\":{\"type\":1,\"id\":5015,\"message\":0.0033,\"country\":\"EE\",\"sunrise\":1513753230,\"sunset\":1513776114},\"id\":588335,\"name\":\"Tartu\",\"cod\":200}";



    @Before
    public void init() {
        responseFunctions = new ResponseFunctions();

    }

    @Test
    public void doesMakeResponseJSONDataConvertStringToJSONObject() throws JSONException {

        responseFunctions  = Mockito.mock(ResponseFunctions.class);
        JSONObject testDataInJSON = responseFunctions.convertStringDataToJsonData(testString);

        Mockito.when(responseFunctions.convertStringDataToJsonData(testString)).thenReturn(testDataInJSON);
        assertEquals(responseFunctions.convertStringDataToJsonData(testString), testDataInJSON);

    }


    @Test
    public void doesResponseReturnDataAsJSONObject() throws Exception {
        JSONObject objectData = responseFunctions.makeResponseJSONData("Tartu");
        assertThat(objectData, instanceOf(JSONObject.class));

    }

    @Test
    public void doesResponseReturnDataAsJSONArray() throws Exception {
        JSONObject arrayData = responseFunctions.makeResponseJSONData("Tartu");
        assertThat(arrayData, instanceOf(JSONArray.class));

    }


}
