package com.spring.arti.selection_sort;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Selection_sortController {



@RequestMapping(value = "/main1")
	public String Main() {
		return "selectionsort";
	}
	
	
	@RequestMapping(value = "/selection")
	public String selectionSort(@RequestParam("selection") String str,Model model) {
		// 받아온 값을 스플릿으로 배열에 저장 
		String[] arr=str.split(" ");
		int[] nums=new int[arr.length];
		// 받아온 값이 문자열이므로 비교를 하기위해 정수로 형변환
		for (int i = 0; i < arr.length; i++) {
			nums[i]=Integer.parseInt(arr[i]);			
		}
		//입력된 데이터를 콜솔에 표시
		System.out.println("<선택정렬>");
		System.out.print("입력 [");
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// 선택 정렬 - 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환한는 정렬방식
		for (int i = 0; i < nums.length - 1; i++) {

			int MinIndex = i; //처음 인덱스 부터 데이터를 선택하므로 MinIndex는 i로 지정

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[MinIndex] > nums[j])
					MinIndex = j;
			} // 탐색을 진행하며 가장 작은 데이터를 찾음

			int temp = nums[MinIndex];
			nums[MinIndex] = nums[i];
			nums[i] = temp; // 탐색이 완료되면 가장 작은 데이터를 가장 앞의 데이터와 위치를 바꿈
		}
		System.out.println(" ");	
		System.out.println("출력 " + Arrays.toString(nums));	
		// 정렬된 데이터를 콘솔에 출력
		
		JSONObject selection_json=new JSONObject(); // JSONObject 객체 생성
		selection_json.put("Selection_sort", nums); // json형식으로 결과데이터 입력 
		model.addAttribute("selection_json", selection_json); // jsp로 보낼 데이터를 "coordinates_json"으로 jsp에서 인식
		
		return "selectionsort";
	}
	
}
