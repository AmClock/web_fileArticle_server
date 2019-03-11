package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.Article;

public class FileDAO {

	int seq = 0;

	public static File makeFile(String path) {
		String fileUrl = path + "/article.csv";
		File file = new File(fileUrl);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // try~catch end
		return file;
	}// makeFile end

	public void writeFile(String path, Article article) {
		try {
			FileOutputStream fos = new FileOutputStream(FileDAO.makeFile(path), true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "EUC-KR");
			BufferedWriter bw = new BufferedWriter(osw);
			String insetText = (seq + 1) + "," + article.getTitle() + "," + article.getText() + "," + writeDate()
					+ "\n";
			bw.write(insetText);
			bw.flush();
			bw.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}// writeFile end

	public List<Article> readList(String path) {
		List<Article> list = new ArrayList<Article>();
		try {
			FileInputStream fis = new FileInputStream(FileDAO.makeFile(path));
			InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
			BufferedReader br = new BufferedReader(isr);
			String tempStr = null;
			while ((tempStr = br.readLine()) != null) {
				String[] comaArr = tempStr.split(",");
				Article article = new Article(Integer.parseInt(comaArr[0]), comaArr[1], comaArr[2], comaArr[3]);
				list.add(article);
				seq = Integer.parseInt(comaArr[0]);
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}// readFile end

	public Article readDetail(int no, String path) {
		Article article = null;
		try {
			FileInputStream fis = new FileInputStream(FileDAO.makeFile(path));
			InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
			BufferedReader br = new BufferedReader(isr);
			String tempStr = null;
			while ((tempStr = br.readLine()) != null) {
				String[] comaArr = tempStr.split(",");
				if (Integer.parseInt(comaArr[0]) == no) {
					article = new Article(no, comaArr[1], comaArr[2], comaArr[3]);
					br.close();
					break;
				} // if end
			} // while end
		} catch (Exception e) {
			// TODO: handle exception
		} // try ~ catch end
		return article;
	}// readDetail end

	public void updateForm(String path, Article article) {
		String dumy = "";
		try {
			FileInputStream fis = new FileInputStream(FileDAO.makeFile(path));
			InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
			BufferedReader br = new BufferedReader(isr);
			String tmpStr = null;
			while ((tmpStr = br.readLine()) != null) {
				String comaArr[] = tmpStr.split(",");
				if (Integer.parseInt(comaArr[0]) != article.getNo()) {
					dumy += (tmpStr + "\n");
				} else {
					dumy += article.getNo() + "," + article.getTitle() + "," + article.getText() + "," + writeDate()
							+ "\n";
				} // if else end
			} // while end
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		try {
			FileOutputStream fos = new FileOutputStream(FileDAO.makeFile(path));
			OutputStreamWriter osw = new OutputStreamWriter(fos, "EUC-KR");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(dumy);
			System.out.println("success");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
	}// updateForm end

	public void deleteLine(int no, String path) {
		String dumy = "";
		try {
			FileInputStream fis = new FileInputStream(FileDAO.makeFile(path));
			InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
			BufferedReader br = new BufferedReader(isr);
			String tmpStr = null;
			while ((tmpStr = br.readLine()) != null) {
				String[] comaArr = tmpStr.split(",");
				if (no != Integer.parseInt(comaArr[0])) {
					dumy += (tmpStr + "\n");
				} // if end
			} // while end
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // try~catch end
		try {
			FileOutputStream fos = new FileOutputStream(FileDAO.makeFile(path));
			OutputStreamWriter osw = new OutputStreamWriter(fos, "EUC-KR");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(dumy);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
	}// deleteLine end

	public String writeDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
	}// writeDate end

}// FileUtil end
