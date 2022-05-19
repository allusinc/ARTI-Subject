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
		
		String[] arr=str.split(" "); // �޾ƿ� ���� ���ø����� �迭�� ����
		int[] nums=new int[arr.length]; // �޾ƿ� ���� ���ڿ��̹Ƿ� �񱳸� �ϱ����� ������ ����ȯ
		for (int i = 0; i < arr.length; i++) {
			nums[i]=Integer.parseInt(arr[i]);			
		}
		
		System.out.println("<��������>");
		System.out.print("�Է� ["); //�Էµ� �����͸� �ݼֿ� ǥ��
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// ���� ���� - ������ �� �� �����͸� ���� ���� ���� ������ ��ȯ�ϴ� ���Ĺ��
		for(int i = 0; i < nums.length; i++) {
	        for(int j = 0 ; j < nums.length - i - 1 ; j++) {
	            if(nums[j] > nums[j+1]) { 
	                int temp = nums[j+1];
	                nums[j+1] = nums[j];
	                nums[j] = temp;
	            }// ������ �� �� �����͸� ���ؼ� �� �����Ͱ� ũ�� ���� ���� �����Ϳ� ��ġ�� ��ȯ��
	        }
	    }
		System.out.println(" ");	
		System.out.println("��� " + Arrays.toString(nums));	
		// ���ĵ� �����͸� �ֿܼ� ���
		
		JSONObject bubble_json=new JSONObject(); // JSONObject ��ü ����
		bubble_json.put("Bubble_sort", nums); // json�������� ��������� �Է�
		model.addAttribute("bubble_json", bubble_json); // jsp�� ���� �����͸� "coordinates_json"���� jsp���� �ν�
		
		return "bubblesort";
		
	}
}
