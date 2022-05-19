package com.spring.arti.buble_sort;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bubble_sortController {



@RequestMapping(value = "/main2")
	public String Main() {
		return "bubblesort";
	}
	
	
	@RequestMapping(value = "/bubble")
	public String bubbleSort(@RequestParam("bubble") String str,Model model) {
		
		String[] arr=str.split(" "); // 받아온 값을 스플릿으로 배열에 저장
		int[] nums=new int[arr.length]; // 받아온 값이 문자열이므로 비교를 하기위해 정수로 형변환
		for (int i = 0; i < arr.length; i++) {
			nums[i]=Integer.parseInt(arr[i]);			
		}
		
		System.out.println("<버블정렬>");
		System.out.print("입력 ["); //입력된 데이터를 콜솔에 표시
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// 버블 정렬 - 인접한 앞 뒤 데이터를 비교해 적은 수를 앞으로 교환하는 정렬방식
		for(int i = 0; i < nums.length; i++) {
	        for(int j = 0 ; j < nums.length - i - 1 ; j++) {
	            if(nums[j] > nums[j+1]) { 
	                int temp = nums[j+1];
	                nums[j+1] = nums[j];
	                nums[j] = temp;
	            }// 인접한 앞 뒤 데이터를 비교해서 앞 데이터가 크면 뒤의 작은 데이터와 위치를 교환함
	        }
	    }
		System.out.println(" ");	
		System.out.println("출력 " + Arrays.toString(nums));	
		// 정렬된 데이터를 콘솔에 출력
		
		JSONObject bubble_json=new JSONObject(); // JSONObject 객체 생성
		bubble_json.put("Bubble_sort", nums); // json형식으로 결과데이터 입력
		model.addAttribute("bubble_json", bubble_json); // jsp로 보낼 데이터를 "coordinates_json"으로 jsp에서 인식
		
		return "bubblesort";
		
	}
}
