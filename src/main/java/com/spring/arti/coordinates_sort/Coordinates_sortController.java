package com.spring.arti.coordinates_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Coordinates_sortController {



@RequestMapping(value = "/main4")
	public String Main() {
		return "coordinatessort";
	}
	
	
	@RequestMapping(value = "/coordinates")
	public String coordinatesSort(@RequestParam("coordinates") String str,Model model) {
		// (2,6),(1,-1),(3,6),(-2,1),(1,3) 처럼 값을 받아와 ","를 기준으로 나누고 1차원 배열에 넣는다.
		String[] arr=str.split(",");
		
		System.out.println("<좌표정렬>");
		System.out.print("입력 [");//입력된 데이터를 콜솔에 표시
		for(String i:arr) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// 위에서 ","를 기준으로 나누고 남아있는 "(",")"를 replaceAll()메서드를 이용해 제거한다.
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i].replaceAll("[()]", "");  
		}
		
		
		// String으로 입력받은 좌표값을 서로 비교하여 정렬하기 위해 int타입으로 형변환
		int[] k=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			k[i]=Integer.parseInt(arr[i]);	
//			System.out.print(k[i] + " ");
		}
		
		// 1차원 배열에 있는 값들을 좌표 위치에 맞게 2차원배열에 넣기
		int num[][]=new int[k.length/2][2]; // 1차원 배열을 2열로 만들면 행이 절반이 되므로 길이를 반으로 나눈다. 5행2열
		for(int i=0;i<k.length/2;i++) { // 5행
			for(int j=0;j<(i+1)*2;j++) { // j<(i+1)*2 -> 각 행마다 2열이므로 두 번씩 값을 넣고 다음 행으로 넘어가야함. ex) i=0(1행) (k[0],k[1]) / i=1(2행) (k[2],k[3])
				if(j%2==0) { // j가 짝수일 때 각 행 1열에 값을 넣는다. 제로베이스라 k[0]부터 시작이므로 짝수부터 들어간다	
						num[i][0]=k[j];
				}
				if(j%2==1) { // j가 홀수일 때 각 행 2열에 값을 넣는다.			
						num[i][1]=k[j];				
				}
				}
			}
				
		Arrays.sort(num,new Comparator<int[]>() { //Comparator 인터페이스 재정의

			@Override
			public int compare(int[] o1, int[] o2) {
				
					
				 if(o1[0]==o2[0]){// x좌표의 값이 같다면 y좌표를 기준으로 정렬		
					return Integer.compare(o1[1], o2[1]);
				 }
					return Integer.compare(o1[0], o2[0]); // 나머지는 x좌표를 기준으로 정렬
			
			}		
			
		});
		
		String[] result=new String[5]; // 출력 예시에 맞추기 위해 String 배열로 결과값을 만든다.
		for(int i=0;i<num.length;i++) {
			
			result[i]="("+num[i][0]+","+num[i][1]+")";  // int 배열에는 정수만 들어가므로 이런식으로 넣을 수가 없다.

	}
		
		
		JSONObject coordinates_json=new JSONObject(); // JSONObject 객체 생성
		coordinates_json.put("coordinates_json", result); // json형식으로 결과데이터 입력 
		model.addAttribute("coordinates_json", coordinates_json); // jsp로 보낼 데이터를 "coordinates_json"으로 jsp에서 인식
		
		return "coordinatessort";
	}
	
}
