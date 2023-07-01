package tvn.day1;

import java.util.Scanner;

class PhanSo {
    private int tu, mau;

    //Khai báo hàm tạo không tham số
    public PhanSo() {
    }

    //hàm tạo có đầy đủ tham số
    public PhanSo(int t, int m) {
        tu = t;
        mau = m;
    }

    //Khai báo hàm nhập
    void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tử: ");
        tu = input.nextInt();
        System.out.print("Nhập mẫu: ");
        mau = input.nextInt();
        if (mau == 0) {
            System.out.println("Mẫu số phải lớn hơn 0. Hãy nhập lại: ");
            mau = input.nextInt();
        }
        System.out.println("Nhập xong");
    }

    //Khai báo hàm Xuất
    void output() {
        System.out.println("Phân số: " + tu + "/" + mau);
    }

    //Xây dựng hàm tìm phân số tổng của 2 phân số
    void tongPhanSo(PhanSo p1, PhanSo p2) {
        PhanSo q = new PhanSo();
        q.tu = p1.tu * p2.mau + p1.mau * p2.tu;
        q.mau = p1.mau * p2.mau;
        System.out.println("Tổng: " + p1.tu + "/" + p1.mau + " + " + p2.tu + "/" + p2.mau + " = " + q.tu + "/" + q.mau);
    }

    //Xây dựng hàm so sánh 2 phân số
    void soSanh(PhanSo p1, PhanSo p2) {
        PhanSo q = new PhanSo();
        float tmp1 = (float) p1.tu / p1.mau;
        float tmp2 = (float) p2.tu / p2.mau;
        if (tmp1 > tmp2) {
            System.out.println("Phân số lớn hơn: " + p1.tu + "/" + p1.mau);
        } else if (tmp1 < tmp2) {
            System.out.println("Phân số lớn hơn:" + p2.tu + "/" + p2.mau);
        } else {
            System.out.println("Hai phân số bằng nhau");
        }
    }

    //Tìm phân số lớn nhất giữa 3 phân số. Xuất ra phân số kết quả.
    void soSanh3PhanSo(PhanSo p1, PhanSo p2, PhanSo p3) {

        PhanSo q = new PhanSo();

        float tmp1 = (float) p1.tu / p1.mau;
        float tmp2 = (float) p2.tu / p2.mau;
        float tmp3 = (float) p3.tu / p3.mau;
        float max = tmp1;
        if (tmp1 == tmp2 && tmp2 == tmp3) {
            System.out.print("3 phân số bằng nhau");
        }

        if (max < tmp2) {
            max = tmp2;
        }
        if (max < tmp3) {
            max = tmp3;
        }
        System.out.print("Phân số lớn nhất là " + max);
    }

    public static void main(String args[]) {
        PhanSo phanso = new PhanSo();
        PhanSo p1 = new PhanSo();
        PhanSo p2 = new PhanSo();
        PhanSo p3 = new PhanSo();
        p1.input();
        p2.input();
        p3.input();
        p1.output();
        p2.output();
        p3.output();
        phanso.tongPhanSo(p1, p2);
        phanso.soSanh(p1, p2);
        phanso.soSanh3PhanSo(p1, p2, p3);
    }
}