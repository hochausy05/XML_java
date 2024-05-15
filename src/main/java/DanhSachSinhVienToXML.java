import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class SinhVien {
    private String ten;
    private int tuoi;
    private double gpa;

    public SinhVien(String ten, int tuoi, double gpa) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gpa = gpa;
    }

    // Getters and setters
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

public class DanhSachSinhVienToXML {
    public static void main(String[] args) {
        List<SinhVien> danhSachSinhVien = new ArrayList<>();
        danhSachSinhVien.add(new SinhVien("Ho Chau Sy", 19, 3.5));
        danhSachSinhVien.add(new SinhVien("Le Quang Hien", 18, 3.7));
        danhSachSinhVien.add(new SinhVien("Nguyen Minh Hieu", 19, 3.2));

        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter("danh_sach_sinh_vien.xml"));

            // Bắt đầu ghi XML
            writer.writeStartDocument();
            writer.writeStartElement("danh_sach_sinh_vien");

            // Lặp qua danh sách sinh viên và ghi thông tin của từng sinh viên
            for (SinhVien sv : danhSachSinhVien) {
                writer.writeStartElement("sinh_vien");
                writer.writeAttribute("ten", sv.getTen());
                writer.writeAttribute("tuoi", String.valueOf(sv.getTuoi()));
                writer.writeAttribute("gpa", String.valueOf(sv.getGpa()));
                writer.writeEndElement();
            }

            // Kết thúc ghi XML
            writer.writeEndElement();
            writer.writeEndDocument();

            // Đóng writer
            writer.close();

            System.out.println("Danh sach sinh vien da duoc luu vao tep danh_sach_sinh_vien.xml");
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

