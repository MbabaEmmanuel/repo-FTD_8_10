package day1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File file = new File("Student.txt");
		BufferedWriter writer = null;
		if (!file.exists()) {
			try {
				Student emmanuel = new Student("Emmanuel", "Georgia", "Atlanta");
				OutputStream out = new FileOutputStream(file);
				writer = new BufferedWriter(new OutputStreamWriter(out));
				writer.write(emmanuel.toString());
				System.out.println(emmanuel);

			}

			catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();

					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
			}
		} else {
			BufferedReader read = null;

			try {
				read = new BufferedReader(new FileReader(file));
				Student newStudent = new Student(read.readLine(), read.readLine(), read.readLine());
				System.out.println(newStudent);

			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				try {
					read.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
		}

	}

}
