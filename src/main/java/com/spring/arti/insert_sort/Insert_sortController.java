package com.spring.arti.insert_sort;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Insert_sortController {



@RequestMapping(value = "/main3")
	public String Main() {
		return "insertsort";
	}
	
	
	@RequestMapping(value = "/insert")
	public String insertSort(@RequestParam("insert") String str,Model model) {
		
		String[] arr=str.split(" "); // 받아온 값을 스플릿으로 배열에 저장
		int[] nums=new int[arr.length]; // 받아온 값이 문자열이므로 비교를 하기위해 정수로 형변환
		for (int i = 0; i < arr.length; i++) {
			nums[i]=Integer.parseInt(arr[i]);			
		}
		
		System.out.println("<삽입정렬>");
		System.out.print("입력 ["); //입력된 데이터를 콜솔에 표시
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// 삽입 정렬 - 비교하고자 하는 데이터와 그 이전의 데이터들과 비교하여 위치를 교환하는 정렬방식
		for (int i = 1; i< nums.length; i++) {
			
			int temp = nums[i];//비교하고자 하는 데이터
		
			int prev = i - 1; 

			while(prev >= 0 && nums[prev] > temp) {// 비교 데이터가 이전 데이터보다 클 때 까지 반복
		
				nums[prev + 1] = nums[prev]; // 이전 데이터를 한 칸씩 뒤로 미룸
			
				prev--;
			}

			nums[prev + 1] = temp;
		}
		System.out.println(" ");	
		System.out.println("출력 " + Arrays.toString(nums));
		// 정렬된 데이터를 콘솔에 출력
		
		JSONObject insert_json=new JSONObject(); // JSONObject 객체 생성
		insert_json.put("insert_sort", nums); // json형식으로 결과데이터 입력
		model.addAttribute("insert_json", insert_json); // jsp로 보낼 데이터를 "coordinates_json"으로 jsp에서 인식
		
		return "insertsort";
	}
	
}
