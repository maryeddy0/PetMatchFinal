package com.petmatch.PetMatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petmatch.PetMatch.entity.Pets;

@Controller
public class PetController {
	@Value("${pet.key}")
	String petKey;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView index() {
		String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImE0ZGQyZjUwMmU2NTEyMjljY2ZlNmFlZTgyZGVlMDM0MWFlYTdjNTgzZTkwMTllMTJkMjAzYWYxZmMxNGQzYTlhNjhhMWNiNDAxNjVjZTA0In0.eyJhdWQiOiJTRmhDWmN4SXZXTjJlYTYxS2paSUlHSlZabXdyMG44U1N0SGo4SGtJRDJwSXR3Uk16eiIsImp0aSI6ImE0ZGQyZjUwMmU2NTEyMjljY2ZlNmFlZTgyZGVlMDM0MWFlYTdjNTgzZTkwMTllMTJkMjAzYWYxZmMxNGQzYTlhNjhhMWNiNDAxNjVjZTA0IiwiaWF0IjoxNTYwNTQwNDA3LCJuYmYiOjE1NjA1NDA0MDcsImV4cCI6MTU2MDU0NDAwNywic3ViIjoiIiwic2NvcGVzIjpbXX0.dWlD7spIR9zkcqt8MW9Exk2YwTYeBYB3YXjeZnMojZ1lxe4v50xN7Y3aVHy_vmtkfYfkvX8hhydnNJvDroeU7lqi-umHVDJWUzPrVdBxKTXAzwWoDXxXhenr8HoCqIPOEtlmPjuWusdQu5wqHb21t3nEOG0OzEIRywnyjy_YP6Mh9HmHHRg2qnJTHnOmzsrpMXqHTn33aYS-0oiOzGZhRX4IZHv-E7gVUhIIJplnL_bPAwLII0cG4geFGU2O3PlqIEFC5DQGJKQ0dr80esZo4nbHTUdFw0WEMhSWV5KMxOr6zUd3E_qLCif5CLZpqh0stdbWfd24yJdSxUS4K5rfuw\r\n" + 
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjViYTA3M2ZkMjQ2ODYzNTAxMTYwYWNlMzYzNDNhZDA4YjQ2MDQwY2U3NzFmZTBmYzY3NmQwZGM1ZDY1M2ZiODM4N2FkNTVkNjIxMWQ4YmFhIn0.eyJhdWQiOiJTRmhDWmN4SXZXTjJlYTYxS2paSUlHSlZabXdyMG44U1N0SGo4SGtJRDJwSXR3Uk16eiIsImp0aSI6IjViYTA3M2ZkMjQ2ODYzNTAxMTYwYWNlMzYzNDNhZDA4YjQ2MDQwY2U3NzFmZTBmYzY3NmQwZGM1ZDY1M2ZiODM4N2FkNTVkNjIxMWQ4YmFhIiwiaWF0IjoxNTYwNTQwNDEzLCJuYmYiOjE1NjA1NDA0MTMsImV4cCI6MTU2MDU0NDAxMywic3ViIjoiIiwic2NvcGVzIjpbXX0.c_7CTFA25UCzq02E6JjYqxJX8YJy2PLm6VTQA8oloysFBCPW6XLap9yL2-2z6xG3FmA7EdmLs7ge8j--tbp-TalyyFpAyJVnZDIo6MIIeH6UMGI9xs-9986lgaLMzFh5HCE8kjq-gm8iWFk5UflPReae7fmmCiHLNrXd-5NqRLkCCNXcRkZxe_FIExbNEwHkA3N7azhstxkni9fXC82dDxDNOudAAYcR2RlqBj75qqGzjuHdrUq5NUhhHUTLZeQ0Ba8W8DOapXPLEmfIoCnlC4-YHmXyYoFgQmYPjfbbBse2xR0VCPJcD64aBxqIU92Le1n79fChr6w0ojJ3Qt7H2Q\r\n" + 
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjE0ODZlY2U4YTc5MzA4N2JiNDRmOTQ2YzMzYjQwMDQ5NDYzZDIyNjM0NmQzZjBhNTAzNjY5MTFmYmEzNjJkNGZlNmJiZmQ3MjIxZTEzZDZjIn0.eyJhdWQiOiJTRmhDWmN4SXZXTjJlYTYxS2paSUlHSlZabXdyMG44U1N0SGo4SGtJRDJwSXR3Uk16eiIsImp0aSI6IjE0ODZlY2U4YTc5MzA4N2JiNDRmOTQ2YzMzYjQwMDQ5NDYzZDIyNjM0NmQzZjBhNTAzNjY5MTFmYmEzNjJkNGZlNmJiZmQ3MjIxZTEzZDZjIiwiaWF0IjoxNTYwNTQwNDI4LCJuYmYiOjE1NjA1NDA0MjgsImV4cCI6MTU2MDU0NDAyOCwic3ViIjoiIiwic2NvcGVzIjpbXX0.R0MiEQalQO8KAKl0lBQzr83CkPejadjfH3TR9sYxrqKhucXu_n021Kbd9QUo634vP0Zy8BGnNgSgbM2hkQa2JzLR1awRSZnbbjTeXwP7BAdSFTfvoeoSX7DPdfVc--UNIA-Q3ZERIrgyI-SggM1YsZclZwDbzkr1UyCm8cO-7x27OOCP5Wb05GZu05vmVmCi_QNaDYSc9XPLoNipl29QXy_LMSI_Q7_B1NSCqgFEXdYUMhRqyGspOTPgFh5tvR3dyIOgkaryC60-HxBnOx3Mln8ZkEeMMch3sOL8t39aua3ccMI90x5IHErW1DHYHc6J4Nlpf4pqIZjNOFZCQaoFTg";
			
		Map<String, String> params = new HashMap<>();
		params.put("grant_type", "client_credentials");
		// client_id and the client_secret (key) is required for the request to get the access token
		params.put("client_id", "SFhCZcxIvWN2ea61KjZIIGJVZmwr0n8SStHj8HkID2pItwRMzz");
		params.put("client_secret", "3I7pl4iCM8xxiFGdECsaMRMg0flTh4XCKu8wcQLJ");
		
		RestTemplate rt = new RestTemplate();
		// we used the postForObject() method because this request is a POST in the Github documentation
		Map<String, String> response = rt.postForObject("https://api.petfinder.com/v2/oauth2/token", params, Map.class);
		System.out.println(response.get("acesstoken"));
		
		String url="https://api.petfinder.com/v2/"+token;
		Pets ps = rt.getForObject(url, Pets.class);	
		System.out.println(ps.getPagenation());
		return new ModelAndView("index");
	}
	
}
