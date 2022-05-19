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
		
		String[] arr1=str.split(" "); // �޾ƿ� ���� ���ø����� �迭�� ����
		int[] nums=new int[arr1.length]; // �޾ƿ� ���� ���ڿ��̹Ƿ� �񱳸� �ϱ����� ������ ����ȯ
		for (int i = 0; i < arr1.length; i++) {
			nums[i]=Integer.parseInt(arr1[i]);			
		}
		
		System.out.println(" ");
		System.out.println("<���Ž��>");
		System.out.print("�Է� ["); //�Էµ� �����͸� �ݼֿ� ǥ��
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		
		int length = 5;
	    // 5���� �ڿ���
	    int[] arr = new int[length];
	    int min = 1;

	    // �ڿ��� �Է�. 100���� �۰ų� ���� ���� �ٸ� �ڿ���
	   

	    int cnt = 0;
	    while (true) {  // ���� �� �ִ� ���� ū ���� 100 * 99 * 98 = 970,200
	      for (int i = 0; i < nums.length; i++) {
	        if (min % nums[i] == 0) cnt++;
	      }

	      if (cnt >= 3) break; // �� �� �̻��� �ڿ����� ���������� ��� �ݺ��� Ż��

	      cnt = 0;
	      min++;
	    }
	    System.out.println(" ");
	    System.out.println("��� [" + min + "]");
	    // ��� �����͸� �ֿܼ� ���
	    
	    
	    JSONObject multiple_json=new JSONObject(); // JSONObject ��ü ����
			multiple_json.put("multiple_json", min); // json�������� ��������� �Է�
			model.addAttribute("multiple_json", multiple_json); // jsp�� ���� �����͸� "coordinates_json"���� jsp���� �ν�
			
			return "multiplefind";
	  }
	
	     
			

	  

	}
	

