package com.knowledgepioneer.records.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowledgepioneer.records.entity.Records;


@RunWith(SpringRunner.class)
@SpringBootTest
class RecordsRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	ObjectMapper oM = new ObjectMapper();
	
	@BeforeEach
	private void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addRecordsTest() throws Exception {
		String expectedOutput = "Data is already present in the database";
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/populateDB").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
		
		String actualResult = result.getResponse().getContentAsString();
		
		assertEquals(expectedOutput, actualResult);
	}
	
	
	
	@Test
	public void getAllRecordsTest() throws Exception {
		String expectedResult = "[{\"id\":23,\"title\":\"Cleaning member for ink jet head and ink jet apparatus provided with said cleaning member\",\"year\":\"19960416\",\"country\":\"US\",\"absract\":\"A cleaning member comprising an ether series polyurethane rubber elastic body, the curing agent component of said ether series polyurethane rubber elastic body essentially consisting of a bifunctional component, or in addition, said ether series polyurethane rubber elastic body further containing a water repellency-adding material having an active group capable of chemically bonding to said polyurethane rubber.\"},{\"id\":24,\"title\":\"Pump station control system and method\",\"year\":\"19980420\",\"country\":\"US\",\"absract\":\"The pump station control system and method monitors and displays a time history of the operating parameters of a pump station.\\n      \\n      Sensed operating parameters are transmitted to an operator in real time and are stored at predetermined time intervals over a predetermined period of time.\\n      \\n      A real-time cost parameter of the system is calculated that provides a measure of the cost per throughput of the material being pumped.\\n      \\n      The system can be optimized for the cost parameter by controlling system variables such as pump speed in response to the level of fluid.\"},{\"id\":25,\"title\":\"Filtering device\",\"year\":\"19980330\",\"country\":\"US\",\"absract\":\"A filtering device includes a container having an inlet for introducing liquid to be treated, a screen provided in the container having an outlet for delivering out treated liquid, and flow creating means for creating, in said container, a flow of the liquid to be treated having a direction which is different from direction of a flow of the liquid to be treated into the screen.\"},{\"id\":26,\"title\":\"Method for operating an array of video storage units\",\"year\":\"19970606\",\"country\":\"US\",\"absract\":\"A method for increasing the storage capacity of a video server which utilizes an array of disks is disclosed.\\n      \\n      The server is operated so that the continuity of a plurality of bit streams is maintained.\\n      \\n      The inventive method has advantageous characteristics with respect to storage capacity, streaming capacity, start-up latency of new streams, amount of required buffer capacity, scalability, reliability and multiple bit rates.\"}]";
		MvcResult result = mockMvc.perform(get("/api/records").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
		String actualResult = result.getResponse().getContentAsString();

//		System.out.println(resultContent);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getRecordTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/records/27").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		
		Records record = oM.readValue(resultContent, Records.class);
		
		assertEquals(21, record.getId());

	}
	
	@Ignore
	@Test
	public void deleteRecordsTest() throws Exception{
		String id = "29"; 
		String expectedOutput = "Deleted record with id - " + id;
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/records/" + id).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String actualOutput = result.getResponse().getContentAsString();
		
		assertEquals(expectedOutput, actualOutput);
	}
	
}

