package com.spring.arti.multiple_find;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Multiple_findController {



@RequestMapping(value = "/main5")
	public String Main() {
		return "multiplefind";
	}
	
	
	@RequestMapping(value = "/multiple")
	public String multiplefind(@RequestParam("multiple") String str,Model model) {
		
		String[] arr1=str.split(" "); // 받아온 값을 스플릿으로 배열에 저장
		int[] nums=new int[arr1.length]; // 받아온 값이 문자열이므로 비교를 하기위해 정수로 형변환
		for (int i = 0; i < arr1.length; i++) {
			nums[i]=Integer.parseInt(arr1[i]);			
		}
		
		System.out.println(" ");
		System.out.println("<배수탐색>");
		System.out.print("입력 ["); //입력된 데이터를 콜솔에 표시
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		
		int length = 5;
	    // 5개의 자연수
	    int[] arr = new int[length];
	    int min = 1;

	    // 자연수 입력. 100보다 작거나 같은 서로 다른 자연수
	   

	    int cnt = 0;
	    while (true) {  // 나올 수 있는 가장 큰 값은 100 * 99 * 98 = 970,200
	      for (int i = 0; i < nums.length; i++) {
	        if (min % nums[i] == 0) cnt++;
	      }

	      if (cnt >= 3) break; // 세 개 이상의 자연수로 나누어지는 경우 반복문 탈출

	      cnt = 0;
	      min++;
	    }
	    System.out.println(" ");
	    System.out.println("출력 [" + min + "]");
	    // 결과 데이터를 콘솔에 출력
	    
	    
	    JSONObject multiple_json=new JSONObject(); // JSONObject 객체 생성
			multiple_json.put("multiple_json", min); // json형식으로 결과데이터 입력
			model.addAttribute("multiple_json", multiple_json); // jsp로 보낼 데이터를 "coordinates_json"으로 jsp에서 인식
			
			return "multiplefind";
	  }
	
	     
			

	  

	}
	

