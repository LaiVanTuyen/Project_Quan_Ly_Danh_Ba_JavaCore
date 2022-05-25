package bkap.tesst;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bkap.io.SerializeFileFactory;
import bkap.model.Contact;

public class tesst {
	static HashMap<Integer, Contact> csdl = new HashMap<Integer, Contact>();
	public static void menu() {
		System.out.println("*================= MENU =================*");
		System.out.println("* 1. Thêm                                *");
		System.out.println("* 2. Xuất                                *");
		System.out.println("* 3. Sửa                                 *");
		System.out.println("* 4. Xóa                                 *");
		System.out.println("* 5. Tìm                                 *");
		System.out.println("* 6. Sắp xếp                             *");
		System.out.println("* 7. lưu File                            *");
		System.out.println("* 8. Đọc File                            *");
		System.out.println("* 9. Thoát                               *");
		System.out.println("*========================================*");
		System.out.print("Nhập lựa chọn của bạn:");
		int choice = new Scanner(System.in).nextInt();
		switch (choice) {
		case 1:
			Them();
			break;
		case 2:
			Xuat();
			break;
		case 3:
			Sua();
			break;
		case 4:
			Xoa();
			break;
		case 5:
			Tim();
			break;
		case 6:
			SapXep();
			break;
		case 7:
			LuuFile();
			break;
		case 8:
			DocFile();
			break;
		case 9:System.exit(0);

		default:
			System.err.println("chọn đúng từ 1 -> 9");
			break;
		}
	}

	private static void Tim() {
		// TODO Auto-generated method stub
		System.out.println("nhập phone");
		String phone = new Scanner(System.in).nextLine();
		for (Map.Entry<Integer, Contact> item : csdl.entrySet()) {
			if (item.getValue().getPhone().startsWith(phone)) {
				System.out.println(item.getValue());
			}

		}

	}

	private static void DocFile() {
		// TODO Auto-generated method stub
		csdl = SerializeFileFactory.readfile("E:\\\\BKAP\\\\Java Core\\\\Chuong10_datientrinh\\\\data.txt");

	}

	private static void LuuFile() {
		// TODO Auto-generated method stub
		SerializeFileFactory.saveFile(csdl, "E:\\BKAP\\Java Core\\Chuong10_datientrinh\\data.txt");

	}

	private static void SapXep() {
		// TODO Auto-generated method stub
		System.out.println("Sắp xếp theo:");
		System.out.println("1. sắp xếp theo tên");
		System.out.println("2. sắp xếp theo mã");
		System.out.println("3. sắp xếp theo phone");
		System.out.println("nhập lựa chọn:");
		int choice = new Scanner(System.in).nextInt();
		switch (choice) {
		case 1:
			sapxeptheoten();
			break;
		case 2:
			sapxeptheoma();
			break;
		case 3:
			sapxeptheophone();
			break;

		default:
			break;
		}
	}

	private static void sapxeptheophone() {
		// TODO Auto-generated method stub
		
	}

	private static void sapxeptheoma() {
		// TODO Auto-generated method stub
		
	}

	private static void sapxeptheoten() {
		// TODO Auto-generated method stub
		
	}

	private static void Xoa() {
		// TODO Auto-generated method stub
		System.out.println("nhập mã muốn xóa:");
		int ma= new Scanner(System.in).nextInt();
		if (csdl.containsKey(ma)) {
			csdl.remove(ma);
		}else {
			System.out.println("không tìm thấy mã để xóa");
		}

	}

	private static void Sua() {
		// TODO Auto-generated method stub
		System.out.println("nhập mã muốn sửa:");
		int ma = new Scanner(System.in).nextInt();
		if (csdl.containsKey(ma)) {

			System.out.println("nhập tên:");
			String name = new Scanner(System.in).nextLine();
			System.out.println("nhập phone:");
			String phone = new Scanner(System.in).nextLine();

			Contact c = new Contact(ma, name, phone);
			csdl.put(ma, c);
		}else {
			System.out.println("ma "+ma+"không tồn tại");
		}

	}

	private static void Xuat() {
		// TODO Auto-generated method stub
		System.out.println("danh sách danh bạ:");
		for (Map.Entry<Integer, Contact> item : csdl.entrySet()) {
			System.out.println(item.getValue());
		}

	}

	private static void Them() {
		// TODO Auto-generated method stub
		System.out.println("nhập mã:");
		int ma = new Scanner(System.in).nextInt();
		System.out.println("nhập tên:");
		String name = new Scanner(System.in).nextLine();
		System.out.println("nhập phone:");
		String phone = new Scanner(System.in).nextLine();

		Contact c = new Contact(ma, name, phone);
		if (csdl.containsKey(c.getId())== false) {
			csdl.put(c.getId(), c);
		}

	}
	public static void main(String[] args) {
		while (true) {
			menu();
		}
	}
}
