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
		// (2,6),(1,-1),(3,6),(-2,1),(1,3) ó�� ���� �޾ƿ� ","�� �������� ������ 1���� �迭�� �ִ´�.
		String[] arr=str.split(",");
		
		System.out.println("<��ǥ����>");
		System.out.print("�Է� [");//�Էµ� �����͸� �ݼֿ� ǥ��
		for(String i:arr) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// ������ ","�� �������� ������ �����ִ� "(",")"�� replaceAll()�޼��带 �̿��� �����Ѵ�.
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i].replaceAll("[()]", "");  
		}
		
		
		// String���� �Է¹��� ��ǥ���� ���� ���Ͽ� �����ϱ� ���� intŸ������ ����ȯ
		int[] k=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			k[i]=Integer.parseInt(arr[i]);	
//			System.out.print(k[i] + " ");
		}
		
		// 1���� �迭�� �ִ� ������ ��ǥ ��ġ�� �°� 2�����迭�� �ֱ�
		int num[][]=new int[k.length/2][2]; // 1���� �迭�� 2���� ����� ���� ������ �ǹǷ� ���̸� ������ ������. 5��2��
		for(int i=0;i<k.length/2;i++) { // 5��
			for(int j=0;j<(i+1)*2;j++) { // j<(i+1)*2 -> �� �ึ�� 2���̹Ƿ� �� ���� ���� �ְ� ���� ������ �Ѿ����. ex) i=0(1��) (k[0],k[1]) / i=1(2��) (k[2],k[3])
				if(j%2==0) { // j�� ¦���� �� �� �� 1���� ���� �ִ´�. ���κ��̽��� k[0]���� �����̹Ƿ� ¦������ ����	
						num[i][0]=k[j];
				}
				if(j%2==1) { // j�� Ȧ���� �� �� �� 2���� ���� �ִ´�.			
						num[i][1]=k[j];				
				}
				}
			}
				
		Arrays.sort(num,new Comparator<int[]>() { //Comparator �������̽� ������

			@Override
			public int compare(int[] o1, int[] o2) {
				
					
				 if(o1[0]==o2[0]){// x��ǥ�� ���� ���ٸ� y��ǥ�� �������� ����		
					return Integer.compare(o1[1], o2[1]);
				 }
					return Integer.compare(o1[0], o2[0]); // �������� x��ǥ�� �������� ����
			
			}		
			
		});
		
		String[] result=new String[5]; // ��� ���ÿ� ���߱� ���� String �迭�� ������� �����.
		for(int i=0;i<num.length;i++) {
			
			result[i]="("+num[i][0]+","+num[i][1]+")";  // int �迭���� ������ ���Ƿ� �̷������� ���� ���� ����.

	}
		
		
		JSONObject coordinates_json=new JSONObject(); // JSONObject ��ü ����
		coordinates_json.put("coordinates_json", result); // json�������� ��������� �Է� 
		model.addAttribute("coordinates_json", coordinates_json); // jsp�� ���� �����͸� "coordinates_json"���� jsp���� �ν�
		
		return "coordinatessort";
	}
	
}
