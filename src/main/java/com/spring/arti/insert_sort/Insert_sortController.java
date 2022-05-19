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
		
		// ���� ���� - ���ϰ��� �ϴ� �����Ϳ� �� ������ �����͵�� ���Ͽ� ��ġ�� ��ȯ�ϴ� ���Ĺ��
		for (int i = 1; i< nums.length; i++) {
			
			int temp = nums[i];//���ϰ��� �ϴ� ������
		
			int prev = i - 1; 

			while(prev >= 0 && nums[prev] > temp) {// �� �����Ͱ� ���� �����ͺ��� Ŭ �� ���� �ݺ�
		
				nums[prev + 1] = nums[prev]; // ���� �����͸� �� ĭ�� �ڷ� �̷�
			
				prev--;
			}

			nums[prev + 1] = temp;
		}
		System.out.println(" ");	
		System.out.println("��� " + Arrays.toString(nums));
		// ���ĵ� �����͸� �ֿܼ� ���
		
		JSONObject insert_json=new JSONObject(); // JSONObject ��ü ����
		insert_json.put("insert_sort", nums); // json�������� ��������� �Է�
		model.addAttribute("insert_json", insert_json); // jsp�� ���� �����͸� "coordinates_json"���� jsp���� �ν�
		
		return "insertsort";
	}
	
}
