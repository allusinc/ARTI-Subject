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
		// �޾ƿ� ���� ���ø����� �迭�� ���� 
		String[] arr=str.split(" ");
		int[] nums=new int[arr.length];
		// �޾ƿ� ���� ���ڿ��̹Ƿ� �񱳸� �ϱ����� ������ ����ȯ
		for (int i = 0; i < arr.length; i++) {
			nums[i]=Integer.parseInt(arr[i]);			
		}
		//�Էµ� �����͸� �ݼֿ� ǥ��
		System.out.println("<��������>");
		System.out.print("�Է� [");
		for(int i:nums) {
			System.out.print(i+" ");
		}  System.out.print("]");
		
		// ���� ���� - ���� ���� �����͸� ã�� ���� ���� �����Ϳ� ��ȯ�Ѵ� ���Ĺ��
		for (int i = 0; i < nums.length - 1; i++) {

			int MinIndex = i; //ó�� �ε��� ���� �����͸� �����ϹǷ� MinIndex�� i�� ����

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[MinIndex] > nums[j])
					MinIndex = j;
			} // Ž���� �����ϸ� ���� ���� �����͸� ã��

			int temp = nums[MinIndex];
			nums[MinIndex] = nums[i];
			nums[i] = temp; // Ž���� �Ϸ�Ǹ� ���� ���� �����͸� ���� ���� �����Ϳ� ��ġ�� �ٲ�
		}
		System.out.println(" ");	
		System.out.println("��� " + Arrays.toString(nums));	
		// ���ĵ� �����͸� �ֿܼ� ���
		
		JSONObject selection_json=new JSONObject(); // JSONObject ��ü ����
		selection_json.put("Selection_sort", nums); // json�������� ��������� �Է� 
		model.addAttribute("selection_json", selection_json); // jsp�� ���� �����͸� "coordinates_json"���� jsp���� �ν�
		
		return "selectionsort";
	}
	
}
